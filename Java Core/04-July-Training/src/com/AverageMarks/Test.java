// Write a Java method that takes a map of student names and their corresponding marks in different subjects
// as parameters and returns the average marks for each student.
package com.AverageMarks;
import java.util.*;
public class Test {
	
	public static Map<String, Double> calculateAverageMarks(HashMap<String, ArrayList<Double>> studentMarks) {
		HashMap<String, Double> student = new HashMap<>();
		for(Map.Entry<String, ArrayList<Double>> eachStudent : studentMarks.entrySet()) {
			student.put(eachStudent.getKey(), calculateAverage(eachStudent.getValue()));
		}
		return student;
	}
	
	public static double calculateAverage(ArrayList<Double> marks) {
		double totalMarks = 0;
		for(double mark : marks) {
			totalMarks += mark;
		}
		double average = totalMarks / marks.size();
		return average;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<Double>> student = new HashMap<>();
		student.put("Asish", new ArrayList<>(Arrays.asList(80.00, 80.00 , 60.00, 60.00)));
		student.put("Smruti", new ArrayList<>(Arrays.asList(90.00, 80.00 , 70.00, 60.00)));	
		
		System.out.println(calculateAverageMarks(student));
	}

}
