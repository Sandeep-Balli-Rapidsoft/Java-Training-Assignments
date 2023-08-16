// Create a class called "Person" with a method "getDetails()" that returns a "Person" object. 
// Create a subclass called "Student" that extends "Person" and overrides the "getDetails()" method to return a "Student" object. 
// Implement a program to demonstrate covariant returns by calling the "getDetails()" method on both a "Person" object and a "Student" object.

package com.covariant.person;

class PersonSuperClass {
	public PersonSuperClass getDetails() {
		System.out.println("I am a Person");
		return new PersonSuperClass();
	}
}

class Student extends PersonSuperClass {
	public Student getDetails() {
		System.out.println("I am a Student");
		return new Student();
	}
}

public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonSuperClass person = new PersonSuperClass();
		person.getDetails();
		
		PersonSuperClass student = new Student();
		student.getDetails();
	}

}
