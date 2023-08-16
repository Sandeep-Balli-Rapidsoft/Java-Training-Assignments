package com.UserInputDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.UserInputEntity.UserInputAnswer;
import com.Config.App;
import com.UserEntity.User;

public class UserInput {
	
	public static void saveAnswer(UserInputAnswer input) {
		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(input);
		transaction.commit();		
	}
	
	public static boolean isUserAnswerExist(Integer userId) throws Exception {
		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
				
		String query = "From UserInputAnswer";
		List<UserInputAnswer> userInputList = session.createQuery(query, UserInputAnswer.class).getResultList();

		for(UserInputAnswer user : userInputList) {
			if(user.getUser().getId() == userId) {
				return true;
			}
		}
		return false;
	}
}
