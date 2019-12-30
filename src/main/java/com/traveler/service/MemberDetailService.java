package com.traveler.service;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.MemberDao;
import com.traveler.model.Member;


public class MemberDetailService {

	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	@Transactional
	public Member detail(int num) {
		Member member = memberDao.selectByNum(num);
		
		return member;
	}
}
