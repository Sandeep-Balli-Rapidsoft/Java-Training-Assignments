package com.springmvc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.StudentDao;
import com.springmvc.entities.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int insertNewStudent(String name, String email) throws IOException {
		List<Student> studentList = studentDao.getAllStudents();
		for (Student student : studentList) {
			if (student.getStudent_email().equals(email)) {
				System.out.println("Student Already Exist");
				return 0;
			}
		}

		int result = studentDao.insert(new Student(name, email));
		System.out.println("Student Added Successfully.");
		return result;
	}

}
