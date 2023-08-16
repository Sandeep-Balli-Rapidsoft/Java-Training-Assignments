package com.ServiceLayer;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;

import com.UserMarks.*;
import com.OptionDAO.OptionDAO;
import com.OptionEntity.Option;
import com.QuestionDAO.QuestionDAO;
import com.QuestionEntity.Question;
import com.Question_Answer_Mapping_DAO.QuestionAnswerMappingDAO;
import com.Question_Answer_Mapping_Entity.QuestionAnswersMapping;
import com.UserDAO.UserDAO;
import com.UserEntity.User;
import com.UserInputDAO.UserInput;
import com.UserInputEntity.UserInputAnswer;

public class ServiceLayer {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void addQuestion() throws Exception {
		System.out.println("Enter Question");
		String question = br.readLine();

		QuestionDAO.insertQuestion(question);

	}

	public static void addOptions() throws Exception {
		System.out.println("Enter Question ID");
		Integer questionId = Integer.parseInt(br.readLine());
		System.out.println("Enter option");
		String option = br.readLine();

		OptionDAO.addOption(questionId, option);
	}

	public static void addUser() throws Exception {
		System.out.println("Enter username: ");
		String username = br.readLine();
		System.out.println("Enter email: ");
		String email = br.readLine();
		System.out.println("Enter Phone: ");
		String phone = br.readLine();

		UserDAO.addUser(1, username, email, phone);
	}

	public static void setAnswers() throws Exception {
		System.out.println("Enter Question ID");
		Integer questionId = Integer.parseInt(br.readLine());
		System.out.println("Enter Answer ID");
		Integer answerId = Integer.parseInt(br.readLine());
		QuestionAnswerMappingDAO.setQuestionAndAnswer(questionId, answerId);
	}

	public static void displayQuiz() throws Exception {

		System.out.println("Enter User ID");
		Integer userId = Integer.parseInt(br.readLine());

		
		if (!UserInput.isUserAnswerExist(userId)) {

			List<Question> questionList = QuestionAnswerMappingDAO.fetchQuestions();

			for (Question question : questionList) {
				Integer count = 1;
				System.out.println("Question - " + question.getQuestion());
				List<Option> optionList = QuestionAnswerMappingDAO.fetchOptions(question.getId());
				for (Option option : optionList) {
					System.out.println("Enter " + count + " for, " + option.getAnswers());
					count++;

				}
				Integer optionEntered = Integer.parseInt(br.readLine());

				Integer optionKey = 0;
				if (optionEntered == 1) {
					optionKey = optionList.get(0).getId();
				}
				if (optionEntered == 2) {
					optionKey = optionList.get(1).getId();
				}
				if (optionEntered == 3) {
					optionKey = optionList.get(2).getId();
				}
				if (optionEntered == 4) {
					optionKey = optionList.get(3).getId();
				}

				UserInput.saveAnswer(
						new UserInputAnswer(new User(userId), new Question(question.getId()), new Option(optionKey)));

				System.out.println();
			}
		} else {
			System.out.println("User Already Exists");
			displayQuiz();
		}

	}

	public static void displayUserMarksById() throws Exception {
		System.out.println("Enter User Id");
		Integer userId = Integer.parseInt(br.readLine());
		UserMarks marks = new UserMarks();
		marks.getUserMarksById(userId);
	}

	public static void getAllUserMarks() throws Exception {
		UserMarks marks = new UserMarks();
		marks.getAllUserMarks();
	}

}
