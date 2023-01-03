package com.gaurang.blog.service;

import java.util.List;

import com.gaurang.blog.entities.Post;
import com.gaurang.blog.payload.PostDto;
import com.gaurang.blog.payload.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);

	PostDto getPostById(Integer postID);

	List<PostDto> getPostsByCategory(Integer categoryId);

	List<PostDto> getPostsByUser(Integer userId);

}
 