// Given a map of employee names and their corresponding salaries, 
// write a Java method to find the employee with the highest salary.
package com.HighestSalary;
import java.util.*;
public class Test {
	
	public static Map<String, Double> highestSalary(HashMap<String, Double> salaries) {
		Map<String, Double> employeeMap = new HashMap<>();
		double salary = 0.0;
		for(Map.Entry<String, Double> emp : salaries.entrySet()) {
			if(emp.getValue() >= salary) {
				salary = emp.getValue();
				employeeMap.put(emp.getKey(), emp.getValue());
			}
		}
		return employeeMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Double> employeeMap = new HashMap<>();
		employeeMap.put("Ashish", 123000.00);
		employeeMap.put("Biswajit Sahu", 124000.00);
		employeeMap.put("Manajit Pradhan", 125000.00);
		employeeMap.put("Smruti Ranjan", 125000.00);
		employeeMap.put("Sandeep Balli", 60000.00);
		employeeMap.put("Manajit Pradhan", 125000.00);
		
		System.out.println(highestSalary(employeeMap));
	}

}
