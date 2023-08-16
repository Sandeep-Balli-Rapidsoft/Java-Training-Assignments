package com.UserMarks;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.Question_Answer_Mapping_Entity.QuestionAnswersMapping;
import com.UserInputEntity.UserInputAnswer;
import com.UserEntity.*;

public class UserMarks {

	public void getUserMarksById(Integer userId) {

		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, userId);

		String userAnswerQuery = "From UserInputAnswer";
		List<UserInputAnswer> userAnswerList = session.createQuery(userAnswerQuery, UserInputAnswer.class)
				.getResultList();

		String orginalAnswerQuery = "From QuestionAnswersMapping";
		List<QuestionAnswersMapping> orginalAnswerList = session
				.createQuery(orginalAnswerQuery, QuestionAnswersMapping.class).getResultList();

		Integer marks = 0;

		for (QuestionAnswersMapping orginalAnswer : orginalAnswerList) {

			for (UserInputAnswer userAnswer : userAnswerList) {

				if (userAnswer.getUser().getId() == userId) {

					if (userAnswer.getQuestion().getId() == orginalAnswer.getQuestion().getId()) {

						if (userAnswer.getOption().getId() == orginalAnswer.getOption().getId()) {

							marks++;

						}

					}

				}

			}

		}

		System.out.println();
		System.out.println("Name: " + user.getUsername() + "\t Marks: " + marks);
		System.out.println();
	}

	public void getAllUserMarks() {

		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String userQuery = "From User";
		List<User> userList = session.createQuery(userQuery, User.class).getResultList();

		String userAnswerQuery = "From UserInputAnswer";
		List<UserInputAnswer> userAnswerList = session.createQuery(userAnswerQuery, UserInputAnswer.class)
				.getResultList();

		String orginalAnswerQuery = "From QuestionAnswersMapping";
		List<QuestionAnswersMapping> orginalAnswerList = session
				.createQuery(orginalAnswerQuery, QuestionAnswersMapping.class).getResultList();

		for (User user : userList) {
			Integer marks = 0;

			for (QuestionAnswersMapping orginalAnswer : orginalAnswerList) {

				for (UserInputAnswer userAnswer : userAnswerList) {

					if (userAnswer.getUser().getId() == user.getId()) {

						if (userAnswer.getQuestion().getId() == orginalAnswer.getQuestion().getId()) {

							if (userAnswer.getOption().getId() == orginalAnswer.getOption().getId()) {

								marks++;
							}
						}
					}
				}
			}
			System.out.println("Username: " + user.getUsername() + " \t|\t Marks: " + marks);
		}
	}
}
