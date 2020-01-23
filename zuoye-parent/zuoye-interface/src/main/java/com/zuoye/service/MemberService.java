package com.zuoye.service;

import com.zuoye.pojo.TMember;

public interface MemberService {

	TMember findByTelephone(String telephone);

	void add(TMember member);

}
