package com.zuoye.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoye.pojo.TSetmeal;
import com.zuoye.service.SetmealService;
import com.zuoye.utils.MessageConstant;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;
import com.zuoye.utils.Result;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {

	@Reference
	SetmealService setmealService;
	
	//分页+列表+模糊
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean,String queryString){
		return setmealService.findPage(queryPageBean,queryString);
	}
	//添加
	@RequestMapping("/add")
	public Result add(@RequestBody TSetmeal tSetmeal){
		try {
			setmealService.add(tSetmeal);
			return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
		} catch (Exception e) {
			return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
		}
	}
	//文件上传
	@RequestMapping("/upload")
	public Result upload(@RequestParam("imgFile")MultipartFile imgFile) throws IOException{
		String originalFilename = imgFile.getOriginalFilename();
		int index=originalFilename.lastIndexOf(".");
		String extention = originalFilename.substring(index-1);
		String fileName=UUID.randomUUID().toString()+extention;
		//将文件上传到七牛云服务器
		/*QiniuUtils.upload2Qiniu(imgFile.getBytes(),fileName);
		jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES,fileName);*/
		return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS);
	}
}
