package com.QuestionDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.QuestionEntity.*;

public class QuestionDAO {
	
	static App config = new App();
	static SessionFactory sessionFactory = config.sessionFactory;
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();
	
	public static void insertQuestion(String question) {
		Question newQuestion = new Question();
		newQuestion.setQuestion(question);
		
		session.save(newQuestion);
		transaction.commit();
		
	}
	
}
