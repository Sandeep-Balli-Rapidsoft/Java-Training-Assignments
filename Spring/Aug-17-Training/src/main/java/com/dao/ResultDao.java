package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Result;
import com.entities.Student;

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

	public Map<Student, Double> calculateMarksByEmail(String student_email) {
		String query = "FROM Student WHERE student_email = :student_email";
		List<Student> students = (List<Student>) this.hibernateTemplate.findByNamedParam(query, "student_email",
				student_email);
		Map<Student, Double> studentMap = new HashMap<>();

		if (!students.isEmpty()) {
			Student student = students.get(0);

			Double marks = 0.0;
			List<Result> fullList = resultList();

			for (Result result : fullList) {
				if (result.getStudent().getStudent_email().equals(student_email)) {
					marks += result.getMark();
				}
			}

			studentMap.put(student, marks);
		} else {
			System.out.println("Email not found");
		}
		return studentMap;
	}

	public Map<Student, Double> displayStudentResult() {
		Map<Student, Double> studentMap = new HashMap<>();
		List<Result> fullResultList = resultList();

		for (Result result : fullResultList) {
			Student student = result.getStudent();
			Double marksScored = result.getMark();
			if (studentMap.containsKey(student)) {
				Double existingMarks = studentMap.get(student);
				studentMap.put(student, existingMarks + marksScored);
			} else {
				studentMap.put(student, marksScored);
			}
		}
		return studentMap;
	}

}
