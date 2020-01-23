package com.zuoye.mobile.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.zuoye.pojo.TMember;
import com.zuoye.service.MemberService;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.RedisMessageConstant;
import com.zuoye.utils.Result;

import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	JedisPool jedisPool;
	@Reference
	MemberService memberService;
	
	//登录
	@RequestMapping("/login")
	public Result login(HttpServletResponse response,@RequestBody Map map){
		String telephone = (String) map.get("telephone");
		String validateCode=(String) map.get("validateCode");
		//从redis中获取保存的验证码
		String validateCodeInRedis=jedisPool.getResource().get(telephone+RedisMessageConstant.SENDTYPE_LOGIN);
		if(validateCodeInRedis!=null && validateCode!=null && validateCode.equals(validateCodeInRedis)){
			//判断验证码输入是否正确
			//判断当前用户是不是会员
			TMember member=memberService.findByTelephone(telephone);
			if(member==null){
				//不是会员，自动完成注册
				member.setRegtime(new Date());
				member.setPhonenumber(telephone);
				memberService.add(member);
			}
			//向客户端写入cookid,内容为手机号
			Cookie cookie=new Cookie("login_member_telephone",telephone);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*30);
			response.addCookie(cookie);
			//将会员信息保存到redis
			String json = JSON.toJSON(member).toString();
			jedisPool.getResource().setex(telephone, 60*30, json);
			return new Result(true, MessageConstant.LOGIN_SUCCESS);
		}else{
			return new Result(false, MessageConstant.VALIDATECODE_ERROR);
		}
	}

}
