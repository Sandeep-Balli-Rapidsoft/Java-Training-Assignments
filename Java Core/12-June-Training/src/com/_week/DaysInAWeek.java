package com._week;
import java.util.Scanner;

public class DaysInAWeek {
	
	public static void prints() {
		Scanner scn = new Scanner(System.in);
		System.out.println("To continue, Press 1");
		int n = scn.nextInt();
		if(n == 1) {
			System.out.println("Enter a day: ");
			int m = scn.nextInt();
			daysInAWeek(m);
		}
	}
	
	
	public static void daysInAWeek(int day) {
		
		switch(day) {
		case 1: {
			System.out.println("Monday");
			prints();
			
			break;
		}
		case 2: {
			System.out.println("Tuesday");
			prints();
			break;
		}
		case 3: {
			System.out.println("Wednesday");
			prints();
			break;
		}
		case 4: {
			System.out.println("Thursday");
			prints();
			break;
		}case 5: {
			System.out.println("Friday");
			prints();
			break;
		}
		case 6: {
			System.out.println("Saturday");
			prints();
			break;
		}case 7: {
			System.out.println("Sunday");
			prints();
			break;
		}
		
		// If the day entered is an invalid day, or if the day is > 7
		default: {
			System.out.println("Invalid Day");
		}
		
		} 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the day: " + " ");
		int day = scn.nextInt();
		daysInAWeek(day);
		
		
		
	}

}
