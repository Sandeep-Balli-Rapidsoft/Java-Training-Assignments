// Write a program that creates an object of a Person class represents a person with a name and age. 
// and overrides the toString() ,equals(),hashCode().

package com.OverrideFunctions;

class Person {
	public String name;
	public int age;
	
	public Person(String personName, int personAge) {
		this.name = personName;
		this.age = personAge;
	}
	
	@Override
	public String toString() {
		String userData = "Name: " + this.name + " Age: " + this.age;
		return userData;
	}
	
	@Override
	public boolean equals(Object newPerson) {
		if(this == newPerson) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		final int num = 2365;
		return num * age;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person newPerson = new Person("Sandeep Balli", 23);
		Person newPerson1 = new Person("Balli Sandeep", 23);
		System.out.println(newPerson.toString());
		System.out.println(newPerson.name.equals("Sandeep Balli"));
		System.out.println(newPerson.hashCode());
		System.out.println(newPerson1.hashCode());
		System.out.println(newPerson1.hashCode() == newPerson.hashCode());
		
		
	}

}
