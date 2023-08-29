package com.learn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.models.User;

@Service
public class UserService {
	
	public List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("Sandeep Balli", "sandeep@gmail.com", "1234"));
		list.add(new User("MS Dhone", "ms@gmail.com", "1234"));
	}
	
	// Get All Users
	public List<User> getAllUsers() {
		return this.list;
	}
	
	// Get User By Username
	public User getUser(String username) {
		return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	// Add User
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
	
}
