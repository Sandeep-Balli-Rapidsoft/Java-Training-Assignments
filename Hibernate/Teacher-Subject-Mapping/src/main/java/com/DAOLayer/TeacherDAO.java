package com.DAOLayer;

import com.TeacherConfigLayer.*;
import com.TeacherEntity.Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherDAO {
	static App config = new App();
	static SessionFactory getSessionFactory = config.getSessionFactory();
	static Session session = getSessionFactory.openSession();
	static Transaction transaction  = session.beginTransaction();
	
	public static void insertTeacherData(String teacherName) {
		Teacher teacher = new Teacher();
		teacher.setTeacher_name(teacherName);
		
		session.save(teacher);
		
		transaction.commit();
	}
	
	public static void getTeacherData(Integer teacherId) {
		Teacher getTeacherDataById = session.get(Teacher.class, teacherId);
		System.out.println("Teacher Name: " + getTeacherDataById.getTeacher_name());
	}
}
