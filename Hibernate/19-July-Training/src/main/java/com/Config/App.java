package com.Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.SubjectEntity.Subject;
import com.TeacherEntity.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SessionFactory factory;
	public static SessionFactory factoryConfig() {
		
		if(factory == null) {			
			Configuration config = new Configuration();
			config.configure();
			factory = config.buildSessionFactory();
		}

        return factory;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SessionFactory getFactory = factoryConfig();
        Session session = getFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
//        Teacher teacher1 = new Teacher();
//        teacher1.setId(101);
//        teacher1.setTeacher_name("Teacher 1");
//        
//        Subject subject1 = new Subject();
//        subject1.setId(101);
//        subject1.setSubject_name("Maths");
//        
//        session.save(teacher1);
//        session.save(subject1);
        
        
//        Teacher updatedTeacher = session.get(Teacher.class, 1);
//        updatedTeacher.setSubject(new Subject(1));
//        
//        
//        Subject updatedSubject = session.get(Subject.class, 1);
//        updatedSubject.setTeacher(new Teacher(1));
//        
//        session.saveOrUpdate(updatedTeacher);
//        session.saveOrUpdate(updatedSubject);
        
        
        System.out.println("Teacher Data");
        Teacher getTeacherById = session.get(Teacher.class, 1);
        System.out.println("Teacher Name: " + getTeacherById.getTeacher_name());
        System.out.println("Subject Name: " + getTeacherById.getSubject().getSubject_name());
        
        System.out.println("Subject Data");
        Subject getSubjectById = session.get(Subject.class, 1);
        System.out.println("Subject Name: " + getSubjectById.getSubject_name());
        System.out.println("Teacher Name: " + getSubjectById.getTeacher().getTeacher_name());
        
        
        transaction.commit();
        session.close();
        
    }
}
