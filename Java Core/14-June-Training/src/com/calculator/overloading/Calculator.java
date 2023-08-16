package com.calculator.overloading;
import java.util.Scanner;
public class Calculator {
	
	// Method To Add Two Integer Values
	public void add(int value1, int value2) {
		int sum = value1 + value2;
		System.out.print("The sum of two integer values is: " + sum);
	}
	
	
	// Method To Add Three Integer Values
	public void add(int value1, int value2, int value3) {
		int sum = value1 + value2 + value3;
		System.out.print("The sum of three integer values is: " + sum);
	}
	
	
	// Method To Add Two Double Values 
	public void add(double value1, double value2) {
		double sum = value1 + value2;
		System.out.print("The sum of two double values is: " + sum);
	}
	
	public void prints() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the values for sum of two values");
		System.out.print("Enter the first value:" + " ");
		int value1 = scn.nextInt();
		System.out.print("Enter the second value:" + " ");
		int value2 = scn.nextInt();
		add(value1, value2);
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Enter the values for sum of three values");
		System.out.print("Enter the first value:" + " ");
		int value3 = scn.nextInt();
		System.out.print("Enter the second value:" + " ");
		int value4 = scn.nextInt();
		System.out.print("Enter the third value:" + " ");
		int value5 = scn.nextInt();
		add(value3, value4, value5);
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Enter the values for sum of two double values");
		System.out.print("Enter the first value:" + " ");
		double value6 = scn.nextDouble();
		System.out.print("Enter the second value:" + " ");
		double value7 = scn.nextDouble();
		add(value6, value7);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		calc.prints();

	}

}
