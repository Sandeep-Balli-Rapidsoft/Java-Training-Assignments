package com.QuestionEntity;

import javax.persistence.Entity;
import com.OptionEntity.*;
import java.util.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question_table")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	
	public String question;
	
	@OneToMany(mappedBy = "question")
	private List<Option> option;

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer questionId) {
		// TODO Auto-generated constructor stub
		this.id = questionId;
	}

	
	
	
}
