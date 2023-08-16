package com.Question_Answer_Mapping_Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.OptionEntity.Option;
import com.QuestionEntity.*;
import com.UserInputEntity.UserInputAnswer;
@Entity
@Table(name = "question_answer_mapping_table")
public class QuestionAnswersMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@OneToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@OneToOne
	@JoinColumn(name = "answer_id")
	private Option option;

	public Integer getId() {
		return id;
	}
	
	

	public void setId(Integer id) {
		this.id = id;
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

	public QuestionAnswersMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
