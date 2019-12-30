package com.traveler.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;

import com.traveler.dao.CommentDao;
import com.traveler.exception.MemberRegisterException;
import com.traveler.model.Comment;

public class CommentRegisterService {
	static Log log = LogFactory.getLog(CommentRegisterService.class);
	CommentDao commentDao;
	
	public void setCommentDao(CommentDao dao){
		this.commentDao = dao;
	}
	
	public int regist(Comment comment){
		int rtn = 0;
		try{
		rtn = commentDao.insertComment(comment);
		}
		catch (DataIntegrityViolationException e) {
			log.error(e);
			throw new MemberRegisterException();
		}
		return rtn;
	}
}
