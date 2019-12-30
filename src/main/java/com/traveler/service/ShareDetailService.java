package com.traveler.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.traveler.dao.CommentDao;
import com.traveler.dao.ShareCommentDao;
import com.traveler.dao.ShareDao;
import com.traveler.model.Comment;
import com.traveler.model.Share;

public class ShareDetailService {
	
	ShareDao sharedao;
	ShareCommentDao shareCommentDao;
	
	
	public void setShareDao(ShareDao dao)
	{
		this.sharedao = dao;
	}
	
	public void setShareCommentDao(ShareCommentDao dao)
	{
		this.shareCommentDao = dao;
	}
	
	@Transactional
	public Share shareDetail(int boardNum) {
		List<Comment> comments = shareCommentDao.selectShareComment(boardNum);
		Share share = sharedao.selectByboardNum(boardNum);
		share.setComments(comments);
		
		return share;
	}

	
}
