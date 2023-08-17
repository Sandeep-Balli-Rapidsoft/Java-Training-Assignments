package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.SubjectDao;
import com.entities.Subject;
import com.main.DbConfig;

public class SubjectService {
	ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
	SubjectDao subjectDao = context.getBean(SubjectDao.class);
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int addNewSubject() throws IOException {
		System.out.println("Enter Subject Name: ");
		String name = br.readLine();
		
		int result = subjectDao.insert(new Subject(name));
		return result;
	}
}
