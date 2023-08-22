package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.service.ResultService;
import com.service.StudentService;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ResultService rs = new ResultService();

		while (true) {
			System.out.println("Enter 1, to Add New Student Data");
			System.out.println("Enter 2, to Add Result");
			System.out.println("Enter 3, to Display Student Data By Email");
			System.out.println("Enter 4, to Display All Students Data");
			System.out.println("Enter 5, To Apply for Recheck");
			System.out.println("Enter 6, To View Students Who Applied For Recheck");
			System.out.println("Enter 7, To Update Mark");
			System.out.println("Enter 8, To Exit");
			System.out.println("Enter 9, to View Student Data in List");

			try {
				int optionEntered = Integer.parseInt(br.readLine());

				switch (optionEntered) {
				case 1:
					StudentService ss = new StudentService();
					ss.insertNewStudent();

					break;
				case 2:
					rs.insertNewResult();

					break;
				case 3:
					System.out.println("Enter Student Email");
					String studentEmail = br.readLine();
					rs.getResultByEmail(studentEmail);
					break;
				case 4:
					rs.getAllStudentData();
					break;
				case 5:
					System.out.println("Enter Student Email");
					String studentEmailForRecheck = br.readLine();
					rs.applyForRecheck(studentEmailForRecheck);
					break;
				case 6:
					rs.studentsAppliedForRecheck();
					break;
				case 7:
					System.out.println("Enter Student Email");
					String studentEmailForUpdate = br.readLine();
					rs.updateMarkForStudent(studentEmailForUpdate);
					break;
				case 8:
					System.out.println("Exiting...");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid option. Please try again.");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}
	}
}
