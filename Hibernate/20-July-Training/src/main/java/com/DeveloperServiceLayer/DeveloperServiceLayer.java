package com.DeveloperServiceLayer;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.DeveloperDAO.DeveloperDAO;
import com.DeveloperEntity.Developer;

public class DeveloperServiceLayer {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insertNewDeveloperrData() throws Exception {
		System.out.println("Enter Developer Name");
		String developerName = br.readLine();
		System.out.println("Enter Assigned Manager ID");
		Integer managerId = Integer.parseInt(br.readLine());

		DeveloperDAO.insertDeveloperData(developerName, managerId);
	}
	
	public static void getDeveloperById() throws Exception {
		System.out.println("Enter Developer Id");
		Integer developerId = Integer.parseInt(br.readLine());
		
		Developer developer = DeveloperDAO.getDeveloperById(developerId);
		
		System.out.println("Developer Id: " + developer.getId());
		System.out.println("Developer Name: " + developer.getDeveloper_name());
		System.out.println("Manager Name: " + developer.getManager().getManager_name());
	}

	
	public static void getAllDeveloperdata() {
		List<Developer> developerList = DeveloperDAO.getAllDevelopers();
		
		for(Developer developer : developerList) {
			System.out.println("Developer ID: " + developer.getId() + "\t Developer Name: " + developer.getDeveloper_name() + " \t Manager Name: " + developer.getManager().getManager_name());
			System.out.println();
		}
	}

}
