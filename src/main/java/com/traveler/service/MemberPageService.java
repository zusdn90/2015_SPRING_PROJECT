package com.traveler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.MemberDao;
import com.traveler.model.Member;
import com.traveler.model.MemberPage;
import com.traveler.util.AdminPagination;

public class MemberPageService {
	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}

	@Transactional
	public MemberPage getPage(int pageNo) {
		AdminPagination pagination = new AdminPagination();
		pagination.setPageNo(pageNo);
		pagination.setTotalItem(memberDao.selectCount());
		List<Member> memberList = memberDao.selectAdminPage(pagination);
		
		MemberPage page = new MemberPage();
		page.setPagination(pagination);
		page.setMembers(memberList);
		
		return page;
	}

}
