package com.traveler.service;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.MemberDao;
import com.traveler.model.Member;


public class MemberModifyService {

	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	@Transactional
	public int modify(Member member) {
		
		memberDao.update(member);
		
		return member.getNum();
	}
}
