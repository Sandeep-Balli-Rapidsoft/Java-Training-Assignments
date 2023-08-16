// Write a Java method that takes a map of student names and their corresponding grades
// in different subjects as parameters and returns a new map with the average grade for each student.
package com.AverageGrade;

import java.util.*;
import java.util.Map.Entry;

public class Test {
	public static HashMap<String, Double> calculateAverageMarks(HashMap<String, HashMap<String, Double>> studentMarks) {
		HashMap<String, Double> student = new HashMap<>();
		for(Map.Entry<String, HashMap<String, Double>> eachStudent : studentMarks.entrySet()) {
			student.put(eachStudent.getKey(), calculateAverage(eachStudent.getValue()));
		}
		return student;
	}
	
	public static double calculateAverage(HashMap<String, Double> grades) {
		int totalMarks = 0;
		for(Map.Entry<String, Double> mark : grades.entrySet()) {
			totalMarks += mark.getValue();
		}
		double average = totalMarks / grades.size();
		return average;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String, Double>> student = new HashMap<>();
		HashMap<String, Double> student1 = new HashMap<>();
		student1.put("Java", 95.00);
		student1.put("C", 85.00);
		student1.put("JavaScript", 95.00);
		student1.put("Python", 85.00);
		student.put("Sandeep Balli", student1);
		
		
		HashMap<String, Double> student2 = new HashMap<>();
		student2.put("Java", 90.00);
		student2.put("C", 80.00);
		student2.put("JavaScript", 90.00);
		student2.put("Python", 80.00);
		student.put("Elon Musk", student2);
		
		
		for(Map.Entry<String, HashMap<String, Double>> allStudents : student.entrySet()) {
			System.out.println("Name: " + allStudents.getKey());
			HashMap<String, Double> studentMap = new HashMap<>();
			studentMap = allStudents.getValue();
			for(Map.Entry<String, Double> eachStudent : studentMap.entrySet()) {
				System.out.println(eachStudent.getKey() + " " + eachStudent.getValue());
			}
			System.out.println("Average: " + calculateAverage(studentMap));
			
			System.out.println("------------");
		}
		
	}

}
