package com.zuoye.mobile.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuoye.pojo.TUser;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.Result;

@RestController
@RequestMapping("/user")
public class UserController {
/*
	//获取当前登录用户的用户名
	@RequestMapping("/getUsername")
	public Result getUsername(){
		try {
			TUser user=(TUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    return new Result(true, MessageConstant.GET_USERNAME_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
		}
	}*/
}
