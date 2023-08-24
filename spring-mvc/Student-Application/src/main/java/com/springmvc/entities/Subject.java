package com.springmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_table")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "subject_name")
	private String subject_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Subject(Integer id, String subject_name) {
		super();
		this.id = id;
		this.subject_name = subject_name;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Integer id) {
		super();
		this.id = id;
	}

	public Subject(String subject_name) {
		super();
		this.subject_name = subject_name;
	}
	
	
}
