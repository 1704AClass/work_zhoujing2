package com.zuoye.mobile.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.JedisPool;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoye.service.OrderService;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.RedisMessageConstant;
import com.zuoye.utils.Result;
import com.zuoye.utils.SMSUtils;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Reference
	private JedisPool jedisPool;
	@Reference
	OrderService orderService;
	
	/*//在线体检预约
	@RequestMapping("/submit")
	public Result submit(@RequestBody Map map){
		String telphone=(String) map.get("telphone");
		//从redis椎间盘煤化工获取保存的验证码
		String validateCodeInRedis = jedisPool.getResource().get(telphone+RedisMessageConstant.SENDTYPE_ORDER);
		String validateCode=(String) map.get("validateCodeInRedis");
		
		//将用户输入的验证码和redis中对比
		if(validateCodeInRedis!=null && validateCode!=null && validateCode.equals(validateCodeInRedis)){
			 //如果比对成功，调用服务完成预约业务处理
            map.put("orderType", Order.ORDERTYPE_WEIXIN);//设置预约类型，分为微信预约、电话预约
            Result result = null;
            try{
                result = orderService.order(map);//通过Dubbo远程调用服务实现在线预约业务处理
            }catch (Exception e){
                e.printStackTrace();
                return result;
            }
            if(result.isFlag()){
                //预约成功，可以为用户发送短信
                try{
                    SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE,telephone, (String) map.get("orderDate"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return result;
        }else{
            //如果比对不成功，返回结果给页面
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }
*/
    //根据预约ID查询预约相关信息1
    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            Map map = orderService.findById(id);
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,map);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
        }
	}
}
