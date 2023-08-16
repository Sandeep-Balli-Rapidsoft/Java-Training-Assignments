package com.OptionDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.OptionEntity.Option;
import com.QuestionEntity.Question;

public class OptionDAO {
	static App config = new App();
	static SessionFactory sessionFactory = config.sessionFactory;
	static Session session = sessionFactory.openSession();
	static Transaction transaction = session.beginTransaction();
	
	public static void addOption(Integer questionId, String optionString) {
		Question question = session.get(Question.class, questionId);
		
		Option option = new Option();
		option.setAnswers(optionString);
		option.setQuestion(new Question(questionId));
		
		session.save(option);
		transaction.commit();
	}
}
