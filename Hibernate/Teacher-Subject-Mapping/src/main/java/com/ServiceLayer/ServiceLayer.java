package com.ServiceLayer;

import com.DAOLayer.TeacherDAO;
import com.TeacherConfigLayer.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ServiceLayer {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void insertTeacher() throws Exception {
		System.out.println("Enter Teacher Name: ");
		String teacherName = br.readLine();
		TeacherDAO.insertTeacherData(teacherName);
	}
	
	public static void getTeacherById() throws Exception {
		System.out.println("Enter Teacher ID");
		Integer teacherId = Integer.parseInt(br.readLine());
		TeacherDAO.getTeacherData(teacherId);
	}
	
	public void insertSubject() throws Exception {
		System.out.println("Enter Subject Name: ");
		String subjectName = br.readLine();
	}

}
