package com.getset.person.details;

public class Person {
	
	String name;
	int age;
	
	public void setNameAndAge(String personName, int personAge) {
		this.name = personName;
		this.age = personAge;
	}
	
	public void getNameAndAge() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person newPerson = new Person();
		newPerson.setNameAndAge("Sandeep Balli", 23);
		newPerson.getNameAndAge();
	}

}
