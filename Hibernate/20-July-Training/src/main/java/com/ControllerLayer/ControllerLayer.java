package com.ControllerLayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.DeveloperServiceLayer.DeveloperServiceLayer;
import com.ManagerServiceLayer.ManagerServiceLayer;
import com.QAServiceLayer.QAServiceLayer;

public class ControllerLayer {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void userMenu() throws Exception {

		while (true) {

			System.out.println();
			System.out.println("---------------------");
			System.out.println("Enter 1 to Insert New Project Manager Data");
			System.out.println("Enter 2 to Insert New Developer Data");
			System.out.println("Enter 3 to Insert New Quality Analyst Data");
			System.out.println("Enter 4 to View Developer Data By Id");
			System.out.println("Enter 5 to View QA Data By Id");
			System.out.println("Enter 6 to View All Developer Data");
			System.out.println("Enter 7 to View All QA Data");
			System.out.println("Enter 8 to View All Employees Under A Project Manager");
			System.out.println("----------------------------");
			System.out.println();

			Integer optionEntered = Integer.parseInt(br.readLine());

			if (optionEntered == 1) {
				ManagerServiceLayer.insertNewManagerData();
			} else if (optionEntered == 2) {
				DeveloperServiceLayer.insertNewDeveloperrData();
			} else if (optionEntered == 3) {
				QAServiceLayer.insertNewQAData();
			} else if (optionEntered == 4) {
				DeveloperServiceLayer.getDeveloperById();
			} else if (optionEntered == 5) {
				QAServiceLayer.getQualityAnalystById();
			} else if (optionEntered == 6) {
				DeveloperServiceLayer.getAllDeveloperdata();
			} else if (optionEntered == 7) {

			} else if (optionEntered == 8) {
				ManagerServiceLayer.getAllEmployees();
			}
		}
	}
}
