package com.traveler.service;

import java.util.List;

import com.traveler.dao.CommentDao;
import com.traveler.model.Comment;

public class CommentService {
	CommentDao commentDao;
	
	public void setCommentDao(CommentDao dao){
		this.commentDao = dao;
	}
	
	public List<Comment> getCommentList(int listNo){
		List<Comment> comment = commentDao.selectComment(listNo);
		
		return comment;
	}
}
