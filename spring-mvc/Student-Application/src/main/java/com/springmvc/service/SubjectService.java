package com.springmvc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.SubjectDao;
import com.springmvc.entities.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public int addNewSubject() throws IOException {
		System.out.println("Enter Subject Name: ");
		String name = br.readLine();
		
		int result = subjectDao.insert(new Subject(name));
		return result;
	}
}
