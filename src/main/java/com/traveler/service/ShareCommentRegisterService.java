package com.traveler.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;

import com.traveler.dao.ShareCommentDao;
import com.traveler.exception.MemberRegisterException;
import com.traveler.model.Comment;

public class ShareCommentRegisterService {
	static Log log = LogFactory.getLog(ShareCommentRegisterService.class);
	ShareCommentDao shareCommentDao;
	
	public void setShareCommentDao(ShareCommentDao dao){
		this.shareCommentDao = dao;
	}
	
	public int regist(Comment comment){
		int rtn = 0;
		try{
		rtn = shareCommentDao.insertShareComment(comment);
		}
		catch (DataIntegrityViolationException e) {
			log.error(e);
			throw new MemberRegisterException();
		}
		return rtn;
	}
}
