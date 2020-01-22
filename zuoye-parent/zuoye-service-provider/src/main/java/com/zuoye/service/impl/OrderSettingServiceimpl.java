package com.zuoye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zuoye.mapper.TOrdersettingMapper;
import com.zuoye.service.OrderSettingService;

@Service
public class OrderSettingServiceimpl implements OrderSettingService{

	@Autowired
	TOrdersettingMapper ordersettingMapper;
	
	
}
