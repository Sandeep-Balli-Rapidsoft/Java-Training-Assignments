package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.ResultDao;
import com.dao.StudentDao;
import com.entities.Result;
import com.entities.Student;
import com.entities.Subject;
import com.main.DbConfig;

public class ResultService {
	ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
	ResultDao resultDao = context.getBean(ResultDao.class);
	StudentDao studentDao = context.getBean(StudentDao.class);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int insertNewResult() throws IOException {
		System.out.println("Enter Student Email: ");
		String email = br.readLine();

		// Fetching the student object by email.
		Student student = studentDao.getStudentByEmail(email);

		if (student != null) {
			Integer studentId = student.getId();

			List<Result> resultList = resultDao.resultList();

			for (Result result : resultList) {
				if (result.getStudent().getId() == studentId) {
					System.out.println("Student Data Already Exists.");
					return 0;
				}
			}

			for (int i = 0; i < 6; i++) {
				System.out.println("Enter Subject Id: ");
				Integer subjectId = Integer.parseInt(br.readLine());

				System.out.println("Enter Mark: ");
				Double mark = Double.parseDouble(br.readLine());

				int r = resultDao.insert(new Result(new Student(studentId), new Subject(subjectId), mark));
			}

		} else {
			System.out.println("Student does not exist");
		}

		return 0;
	}
}
