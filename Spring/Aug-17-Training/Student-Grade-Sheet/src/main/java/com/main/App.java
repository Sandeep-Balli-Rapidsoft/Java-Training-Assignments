package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.service.ResultService;
import com.service.StudentService;
import com.service.SubjectService;
import com.util.CalculateMarks;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Enter 1, to Add New Student Data");
			System.out.println("Enter 2, to Add Subject");
			System.out.println("Enter 3, to Add Result");
			System.out.println("Enter 4, to Display Student Data By Email");
			System.out.println("Enter 5, to Display All Students Data");

			Integer optionEntered = Integer.parseInt(br.readLine());

			if (optionEntered == 1) {
				StudentService ss = new StudentService();
				ss.insertNewStudent();
			}
			else if(optionEntered == 2) {
				SubjectService ss = new SubjectService();
				ss.addNewSubject();
			}
			else if(optionEntered == 3) {
				ResultService rs = new ResultService();
				rs.insertNewResult();
				
			} 
			else if(optionEntered == 4) {
				System.out.println("Enter Student Email");
				String student_email = br.readLine();
				CalculateMarks cm = new CalculateMarks();
				Double percentage = cm.calculatePercentageByEmail(student_email);
				String grade = cm.calculateGrade(percentage);
				if(percentage != 0.0) {					
					System.out.println("Percentage: " + percentage);
					System.out.println("Grade Secured: " + grade);
				}else {
					System.out.println("Student does not exist");
				}
				
			} else if(optionEntered == 5) {
				CalculateMarks cm = new CalculateMarks();
				cm.displayAllStudentData();
			}
			else {
				System.out.println("Exiting...");
				System.exit(0);
			}
		}

	}
}
