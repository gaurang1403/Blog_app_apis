package com.gaurang.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurang.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
