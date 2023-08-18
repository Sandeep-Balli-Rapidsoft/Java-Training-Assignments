package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.service.ResultService;
import com.service.StudentService;
import com.service.SubjectService;

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
				System.out.println("Student Added Successfully.");
			} else if (optionEntered == 2) {
				SubjectService ss = new SubjectService();
				ss.addNewSubject();
				System.out.println("Subject Added Successfully.");
			} else if (optionEntered == 3) {
				ResultService rs = new ResultService();
				rs.insertNewResult();
				System.out.println("Student Result Added Successfully.");

			} else if (optionEntered == 4) {
				System.out.println("Enter Student Email");
				String student_email = br.readLine();
				ResultService rs = new ResultService();
				rs.getResultByEmail(student_email);

			} else if (optionEntered == 5) {
				ResultService rs = new ResultService();
				rs.getAllStudentData();
				
			} else {
				System.out.println("Exiting...");
				System.exit(0);
			}
		}
	}
}
