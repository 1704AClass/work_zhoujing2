package com.zuoye.service;

import java.util.List;

import com.zuoye.pojo.TCheckitem;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;

public interface CheckitemService {

	PageResult findPage(QueryPageBean queryPageBean, String queryString);

	void add(TCheckitem tCheckitem);

	void edit(TCheckitem tCheckitem);

	void delete(Integer id);

	TCheckitem findById(Integer id);

	List<TCheckitem> findAll();

}
