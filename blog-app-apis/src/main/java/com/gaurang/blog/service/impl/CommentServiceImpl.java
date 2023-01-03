package com.gaurang.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurang.blog.entities.Comment;
import com.gaurang.blog.entities.Post;
import com.gaurang.blog.exception.ResourceNotFoundException;
import com.gaurang.blog.payload.CommentDto;
import com.gaurang.blog.reposetories.CommentRepo;
import com.gaurang.blog.reposetories.PostRepo;
import com.gaurang.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment delete = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment Id", commentId));
		
		this.commentRepo.delete(delete);
		
	}

	@Override
	public CommentDto getAllcomment(Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
