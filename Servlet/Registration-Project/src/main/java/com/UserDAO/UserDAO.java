package com.UserDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.UserEntity.User;

public class UserDAO {
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static boolean insertUser(User user) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Integer i = (Integer) session.save(user);
		transaction.commit();

		if (i > 0) {
			return true;
		}
		return false;
	}

	public static User login(String email, String password) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "FROM User WHERE email = :email";
		User user = session.createQuery(query, User.class).setParameter("email", email).uniqueResult();

		if (user != null) {
			if (user.getEmail().equals(email)) {
				if (user.getPassword().equals(password)) {
					return user;
				} else {
					System.out.println("Incorrect Password");
				}

			} else {
				System.out.println("Invalid Email");
			}
		} else {
			System.err.println("invalid");
		}
		return null;

	}

	public static List<User> getColleagues() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String query = "FROM User";
		List<User> colleaguesList = session.createQuery(query, User.class).getResultList();

		for (User user : colleaguesList) {
			System.out.println(user.getFirstName());
		}

		return colleaguesList;
	}
}
