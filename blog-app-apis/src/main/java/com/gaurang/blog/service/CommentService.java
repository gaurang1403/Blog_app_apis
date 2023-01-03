package com.gaurang.blog.service;

import com.gaurang.blog.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
	
	CommentDto getAllcomment(Integer commentId); 
	
}
