// Given a map of employee names and their corresponding departments. 
// Write a Java method to find the number of employees in each department.


package com.Employee;
import java.util.*;
public class Test {
	
	public static HashMap<String, Integer> NoOfEmployeesInEachDepartment(HashMap<String, String> employeeMap) {
		HashMap<String, Integer> departmentMap = new HashMap<>();
		for(Map.Entry<String, String> emp : employeeMap.entrySet()) {
			String department = emp.getValue();
			if(departmentMap.containsKey(department)) {
				departmentMap.put(department, departmentMap.get(department) + 1);
			} else {
				departmentMap.put(department, 1);
			}
		}
		return departmentMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> employeeMap = new HashMap<>();
		employeeMap.put("Sandeep Balli", "Backend");
		employeeMap.put("Smruti Ranjan", "Backend");
		employeeMap.put("Biswajit", "FullStack");
		employeeMap.put("Manajit Pradhan", "Backend");
		employeeMap.put("Nikhil", "Frontend");
		employeeMap.put("Ashish Chourasia", "Frontend");
		

		System.out.println(NoOfEmployeesInEachDepartment(employeeMap));
	}

}
