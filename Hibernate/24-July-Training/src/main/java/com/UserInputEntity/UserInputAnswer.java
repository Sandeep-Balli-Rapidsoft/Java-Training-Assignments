package com.UserInputEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.OptionEntity.Option;
import com.QuestionEntity.Question;
import com.UserEntity.User;

@Entity
@Table(name = "user_input_table")
public class UserInputAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@OneToOne
	@JoinColumn(name = "input_id")
	private Option option;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public UserInputAnswer(User user, Question question, Option option) {
		super();
		this.user = user;
		this.question = question;
		this.option = option;
	}

	public UserInputAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
