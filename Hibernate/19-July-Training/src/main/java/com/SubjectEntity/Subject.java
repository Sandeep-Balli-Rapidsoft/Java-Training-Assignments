package com.SubjectEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.TeacherEntity.Teacher;

@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String subject_name;
	
	@OneToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

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

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Integer id, String subject_name) {
		super();
		this.id = id;
		this.subject_name = subject_name;
	}

	public Subject(Integer id) {
		super();
		this.id = id;
	}
	
	
}
