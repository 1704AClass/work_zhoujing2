package com.zuoye.service;

import java.util.List;

import com.zuoye.pojo.TSetmeal;
import com.zuoye.utils.PageResult;
import com.zuoye.utils.QueryPageBean;

public interface SetmealService {

	PageResult findPage(QueryPageBean queryPageBean, String queryString);

	void add(TSetmeal tSetmeal);

	List<TSetmeal> getSetmeal();

	TSetmeal findById(int id);

}
