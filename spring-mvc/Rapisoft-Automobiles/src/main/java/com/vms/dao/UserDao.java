package com.vms.dao;

import java.util.List;

import com.vms.entity.User;

public interface UserDao {
	
	public void save(User user);
	
	public void update(Integer id);
	
	public User getUser(Integer id);
	
	public List<User> userList();
}
