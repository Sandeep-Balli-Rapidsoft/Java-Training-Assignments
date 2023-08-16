package com.ManagerDAO;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.DeveloperEntity.Developer;
import com.ManagerEntity.Manager;
import com.QAEntity.QualityAnalyst;

public class ManagerDAO {
	
	static App config = new App();
	static SessionFactory sessionFactory = config.sessionFactory;
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();
	
	
	public static void insertManagerData(String managerName) {
		Manager manager = new Manager();
		manager.setManager_name(managerName);
		
		session.save(manager);
		transaction.commit();
	}
	
	public static List getManagerEmployees(Integer id) {
		
		List<String> employeesList = new ArrayList<String>();
		
		Manager manager = session.get(Manager.class, id);
		List<Developer> developerList = manager.getDeveloper();
		List<QualityAnalyst> qualityAnalystsList = manager.getQualityAnalyst();
		
		for(Developer emp : developerList) {
			if(emp.getManager().getId() == id) {
				employeesList.add(emp.getDeveloper_name());
			}
		}
		
		for(QualityAnalyst qa : qualityAnalystsList) {
			if(qa.getManager().getId() == id) {
				employeesList.add(qa.getQa_name());
			}
		}
		
		return employeesList;
	}
}
