package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.ResultDao;
import com.dao.StudentDao;
import com.dao.SubjectDao;
import com.entities.Result;
import com.entities.Student;
import com.entities.Subject;
import com.main.DbConfig;

public class ResultService {
	ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
	ResultDao resultDao = context.getBean(ResultDao.class);
	StudentDao studentDao = context.getBean(StudentDao.class);
	SubjectDao subjectDao = context.getBean(SubjectDao.class);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int insertNewResult() throws IOException {
		System.out.println("Enter Student Email: ");
		String email = br.readLine();

		// Fetching the student object by email.
		Student student = studentDao.getStudentByEmail(email);

		if (student != null) {
			Integer studentId = student.getId();

			List<Result> resultList = resultDao.resultList();
			List<Subject> subjectList = subjectDao.subjectList();

			for (Result result : resultList) {
				if (result.getStudent().getId() == studentId) {
					System.out.println("Student Data Already Exists.");
					return 0;
				}
			}

			for (Subject subject : subjectList) {
				
				System.out.println("Enter Marks For " + subject.getSubject_name());
				
				System.out.println("Enter Mark: ");
				Double mark = Double.parseDouble(br.readLine());

				int r = resultDao.insert(new Result(new Student(studentId), new Subject(subject.getId()), mark));
			}

		} else {
			System.out.println("Student does not exist");
		}

		return 0;
	}
	
	public void getResultByEmail(String email) {
		Map<Student, Double> studentMap = resultDao.calculateMarksByEmail(email);
		for(Map.Entry<Student, Double> student : studentMap.entrySet()) {
			Student std = student.getKey();
			Double marksSecured = student.getValue();
			Double percentage = calculatePercentage(marksSecured);
			String grade = calculateGrade(percentage);
			
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("Name: " + std.getStudent_name());
			System.out.println("Percentage: " + decimalFormat.format(percentage));
			System.out.println("Grade: " + grade);
			System.out.println("---------------------------------------------");
			System.out.println();

		}
	}
	
	public void getAllStudentResult() {
		Map<Student, Double> totalResultMap = resultDao.displayStudentResult();
		
		for(Map.Entry<Student, Double> eachStudent : totalResultMap.entrySet()) {
			Student student = eachStudent.getKey();
			Double marksSecured = eachStudent.getValue();
			Double percentage = calculatePercentage(marksSecured);
			String grade = calculateGrade(percentage);
			
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("Name: " + student.getStudent_name());
			System.out.println("Percentage: " + decimalFormat.format(percentage));
			System.out.println("Grade: " + grade);
			System.out.println("---------------------------------------------");
			System.out.println();
		}
	}
	
	public Double calculatePercentage(Double marksSecured) {
		return (marksSecured / 600) * 100;
	}
	
	public String calculateGrade(Double percentage) {
	    String grade = "";
	    if (percentage > 90 && percentage <= 100) {
	        grade = "A1";
	    } else if (percentage > 80 && percentage <= 90) {
	        grade = "A2";
	    } else if (percentage > 60 && percentage <= 80) {
	        grade = "B";
	    } else if (percentage > 40 && percentage <= 60) {
	        grade = "C";
	    } else if (percentage > 30 && percentage <= 40) {
	        grade = "D";
	    } else {
	        grade = "Fail";
	    }
	    return grade;
	}


}