package com.gaurang.blog.reposetories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurang.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	


	
}
