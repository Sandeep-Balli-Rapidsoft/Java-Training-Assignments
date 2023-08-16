// Write a Java method that takes a map of student names and their corresponding grades as parameters and
// returns the name of the student with the highest grade.
package com.HighestGrade;
import java.util.*;
public class Test {
	
	public static String studentWithHighestGrade(HashMap<String, Double> grades) {
		Double highestGrade = 0.0;
		String studentNameWithHighestGrade = "";
		for(Map.Entry<String, Double> entry : grades.entrySet()) {
			if(entry.getValue() > highestGrade) {
				highestGrade = entry.getValue();
				studentNameWithHighestGrade = entry.getKey();
			}
		}
		return studentNameWithHighestGrade;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Double> grades = new HashMap<>();
		grades.put("Ashish", 94.50);
		grades.put("Biswajit", 91.00);
		grades.put("Manajit", 93.50);
		grades.put("Smruti", 95.00);
		grades.put("Sandeep", 70.00);
		
		
		System.out.println("Student With The Highest Grade:  " + studentWithHighestGrade(grades));
	}

}
