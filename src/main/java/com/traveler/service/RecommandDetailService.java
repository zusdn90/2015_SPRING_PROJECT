package com.traveler.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.CommentDao;
import com.traveler.dao.RecommandDao;
import com.traveler.model.Comment;
import com.traveler.model.Recommand;

public class RecommandDetailService {

	RecommandDao recommandDao;
	CommentDao commentDao;
	
	public void setRecommandDao(RecommandDao dao) {
		this.recommandDao = dao;
	}
	
	public void setCommentDao(CommentDao dao) {
		this.commentDao = dao;
	}
	
	@Transactional
	public Recommand detail(int listNo) {
		List<Comment> comments = commentDao.selectComment(listNo);
		Recommand recommand = recommandDao.selectByTitle(listNo);
		recommand.setCommentList(comments);
		
		return recommand;
	}
}
