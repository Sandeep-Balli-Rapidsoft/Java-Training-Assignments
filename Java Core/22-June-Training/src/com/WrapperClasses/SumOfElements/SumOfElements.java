// Write a program that creates an array of wrapper class objects (Integer, Double, etc.), 
// assigns values to them, and calculates the sum of the array elements.

package com.WrapperClasses.SumOfElements;

public class SumOfElements {
	
	public static void integerArray(Integer arr[]) {
		int sum = 0;
		for(int idx = 0; idx < arr.length; idx++) {
			sum += arr[idx];
		}
		System.out.println("The sum of the integer array elements is: " + sum);
	}
	
	public static void doubleArray(Double arr[]) {
		double sum = 0;
		for(int idx = 0; idx < arr.length; idx++) {
			sum += arr[idx];
		}
		System.out.println("The sum of the double array elements is: " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer intArr[] = {1,2,3,4,5};
		integerArray(intArr);
		Double[] doubleArr = {1.0,11.0,21.0,31.0,41.0};
		doubleArray(doubleArr);
	}

}
