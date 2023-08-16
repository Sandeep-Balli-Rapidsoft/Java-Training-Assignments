// Create a functional interface called MathOperation with a method calculate(int a, int b) that returns an integer. 
// Write a lambda expression that implements the MathOperation interface to calculate the product of two numbers.


package com.MathOperation;

@FunctionalInterface
interface MathOperation {
	public int calculate(int a, int b);
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// LAMDA EXPRESSION
		MathOperation mathOperation = (a, b)-> a * b;
		System.out.println("Product of two numbers is - " + mathOperation.calculate(10, 10));
	}

}
