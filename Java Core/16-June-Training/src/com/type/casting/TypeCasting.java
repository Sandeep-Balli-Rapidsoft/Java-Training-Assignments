// Write a program that prompts the user to enter a double value. 
// Convert the double to an int and display the result.


package com.type.casting;
import java.util.Scanner;
public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the double value: ");
		double value = scn.nextDouble();
		System.out.println("After typing casting to int, the value is: " + (int) value);

	}

}
