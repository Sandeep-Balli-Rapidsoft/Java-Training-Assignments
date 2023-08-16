package com.SpringCore.Ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCore/Ref/ref-config.xml");
		
		A obj = (A) context.getBean("aref");
		
		System.out.println("Value of X in Class A: " + obj.getX());
		System.out.println("Value of Y in Class B: " + obj.getObj().getY());
	}
}
