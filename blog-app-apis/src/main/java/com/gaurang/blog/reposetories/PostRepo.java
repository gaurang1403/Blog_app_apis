package com.gaurang.blog.reposetories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gaurang.blog.entities.Category;
import com.gaurang.blog.entities.Post;
import com.gaurang.blog.entities.User;


public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);


}
