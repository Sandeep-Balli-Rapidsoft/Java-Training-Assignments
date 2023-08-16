package com.cloneable;


public class Test implements Cloneable {
	
	String name;
	int age;
	int id;
	String department;
	
	
	Test(String personName, int personAge, int personId, String department) {
		this.name = personName;
		this.age = personAge;
		this.id = personId;
		this.department = department;
		
	}
	
	public void displayInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Id: " + this.id);
		System.out.println("Department: " + this.department);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Test p1 = new Test("Sandeep Balli", 23, 475, "IT");
		Test p2 = (Test) p1.clone();
		p2.displayInfo();
	}

}
