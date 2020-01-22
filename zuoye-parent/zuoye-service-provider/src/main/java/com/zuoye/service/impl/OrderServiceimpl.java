package com.zuoye.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zuoye.mapper.TOrderMapper;
import com.zuoye.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService{

	@Autowired
	TOrderMapper orderMapper;

	@Override
	public Map findById(Integer id) {
		return (Map) orderMapper.selectByPrimaryKey(id);
	}
	
	

}
