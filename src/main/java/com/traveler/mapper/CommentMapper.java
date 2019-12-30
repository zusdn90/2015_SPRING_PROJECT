package com.traveler.mapper;

import java.util.List;

import com.traveler.model.Comment;

public interface CommentMapper {
	List<Comment> selectComment(int listNo);
	int insertComment(Comment comment);
}
