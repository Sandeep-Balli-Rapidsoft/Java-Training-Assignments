package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="student_name")
	private String student_name;
	
	@Column(name="student_email")
	private String student_email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public Student(Integer id, String student_name, String student_email) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.student_email = student_email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id) {
		super();
		this.id = id;
	}

	public Student(String student_name, String student_email) {
		super();
		this.student_name = student_name;
		this.student_email = student_email;
	}
	
}
