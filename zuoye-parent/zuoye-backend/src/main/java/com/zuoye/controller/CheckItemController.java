package com.zuoye.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoye.pojo.TCheckitem;
import com.zuoye.service.CheckitemService;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;
import com.zuoye.utils.Result;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

	@Reference
	CheckitemService checkitemService;
	
	//分页+列表
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean,String queryString){
		return checkitemService.findPage(queryPageBean,queryString);
	}
	//添加
	@RequestMapping("/add")
	public Result add(@RequestBody TCheckitem tCheckitem){
		try {
			checkitemService.add(tCheckitem);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			return new Result(false, "添加失败");
		}
	}
	//编辑检查项
	@RequestMapping("/edit")
	public Result edit(@RequestBody TCheckitem tCheckitem){
		try {
			checkitemService.edit(tCheckitem);
			return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
		}
	}
	//根据id删除
	@RequestMapping("/delete")
	public Result delete(Integer id){
		try {
			checkitemService.delete(id);
			return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.DELETE_CHECKGROUP_FAIL);
		}
	}
	//编辑回显
	@RequestMapping("/findById")
	public Result findById(Integer id){
		try {
			TCheckitem findById = checkitemService.findById(id);   //你不把查询到的对象返回给我们的前台
			return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,findById);
		} catch (Exception e) {
			return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
		}
	}
    //列表
	@RequestMapping("/findAll")
	public List<TCheckitem> findAll(){
		return checkitemService.findAll();
	}
}
