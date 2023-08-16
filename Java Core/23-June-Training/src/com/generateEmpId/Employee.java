package com.generateEmpId;

import java.util.Scanner;
class CreateEmployee {
	private static CreateEmployee getInstance = null;
	int initialId = 3000;
	String empId;
	String empName;
	int empAge;
	String empDepartment;
	String empEmail;
	String companyCode = "RST";
	final String mailId = "@rapidsoft.co.in";
	
	private CreateEmployee() {
		
	}
	
	
	public String generateEmployeeId() {
		this.empId = this.companyCode+initialId;
		initialId++;
		return empId;
	}
	
	public void setUserData(String name, int age, String department) {
		this.empName = name;
		this.empAge = age;
		this.empDepartment = department;
	}
	
	public String generateEmployeeMailAddress(String name, String id) {
		empEmail = name+"."+id+this.mailId;
		String email = empEmail.replaceAll("\\s+","");
		return email.toLowerCase();
	}
	
	public void displayUserData() {
		empId = generateEmployeeId();
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + this.empName);
		System.out.println("Employee Age: " + this.empAge);
		System.out.println("Employee Department: " + this.empDepartment);
		System.out.println("Employee Mail Id: " + generateEmployeeMailAddress(this.empName, empId));
	}
	
	static CreateEmployee getInstance() {
		if(getInstance == null) {
			getInstance = new CreateEmployee();
		}
		return getInstance;
	}
	
}

public class Employee {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Employee Name: ");
		String name = scn.next();
		System.out.println("Enter Employee Age: ");
		int age = scn.nextInt();
		System.out.println("Enter Department: ");
		String department = scn.next();
		
		CreateEmployee newEmployee = CreateEmployee.getInstance();
		newEmployee.setUserData(name, age, department);
		newEmployee.displayUserData();
		System.out.println(newEmployee.getInstance());
		
	}

}
