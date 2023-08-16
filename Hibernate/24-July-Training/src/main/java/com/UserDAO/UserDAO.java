package com.UserDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.UserEntity.User;

public class UserDAO {
	
	public static void addUser(Integer id, String username, String email, String phone) {
		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPhone(phone);
		session.save(newUser);
		
		transaction.commit();
		session.close();
	}
}
