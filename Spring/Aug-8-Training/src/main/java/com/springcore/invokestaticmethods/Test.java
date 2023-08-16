package com.springcore.invokestaticmethods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/invokestaticmethods/invokestaticconfig.xml");
		Numbers n = context.getBean("numbers", Numbers.class);
		
		System.out.println(n);
		System.out.println();
	}
}
