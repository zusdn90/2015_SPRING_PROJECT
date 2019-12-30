package com.traveler.dao;

import java.util.List;

import com.traveler.mapper.CommentMapper;
import com.traveler.mapper.ShareCommentMapper;
import com.traveler.model.Comment;

public class ShareCommentDao {
	ShareCommentMapper shareCommentMapper;

	public void setShareCommentMapper(ShareCommentMapper shareCommentMapper) {
		this.shareCommentMapper = shareCommentMapper;
	}
	
	public List<Comment> selectShareComment(int listNo){
		return shareCommentMapper.selectShareComment(listNo);
	}
	
	public int insertShareComment(Comment comment){
		return shareCommentMapper.insertShareComment(comment);
	}
	
	
	
}
