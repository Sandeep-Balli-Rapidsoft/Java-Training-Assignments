package com.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeacherController {
	
	
	
	public static void userMenu() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {			
			System.out.println("Enter 1 to Insert Teacher Data");
			System.out.println("Enter 2 to Insert a New Subject");
			System.out.println("Enter 3 To Exit");
			Integer optionEntered = Integer.parseInt(br.readLine());
			
			
		}
		
	}
}
