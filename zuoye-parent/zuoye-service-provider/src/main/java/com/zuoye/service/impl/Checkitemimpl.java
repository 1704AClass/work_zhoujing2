package com.zuoye.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zuoye.mapper.TCheckitemMapper;
import com.zuoye.pojo.TCheckitem;
import com.zuoye.pojo.TCheckitemExample;
import com.zuoye.service.CheckitemService;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;

@Service
public class Checkitemimpl implements CheckitemService{

    @Autowired
    TCheckitemMapper checkitemMapper;

	@Override
	public PageResult findPage(QueryPageBean queryPageBean,String queryString) {
		TCheckitemExample example=new TCheckitemExample();
		if(queryString!=null && "".equals(queryString)){
			example.createCriteria().andNameEqualTo(queryString);
		}
		PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
		Page<TCheckitem> page=(Page<TCheckitem>) checkitemMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(TCheckitem tCheckitem) {
		checkitemMapper.insertSelective(tCheckitem);
	}

	@Override
	public void edit(TCheckitem tCheckitem) {
		
	}

	@Override
	public void delete(Integer id) {
		checkitemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TCheckitem findById(Integer id) {
		return checkitemMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TCheckitem> findAll() {
		return checkitemMapper.selectByExample(null);
	}
    
    
}
