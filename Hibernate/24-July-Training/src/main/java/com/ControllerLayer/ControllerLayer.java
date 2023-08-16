package com.ControllerLayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ServiceLayer.ServiceLayer;

public class ControllerLayer {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void userMenu() throws Exception {
		while(true) {	
			System.out.println();
			System.out.println("Enter 1, to Add User");
			System.out.println("Enter 2, to Display Quiz");
			System.out.println("Enter 3, to Display Marks By Id");
			System.out.println("Enter 4, to Display All user Marks");
			System.out.println();
			
			Integer optionEntered = Integer.parseInt(br.readLine());
			checkForInvalidInput(4, optionEntered);
			if(optionEntered == 1) {
				ServiceLayer.addUser();
			}
			else if(optionEntered == 2) {
				ServiceLayer.displayQuiz();
			}
			else if(optionEntered == 3) {
				ServiceLayer.displayUserMarksById();
			}
			else if(optionEntered == 4) {
				ServiceLayer.getAllUserMarks();
			}

		}
	}
	public static void checkForInvalidInput(Integer end, Integer optionEntered) throws Exception {
		while(optionEntered < 1 || optionEntered > end) {
			System.out.println("Enter a valid input");
			userMenu();
		}
	}
}
