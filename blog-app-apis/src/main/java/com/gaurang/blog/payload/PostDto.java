package com.gaurang.blog.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gaurang.blog.entities.Category;
import com.gaurang.blog.entities.Comment;
import com.gaurang.blog.entities.User;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;

	private String postTitle;

	private String postContent;

	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comment = new HashSet<>();
} 
