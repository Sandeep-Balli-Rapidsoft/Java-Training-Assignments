package com.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.ResultDao;
import com.dao.StudentDao;
import com.dao.SubjectDao;
import com.entities.Result;
import com.entities.Student;
import com.entities.Subject;
import com.main.DbConfig;

public class CalculateMarks {
	ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
	StudentDao studentDao = context.getBean(StudentDao.class);
	ResultDao resultDao = context.getBean(ResultDao.class);
	SubjectDao subjectDao = context.getBean(SubjectDao.class);

	public Double calculatePercentageByEmail(String email) {
		Student student = studentDao.getStudentByEmail(email);
		List<Subject> subjectList = subjectDao.subjectList();
		if (student != null) {
			List<Result> resultList = resultDao.resultList();

			Double totalMark = 0.0;
			Double fullMark = subjectList.size() * 100.00;

			for (Result result : resultList) {
				if (student.getStudent_email().equals(result.getStudent().getStudent_email())) {
					totalMark += result.getMark();
				}
			}
			Double percentage = (totalMark / fullMark) * 100;
			System.out.println("Student Email: " + student.getStudent_email());
			return percentage;
		} else {

			return 0.0;
		}
	}

	public String calculateGrade(Double percentage) {

		if (percentage > 90 && percentage <= 100) {
			return "A1";
		} else if (percentage > 80 && percentage <= 90) {
			return "A2";
		} else if (percentage > 60 && percentage <= 80) {
			return "B";
		} else if (percentage > 40 && percentage <= 60) {
			return "C";
		} else if (percentage > 30 && percentage <= 40) {
			return "D";
		} else {
			return "Fail";
		}
	}

	public void displayAllStudentData() {

		List<Student> studentList = studentDao.getAllStudents();

		for (Student student : studentList) {
			String email = student.getStudent_email();
			Double studentPercentage = calculatePercentageByEmail(email);
			if (studentPercentage != 0.0) {
				String studentGrade = calculateGrade(studentPercentage);

				System.out.println("Name: " + student.getStudent_name());
				System.out.println("Percentage: " + studentPercentage);
				System.out.println("Grade: " + studentGrade);

				System.out.println("---------------------------");
			}
		}
	}
}
