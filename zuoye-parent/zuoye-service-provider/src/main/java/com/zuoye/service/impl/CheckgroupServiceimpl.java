package com.zuoye.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zuoye.mapper.TCheckgroupMapper;
import com.zuoye.pojo.TCheckgroup;
import com.zuoye.pojo.TCheckgroupExample;
import com.zuoye.service.CheckgroupService;
import com.zuoye.service.CheckitemService;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;

@Service
public class CheckgroupServiceimpl implements CheckgroupService{

	@Autowired
	TCheckgroupMapper checkgroupMapper;

	@Override
	public PageResult findPage(QueryPageBean queryPageBean, String queryString) {
		TCheckgroupExample example=new TCheckgroupExample();
		if(queryString!=null && "".equals(queryString)){
			example.createCriteria().andNameEqualTo(queryString);
		}
		PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
		Page<TCheckgroup> page=(Page<TCheckgroup>) checkgroupMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(TCheckgroup tCheckgroup) {
		checkgroupMapper.insertSelective(tCheckgroup);
	}

	@Override
	public TCheckgroup findById(Integer id) {
		return checkgroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Integer> findCheckitemIdsByCheckgroup(Integer id) {
	    
		return (List<Integer>) checkgroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Integer id) {
		checkgroupMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<TCheckgroup> findAll() {
		return checkgroupMapper.selectByExample(null);
	}
	
	
}
