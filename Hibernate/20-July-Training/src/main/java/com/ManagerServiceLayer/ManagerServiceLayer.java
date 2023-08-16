package com.ManagerServiceLayer;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ManagerDAO.ManagerDAO;

public class ManagerServiceLayer {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void insertNewManagerData() throws Exception {
		System.out.println("Enter Project Manager Name");
		String managerName = br.readLine();
		ManagerDAO.insertManagerData(managerName);
	}
	
	public static void getAllEmployees() throws Exception {
		System.out.println("Enter Manager ID: ");
		Integer managerId = Integer.parseInt(br.readLine());
		
		List<String> list = ManagerDAO.getManagerEmployees(managerId);
		for(String emp : list)  {
			System.out.println(emp);
		}
	}
}
