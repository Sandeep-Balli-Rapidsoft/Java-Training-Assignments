package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Result;
import com.entities.Student;
import com.entities.Subject;

@Transactional
@Component("resultDao")
public class ResultDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int insert(Result result) {
		Integer r = (Integer) this.hibernateTemplate.save(result);
		return r;
	}

	public List<Result> resultList() {
		List<Result> list = this.hibernateTemplate.loadAll(Result.class);
		return list;
	}

	public Map<Student, Map<Subject, Double>> calculateMarksByEmail(String student_email) {
		String query = "FROM Student WHERE student_email = :student_email";
		List<Student> students = (List<Student>) this.hibernateTemplate.findByNamedParam(query, "student_email",
				student_email);
		Map<Student, Map<Subject, Double>> studentMap = new HashMap();

		if (!students.isEmpty()) {
			Student student = students.get(0);

			Map<Subject, Double> subjectMarksMap = new HashMap();
			List<Result> fullList = resultList();

			for (Result result : fullList) {
				if (result.getStudent().getStudent_email().equals(student_email)) {
					subjectMarksMap.put(result.getSubject(), result.getMark());
				}
			}

			studentMap.put(student, subjectMarksMap);
		}
		return studentMap;
	}


	public Map<Student, Map<Subject, Double>> displayAllStudentResult() {
		Map<Student, Map<Subject, Double>> studentMap = new HashMap();
		List<Result> fullResultList = resultList();

		for (Result result : fullResultList) {
			Student student = result.getStudent();
			Subject subject = result.getSubject();
			Double mark = result.getMark();

			studentMap.putIfAbsent(student, new HashMap());

			Map<Subject, Double> resultMap = studentMap.get(student);

			resultMap.put(subject, mark);
		}

		return studentMap;
	}
	
	public void applyRecheck(Result result) {
		result.setIsRecheck(true);
		this.hibernateTemplate.update(result);
	}
	
	public void updateMark(Result result) {
		result.setIsRecheck(false);
		this.hibernateTemplate.update(result);
	}

}
