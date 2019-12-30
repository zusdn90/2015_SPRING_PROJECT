package com.traveler.service;

import java.util.List;


import com.traveler.dao.MemberDao;
import com.traveler.model.Member;
import com.traveler.model.MemberList;

public class MemberListService {
	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}

	public MemberList getMemberList() {
		List<Member> members = memberDao.selectAll();
		MemberList rtn = new MemberList();
		rtn.setMembers(members);
		
		return rtn;
	}

	
}
