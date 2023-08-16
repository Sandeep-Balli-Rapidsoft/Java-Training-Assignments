package com.studentDetails;
import java.util.Scanner;

public class Student {
	
	// Instance Variables
	private String name;
	private int age;
	private char grade;
	
	// Setter Method for Student Name
	public void setStudentName(String studentName) {
		this.name = studentName;
	}
	
	// Setter Method for Student Age
	public void setStudentAge(int studentAge) {
		this.age = studentAge;
	}
	
	// Setter Method for Student Grade
	public void setStudentGrade(char studentGrade) {
		this.grade = studentGrade;
	}
	
	// Getter Method for Student Name
	public String getStudentName() {
		return name;
	}
	
	// Getter Method for Student Age
	public int getStudentAge() {
		return age;
	}
	
	// Getter Method for Student Grade
	public char getStudentGrade() {
		return grade;
	}
	
	// Method to print the student data.
	public void studentDetails() {
		System.out.println("Student name: " + getStudentName());
		System.out.println("Student age: " + getStudentAge());
		System.out.println("Student grade: " + getStudentGrade());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// User input for student data
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the name of the student:" + " ");
		String name = scn.nextLine();
		System.out.print("Enter the age of the student:" + " ");
		int age = scn.nextInt();
		System.out.print("Enter the grade of the student:" + " ");
		char grade = scn.next().charAt(0);
		
		Student newStudent = new Student();
		newStudent.setStudentName(name);
		newStudent.setStudentAge(23);
		newStudent.setStudentGrade('A');
		
		newStudent.studentDetails();

	}

}
