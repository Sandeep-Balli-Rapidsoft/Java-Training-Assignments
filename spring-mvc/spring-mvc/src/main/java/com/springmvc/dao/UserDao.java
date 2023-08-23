package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.User;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int saveUser(User user) {
		Integer id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}
	
	public List<User> getAllUsers() {
		List<User> userList = this.hibernateTemplate.loadAll(User.class);
		return userList;
	}
}
