package com.springcore.collectionswithvalue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collectionswithvalue/collectionswithvalue.xml");
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		System.out.println(student.getAddress());
	}

}
