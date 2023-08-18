package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Student;

@Transactional
@Component("studentDao")
public class StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int insert(Student student) {
		Integer result = (Integer) this.hibernateTemplate.save(student);
		return result;
	}

	public Student getStudentByEmail(String student_email) {
		String query = "FROM Student WHERE student_email = :student_email";
		List<Student> students = (List<Student>) this.hibernateTemplate.findByNamedParam(query, "student_email", student_email);
		if(!students.isEmpty()) {
			return students.get(0);
		}
		return null;
	}
	
	public List<Student> getAllStudents() {
		List<Student> studentList = this.hibernateTemplate.loadAll(Student.class);
		return studentList;
	}

}
