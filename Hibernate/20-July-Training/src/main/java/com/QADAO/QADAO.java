package com.QADAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.ManagerEntity.Manager;
import com.QAEntity.QualityAnalyst;

public class QADAO {
	
	static App config = new App();
	static SessionFactory sessionFactory = config.sessionFactory;
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();
	
	public static void insertQAData(String qaName, Integer managerId) {
		QualityAnalyst qualityAnalyst = new QualityAnalyst();
		qualityAnalyst.setQa_name(qaName);
		qualityAnalyst.setManager(new Manager(managerId));
		
		session.save(qualityAnalyst);
		transaction.commit();
	}
	
	public static QualityAnalyst getQualityAnalystById(Integer qualityAnalystId) {
		QualityAnalyst qualityAnalyst = session.get(QualityAnalyst.class, qualityAnalystId);
		
		return qualityAnalyst;
	}
	
	public static List getAllQualityAnalysts() {
		String query = "from QualityAnalyst";
		List<QualityAnalyst> qualityAnalystsList = session.createQuery(query, QualityAnalyst.class).getResultList();
		
		return qualityAnalystsList;
	}
}
