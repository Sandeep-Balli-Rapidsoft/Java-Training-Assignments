package com.vms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.entity.User;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveUser(User user) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(user);
	}
}
