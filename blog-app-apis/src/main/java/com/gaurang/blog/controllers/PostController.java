package com.gaurang.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaurang.blog.config.AppConstants;
import com.gaurang.blog.entities.Post;
import com.gaurang.blog.payload.ApiResponse;
import com.gaurang.blog.payload.PostDto;
import com.gaurang.blog.payload.PostResponse;
import com.gaurang.blog.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {

		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {

		List<PostDto> posts = this.postService.getPostsByUser(userId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {

		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy) {
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy);

		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {

		PostDto postById = this.postService.getPostById(postId);

		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
	}

	@DeleteMapping("/post/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {

		this.postService.deletePost(postId);

		return new ApiResponse("Deleted", true);
	}

	

}
