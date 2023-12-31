package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.StudentDao;
import com.entities.Student;
import com.main.DbConfig;

public class StudentService {
	ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
	StudentDao studentDao = context.getBean(StudentDao.class);
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int insertNewStudent() throws IOException {
		System.out.println("Enter Student Name: ");
		String name = br.readLine();

		System.out.println("Enter Student Email: ");
		String email = br.readLine();
		
		List<Student> studentList = studentDao.getAllStudents();
		for(Student student : studentList) {
			if(student.getStudent_email().equals(email)) {
				System.out.println("Student Already Exist");
				return 0;
			}
		}

		int result = studentDao.insert(new Student(name, email));
		System.out.println("Student Added Successfully.");
		return result;
	}

}
