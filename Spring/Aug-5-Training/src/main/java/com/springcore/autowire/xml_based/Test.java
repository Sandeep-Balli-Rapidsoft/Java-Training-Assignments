package com.springcore.autowire.xml_based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/autowire/xml_based/xmlConfig.xml");
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
	}
}
