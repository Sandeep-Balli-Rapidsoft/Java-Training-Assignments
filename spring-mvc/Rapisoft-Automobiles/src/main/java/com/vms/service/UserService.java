package com.vms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.dao.UserDao;
import com.vms.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user) {
		this.userDao.save(user);
	}
}
