// Write a program that uses lambda expressions to calculate the square root of each number in a list of doubles. 
// The program should take a list of doubles as input, use a lambda expression to calculate the
// square root of each number, and display the results as the output.


package com.SquareRoot;

import java.util.*;

interface CalculateSquareRoot {
	public void calculateSquareRoot(ArrayList<Double> list);
}

class Calculate {
	public static void calculateValues(ArrayList<Double> list) {
		for(int i = 0; i <  list.size(); i++) {
			System.out.println("Value - " + list.get(i) + " and Square root is - " + Math.sqrt(list.get(i)));
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<Double>();
		System.out.println("Enter the values: ");
		while(scn.hasNextDouble()) {
			list.add(scn.nextDouble());
		}
		
		// LAMDA EXPRESSION
		CalculateSquareRoot calculate = Calculate::calculateValues;
		calculate.calculateSquareRoot(list);
	}

}
