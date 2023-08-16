// Create a program for student management system that stores information about students. 
// Create a Person superclass with attributes like name and age. 
// Implement a Student subclass that inherits from Person and adds attributes like studentId , class and section.
//Override methods like displayInfo() in the Student subclass to provide specific information. 
// Use conversion and casting to manipulate objects of different types in the system.


package com.student.management.system;
import java.util.Scanner;
public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonBaseClass student = new Student();
		student.displayInfo();

	}

}

class PersonBaseClass {
	String name;
	int age;
	
	public void displayInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
	}
}

class Student extends PersonBaseClass {
	int studentId;
	char studentClass;
	char studentSection;
	
	public void displayInfo() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the name of the student: " + " ");
		String name = scn.nextLine();
		System.out.println("Enter the age of the student: " + " ");
		int age = scn.nextInt();
		System.out.println("Enter the ID of the student: " + " ");
		studentId = scn.nextInt();
		System.out.println("Enter the class of the student: " + " ");
		studentClass = (char) scn.nextInt();
		System.out.println("Enter the section of the student: " + " ");
		char section = scn.next().charAt(0);
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Class: " + studentClass);
		System.out.println("Section: " + section);
	}
	
}
