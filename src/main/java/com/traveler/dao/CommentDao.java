package com.traveler.dao;

import java.util.List;

import com.traveler.mapper.CommentMapper;
import com.traveler.model.Comment;

public class CommentDao {
	CommentMapper commentMapper;

	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	
	public List<Comment> selectComment(int listNo){
		return commentMapper.selectComment(listNo);
	}
	
	public int insertComment(Comment comment){
		return commentMapper.insertComment(comment);
	}
	
	
	
}
