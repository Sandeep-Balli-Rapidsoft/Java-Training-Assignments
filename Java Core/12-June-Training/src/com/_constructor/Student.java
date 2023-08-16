package com._constructor;
import java.util.Scanner;
public class Student {
	
	public Student(String name) {
		System.out.println("Name: " + name);
	}
	
	public Student(int java_mark, int javascript_mark) {
		System.out.println("Marks in Java: " + java_mark);
		System.out.println("Marks in JavaScript: " + javascript_mark);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the name of the student: " + " ");
		String name = scn.nextLine();
		
		System.out.print("Enter the marks in java: " + " ");
		int java_mark = scn.nextInt();
		System.out.print("Enter the marks in javascript: " + " ");
		int javascript_mark = scn.nextInt();
		
		Student student_name = new Student(name);
		Student Ram = new Student(java_mark, javascript_mark);
	}

}
