package com.DeveloperDAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.DeveloperEntity.Developer;
import com.ManagerEntity.Manager;

public class DeveloperDAO {
	
	static App config = new App();
	static SessionFactory sessionFactory = config.sessionFactory;
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();

	
	public static void insertDeveloperData(String developerName, Integer managerId) {
		Developer developer = new Developer();
		developer.setDeveloper_name(developerName);
		developer.setManager(new Manager(managerId));
		
		session.save(developer);
		transaction.commit();
	}
	
	public static List getAllDevelopers() {
		String query = "from Developer";
		List<Developer> developerList = session.createQuery(query, Developer.class).getResultList();
		
		return developerList;
	}
	
	public static Developer getDeveloperById(Integer id) {
		Developer developer = session.get(Developer.class, id);		
		return developer;
	}
	
	
}
