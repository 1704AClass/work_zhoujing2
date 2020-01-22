package com.zuoye.mobile.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoye.pojo.TSetmeal;
import com.zuoye.service.SetmealService;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.Result;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {

	@Reference
	SetmealService setmealService;
	
    //查询所有套餐
	@RequestMapping("/getSetmeal")
	public List<TSetmeal> getSetmeal(){
		return setmealService.getSetmeal();
	}
	//根据套餐Id查询套餐详情
	@RequestMapping("/findById")
	public Result findById(int id){
		try {
			TSetmeal tSetmeal=setmealService.findById(id);
			return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
		}
	}
}
