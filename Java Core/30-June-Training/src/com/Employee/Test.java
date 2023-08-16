package com.Employee;

import java.util.*;
class EmployeeData {
	String employeeName;
	String empId;
	String empEmail;
	int phone;
	int age;
	
	public EmployeeData(String employeeName, String empId, String empEmail, int phone, int age) {
		this.employeeName = employeeName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.phone = phone;
		this.age = age;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		EmployeeData employee = new EmployeeData();
		List <EmployeeData> list = new ArrayList<>();
		list.add(new EmployeeData("Steve", "RST100", "steve@rapidsoft.co.in", 565642, 13));
		list.add(new EmployeeData("John", "RST101", "john@rapidsoft.co.in", 565642, 23));
		list.add(new EmployeeData("Alex", "RST102", "alex@rapidsoft.co.in", 565642, 13));
		list.add(new EmployeeData("Tom", "RST103", "tom@rapidsoft.co.in", 565642, 23));
		list.add(new EmployeeData("Harry", "RST104", "harry@rapidsoft.co.in", 565642, 23));
		
		for(EmployeeData emp : list) {
			if(emp.age >= 20) {
				System.out.println("Name: " + emp.employeeName + ", " + "Age - " + emp.age);
			}
		}
	}

}
