package com.EmployeeUserInput;
import java.util.*;
import java.time.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.Sandeep.CustomFunctions.*;

class NewEmployee {
	
	String employeeName;
	String employeeID;
	int employeeAge;
	String employeeEmail;
	String employeePhone;
	
	public NewEmployee(String employeeName, String employeeID, int employeeAge, String employeeEmail, String employeePhone) {
		this.employeeName = employeeName;
		this.employeeID = employeeID;
		this.employeeAge = employeeAge;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
	}
}

class TakeInput {
	Scanner scn = new Scanner(System.in);
	Custom function = new Custom();
	List<NewEmployee> list = new ArrayList<>();
	
	public void userMenu() throws ParseException {
		System.out.println();
		System.out.println("Enter 1 to Add Employee Data");
		System.out.println("Enter 2 to view employee whose age is greater than you want");
		System.out.println("Enter 3 to Exit");
		int optionEntered = scn.nextInt();
		while(optionEntered != 1 && optionEntered != 2 && optionEntered != 3) {
			System.out.println("Only Enter 1, 2 or 3");
			userMenu();
		}
		if(optionEntered == 1) {
			inputEmployeeData();
		} else if(optionEntered == 2) {
			employeeAgeGreaterThanTwenty();
		} else {
			System.out.println("Exiting....");
			System.exit(0);
		}
		System.out.println();

	}
	
	public void inputEmployeeData() throws ParseException {
		
		System.out.println("Enter Employee Name: ");
		scn.next();
		String empName = scn.next();
		System.out.println("Enter Employee ID: ");
		String empId = scn.next();
		System.out.println("Enter Employee DOB: ");		
		String dob = scn.next();
		System.out.println("Enter Employee Email: ");
		String email = scn.next();
		System.out.println("Enter Employee Phone no: ");
		String phone = scn.next();
		
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(dob);
		long birthYearInMilliseconds = date.getTime();
		
		
		Date today = new Date();
		long currentYearInMilliseconds = today.getTime();
		
		int age = calculateAge(currentYearInMilliseconds, birthYearInMilliseconds);
		
		list.add(new NewEmployee(empName, empId, age, email, phone));
		
		userMenu();
		
	}
	
	public int calculateAge(long currentYearInMilliseconds, long birthYearInMilliseconds) {
		long ageInMilliseconds = birthYearInMilliseconds - currentYearInMilliseconds;
		 int age = (1000 / 60 / 60 / 24);
		 return age;
	}
	
	public void employeeAgeGreaterThanTwenty() throws ParseException {
		System.out.println("Enter the age you want to check for: ");
		int age = scn.nextInt();
		for(NewEmployee emp : list) {
			
			if(emp.employeeAge > age) {
				System.out.println("Name - " + emp.employeeName + " " + "Age - " +  emp.employeeAge);
			}
		}
		userMenu();
	}
}

public class Employee {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		TakeInput input = new TakeInput();
		input.userMenu();
	}
}
