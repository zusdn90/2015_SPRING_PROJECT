package com.traveler.service;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.MemberDao;


public class MemberUnRegisterService {

	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	@Transactional
	public int unregist(int num) {
		memberDao.deleteByNum(num);
		
		return num;
	}
}
