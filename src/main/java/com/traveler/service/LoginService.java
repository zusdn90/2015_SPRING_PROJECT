package com.traveler.service;


import javax.tools.DocumentationTool.Location;

import com.traveler.dao.MemberDao;
import com.traveler.exception.LoginFailException;
import com.traveler.model.Member;

public class LoginService {

	MemberDao memberDao;

	public void setMemberDao(MemberDao dao){
		this.memberDao = dao;
	}
	
	public Member login(String id, String password) {

		Member member = memberDao.selectByIdAndPassword(id, password);
		if(member == null){
			throw new LoginFailException("※ 아이디나 비밀번호를 정확히 입력해 주시기 바랍니다.");
			
		}
		
		return member;
	}

}
