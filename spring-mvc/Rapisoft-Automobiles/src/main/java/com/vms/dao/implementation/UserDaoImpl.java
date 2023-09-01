package com.vms.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vms.dao.UserDao;
import com.vms.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(user);
		
	}

	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		List<User> list = currentSession.createQuery("FROM User", User.class).getResultList();
		return list;
	}

}


