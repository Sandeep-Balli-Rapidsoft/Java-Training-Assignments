package com.varargs.calculator;
import java.util.Scanner;
public class Calculator {
	
	public int sumNumbers(int... values) {
		int sum = 0;
		for(int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter the size of the array: ");
		int size = scn.nextInt();
		int arr[] = new int[size];
		System.out.print("Enter the array elements: " + " ");
		for(int i = 0; i < size; i++) {
			arr[i] = scn.nextInt();
		}
		
		Calculator calc = new Calculator();
		int sum = calc.sumNumbers(arr);
		System.out.println("The sum of all the elements is: " + sum);

	}

}
