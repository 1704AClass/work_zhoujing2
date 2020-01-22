package com.zuoye.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoye.pojo.TCheckgroup;
import com.zuoye.service.CheckgroupService;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;
import com.zuoye.utils.Result;

@RestController
@RequestMapping("/checkgroup")
public class CheckgroupController {

	@Reference
	CheckgroupService checkgroupService;
	
	//分页+列表+模糊
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean,String queryString){
		return checkgroupService.findPage(queryPageBean,queryString);
	}
	//添加
	@RequestMapping("/add")
	public Result add(@RequestBody TCheckgroup tCheckgroup){
		try {
			checkgroupService.add(tCheckgroup);
			return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
		}
	}
	//根据id回显
	@RequestMapping("/findById")
	public Result findById(Integer id){
		try {
			TCheckgroup tCheckgroup=checkgroupService.findById(id);
			return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,tCheckgroup);
		} catch (Exception e) {
			return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
		}
	}
	//根据检查组Id查询包含多个检查项
	@RequestMapping("/findCheckItemIdsByCheckGroupId")
	public Result findCheckItemIdsByCheckGroupId(Integer id){
		try {
			List<Integer> checkitemIds=checkgroupService.findCheckitemIdsByCheckgroup(id);
			return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
		}
	}
	//删除
	@RequestMapping("/delete")
	public Result delete(Integer id){
		try {
			checkgroupService.delete(id);
			return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.DELETE_CHECKGROUP_FAIL);
		}
	}
	//列表
	@RequestMapping("/findAll")
	public List<TCheckgroup> findAll(){
		return checkgroupService.findAll();
	}
}
