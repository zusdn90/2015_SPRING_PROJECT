package com.traveler.service;

import java.util.List;

import com.traveler.dao.ShareCommentDao;
import com.traveler.model.Comment;

public class ShareCommentService {
	ShareCommentDao shareCommentDao;
	
	public void setShareCommentDao(ShareCommentDao dao){
		this.shareCommentDao = dao;
	}
	
	public List<Comment> getCommentList(int listNo){
		List<Comment> comment = shareCommentDao.selectShareComment(listNo);
		
		return comment;
	}
}