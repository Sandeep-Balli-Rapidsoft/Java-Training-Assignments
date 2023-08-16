package com.persondetails.constructor;

public class Person {
	String name;
	int age;
	
	Person(String personName, int personAge) {
		this.name = personName;
		this.age = personAge;
	}
	
	public void printPersonDetails() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person newPerson = new Person("Sandeep Balli", 23);
		newPerson.printPersonDetails();

	}

}
