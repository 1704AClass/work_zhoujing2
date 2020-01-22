package com.zuoye.service;

import java.util.List;

import com.zuoye.pojo.TCheckgroup;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;

public interface CheckgroupService {

	PageResult findPage(QueryPageBean queryPageBean, String queryString);

	void add(TCheckgroup tCheckgroup);

	TCheckgroup findById(Integer id);

	List<Integer> findCheckitemIdsByCheckgroup(Integer id);

	void delete(Integer id);

	List<TCheckgroup> findAll();

}
