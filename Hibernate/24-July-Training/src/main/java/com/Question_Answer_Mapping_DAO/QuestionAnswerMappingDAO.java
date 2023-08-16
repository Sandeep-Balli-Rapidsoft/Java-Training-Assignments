package com.Question_Answer_Mapping_DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Config.App;
import com.OptionEntity.Option;
import com.QuestionEntity.Question;
import com.Question_Answer_Mapping_Entity.*;

public class QuestionAnswerMappingDAO {
		
	public static void setQuestionAndAnswer(Integer questionId, Integer answerId) {
		
		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		
		QuestionAnswersMapping mapAnswerToQuestion = new QuestionAnswersMapping();
		mapAnswerToQuestion.setQuestion(new Question(questionId));
		mapAnswerToQuestion.setOption(new Option(answerId));
		
		session.save(mapAnswerToQuestion);
		transaction.commit();
	}
	
	public static List fetchQuestions() {
		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		
		String questionQuery = "From Question";
		List<Question> questionList = session.createQuery(questionQuery, Question.class).getResultList();
		return questionList;
		
	}
	
	public static List fetchOptions(Integer questionId) {
		App config = new App();
		SessionFactory sessionFactory = config.sessionFactory;
		Session session = sessionFactory.openSession();
		
		String optionsQuery = "From Option";
		List<Option> optionList = session.createQuery(optionsQuery, Option.class).getResultList();
		
		List<Option> questionOptions = new ArrayList<Option>();
		for(Option option : optionList) {
			if(option.getQuestion().getId() == questionId) {
				questionOptions.add(option);
			}
		}
		return questionOptions;
	}
}
