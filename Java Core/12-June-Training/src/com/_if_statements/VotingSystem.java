package com._if_statements;
import java.util.Scanner;

public class VotingSystem {
	
	public static void prints() {
		System.out.println("Press 1, If you have a voter ID.");
		System.out.println("Press 2, If you don't have a voter ID.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int current_year = 2023;
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your year of birth:" + " ");
		int user_yearOfBirth = scn.nextInt();
		
		// Calculating the age
		int age = current_year - user_yearOfBirth;
		
		// Checks the age of the user.
		if(age >= 18) {
			
			prints();
			int temp = scn.nextInt();
			
			// The below block executes until the user input is either 1 or 2.
			while(temp != 1 && temp != 2) {
				System.out.println("You can only enter either 1 or 2.");
				prints();
				temp = scn.nextInt();
			}
			
			if(temp == 1) {
				System.out.println("You are eligible for voting!");
			} else if(temp == 2) {
				System.out.println("You cannot vote without a Voter ID.");
			}
			
		} else {
			System.out.println("You are not eligible for voting.");
		}

	}

}
