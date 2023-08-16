package com.ControllerLayer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.ServiceLayer.ServiceLayer;

public class TeacherController {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void userMenu() throws Exception {
		while(true) {
			System.out.println("Enter 1 to insert teacher");
			System.out.println("Enter 2 to insert subject");
			System.out.println("Enter 3 to view teacher by id");
			System.out.println("Enter 4 to view subject by id");
			
			System.out.println("Enter 5 to exit");
			
			Integer optionEntered = Integer.parseInt(br.readLine());
			
			if(optionEntered == 1) {
				ServiceLayer.insertTeacher();
			}
			else if(optionEntered== 2) {
				ServiceLayer.getTeacherById();
			}
			else if(optionEntered == 3) {
				
			}
			else if(optionEntered == 4) {
				
			}
			else if(optionEntered == 5) {
				System.exit(0);
			}
		}
	}
	
}
