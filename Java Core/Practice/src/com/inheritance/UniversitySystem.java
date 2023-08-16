// Create a class hierarchy for a university system. 
// Start with a base class Person and create derived classes such as Student and Faculty. 
// Implement methods to calculate the average grade for a student and display the faculty details including their research interests.

package com.inheritance;
import java.util.*;
import java.math.*;

class Person {
	String name;
	int age;
	String gender;
	Scanner scn = new Scanner(System.in);
	public void displayInfo() {
		System.out.println("I am from parent class");
	}
}

class Student extends Person {
	int studentId = generateRandomId();
	String majors;
	double grades[] = new double[8];
	
	public void studentInput() {
		System.out.println("Enter your full name: ");
		super.name = scn.nextLine();
		System.out.println("Enter your age: ");
		super.age = scn.nextInt();
		System.out.println("Enter your gender: ");
		scn.nextLine();
		super.gender = scn.nextLine();
		System.out.println("Enter your major: ");
		this.majors = scn.nextLine();
		System.out.println("Enter your grades: ");
		for(int i = 0; i < grades.length; i++) {
			grades[i] = scn.nextDouble();
		}
	}
	
	public void displayStudentInfo() {
		System.out.println("Student Name: " + super.name);
		System.out.println("Student Age: " + super.age);
		System.out.println("Student Gender: " + super.gender);
		System.out.println("Student Major: " + this.majors);
		System.out.println("Student grades: ");
		for(int i = 0; i < grades.length; i++) {
			System.out.print(grades[i] + " ");
		}
		System.out.println();
		System.out.println("Student Average: " + calculateStudentAverage());
		System.out.println("Student ID: " + this.studentId);
	}
	
	public double calculateStudentAverage() {
		int average = 0;
		for(int i = 0; i < grades.length; i++) {
			average += grades[i];
		}
		return average / grades.length;
	}
	
	public int generateRandomId() {
		Random random = new Random();
		int generatedId = random.nextInt(9999) + 1000;
		return generatedId;
	}
	
}

public class UniversitySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.studentInput();
		student.displayStudentInfo();
	}

}
