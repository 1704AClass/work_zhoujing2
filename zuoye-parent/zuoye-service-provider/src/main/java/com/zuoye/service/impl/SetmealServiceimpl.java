package com.zuoye.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zuoye.mapper.TSetmealMapper;
import com.zuoye.pojo.TSetmeal;
import com.zuoye.pojo.TSetmealExample;
import com.zuoye.service.SetmealService;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;

@Service
public class SetmealServiceimpl implements SetmealService{

	@Autowired
	TSetmealMapper setmealMapper;

	@Override
	public PageResult findPage(QueryPageBean queryPageBean, String queryString) {
		TSetmealExample example=new TSetmealExample();
		if(queryString!=null && "".equals(queryString)){
			example.createCriteria().andNameEqualTo(queryString);
		}
		PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
		Page<TSetmeal> page=(Page<TSetmeal>) setmealMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(TSetmeal tSetmeal) {
		setmealMapper.insert(tSetmeal);
	}

	@Override
	public List<TSetmeal> getSetmeal() {
		return setmealMapper.selectByExample(null);
	}

	@Override
	public TSetmeal findById(int id) {
		return setmealMapper.findById(id);
	}
	
}
