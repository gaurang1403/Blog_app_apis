package com.gaurang.blog.service;

import java.util.List;

import com.gaurang.blog.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userid);

	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
