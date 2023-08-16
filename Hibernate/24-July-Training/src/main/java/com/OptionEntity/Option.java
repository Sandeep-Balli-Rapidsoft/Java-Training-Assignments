package com.OptionEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.QuestionEntity.*;

@Entity
@Table(name = "options_table")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	public String answers;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option(Integer id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	
}
