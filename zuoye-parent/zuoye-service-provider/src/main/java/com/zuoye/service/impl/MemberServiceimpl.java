package com.zuoye.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zuoye.mapper.TMemberMapper;
import com.zuoye.pojo.TMember;
import com.zuoye.service.MemberService;

@Service
public class MemberServiceimpl implements MemberService{

	@Autowired
	TMemberMapper memberMapper;

	@Override
	public TMember findByTelephone(String phoneNumber) {
		return memberMapper.findByTelephone(phoneNumber);
	}

	@Override
	public void add(TMember member) {
		memberMapper.insert(member);
	}
	
	
}
