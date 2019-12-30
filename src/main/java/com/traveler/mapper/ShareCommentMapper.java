package com.traveler.mapper;

import java.util.List;

import com.traveler.model.Comment;

public interface ShareCommentMapper {
	List<Comment> selectShareComment(int listNo);
	int insertShareComment(Comment comment);
}
