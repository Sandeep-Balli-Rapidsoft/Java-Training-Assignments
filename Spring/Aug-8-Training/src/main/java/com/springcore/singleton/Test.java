package com.springcore.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/singleton/singletonconfig.xml");
		Student student = context.getBean("ob", Student.class);
		Teacher teacher1 = context.getBean("teacher", Teacher.class);
		Teacher teacher2 = context.getBean("teacher", Teacher.class);
		
		System.out.println("Teacher 1 Hashcode: " + teacher1.hashCode());
		System.out.println("Teacher 2 Hashcode: " + teacher2.hashCode());
	}

}
