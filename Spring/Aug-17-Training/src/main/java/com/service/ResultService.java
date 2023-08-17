package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
