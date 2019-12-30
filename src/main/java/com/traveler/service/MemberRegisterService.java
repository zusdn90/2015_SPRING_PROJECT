package com.traveler.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.MemberDao;
import com.traveler.exception.MemberRegisterException;
import com.traveler.model.Member;


public class MemberRegisterService {
	static Log log = LogFactory.getLog(ShareRegisterService.class);

	static MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	@Transactional
	public int regist(Member member) {
		int num = 0;
		
		try {
			num = memberDao.insert(member);
		} catch (DataIntegrityViolationException e) {
			log.error(e);
			throw new MemberRegisterException();
		}
		return num;
	}
	
	public static int chkId(String ckid) throws Exception {
		  return memberDao.chkId(ckid);
	}
	
}
