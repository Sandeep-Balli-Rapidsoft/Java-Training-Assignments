package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/standalone/collections/collectionsConfig.xml");
		Person person = context.getBean("Person", Person.class);
		System.out.println(person);
		System.out.println("------------------------------------------------");
		System.out.println(person.getFeeStructure());
		System.out.println("------------------------------------------------");
		System.out.println(person.getProperties());
	}

}
