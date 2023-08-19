package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result_table")
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Column(name = "mark")
	private Double mark;
	
	@Column(name = "is_recheck")
	private Boolean is_recheck = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public Boolean getIsRecheck() {
		return is_recheck;
	}

	public void setIsRecheck(Boolean isRecheck) {
		this.is_recheck = isRecheck;
	}

	public Result(Student student, Subject subject, Double mark, Boolean is_recheck) {
		super();
		this.student = student;
		this.subject = subject;
		this.mark = mark;
		this.is_recheck = is_recheck;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(Student student, Subject subject, Boolean is_recheck) {
		super();
		this.student = student;
		this.subject = subject;
		this.is_recheck = is_recheck;
	}

	public Result(Integer id, Student student, Subject subject, Double mark, Boolean is_recheck) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.mark = mark;
		this.is_recheck = is_recheck;
	}

}
