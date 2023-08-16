package com.TeacherConfigLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ControllerLayer.TeacherController;

/**
 * Hello world!
 *
 */
public class App {
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
//			Configuration config = new Configuration().configure().buildSessionFactory();
//			config.configure();
//			factory = config.buildSessionFactory();
		}
		return factory;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		
		SessionFactory sFactory = getSessionFactory();
		Session session = sFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		TeacherController.userMenu();
		
		
		// Drop database and Table and recreate them.
		
		session.close();
		
	}
}
