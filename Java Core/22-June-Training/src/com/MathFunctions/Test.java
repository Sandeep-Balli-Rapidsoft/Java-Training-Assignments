package com.MathFunctions;

public class Test {
	
	public static void displayAllFunctions() {
		int value1 = 10;
		int value2 = 5;
		
		System.out.println("Maximum value between, " + value1 + " and " + value2 + " is: " + Math.max(value1, value2));
		System.out.println("Minimum value between, " + value1 + " and " + value2 + " is: " + Math.min(value1, value2));
		
		System.out.println("Maximum value of Integer is: " + Integer.MAX_VALUE);
		System.out.println("Minimum value of Integer is: " + Integer.MIN_VALUE);
		
		System.out.println("Round value of 3.6 is: " + Math.round(3.6));
		
		System.out.println("Ceil Value of 3.6 is: " + Math.ceil(3.6));
		System.out.println("Floor value of 3.6 is: " + Math.floor(3.6));
		
		System.out.println("Power of 5 is: " + Math.pow(5, 2));
		System.out.println("Square root of 16 is: " + Math.sqrt(16.0));
		
		System.out.println("Absoulte value of -10 is: " + Math.abs(-10));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayAllFunctions();
	}

}
