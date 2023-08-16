// Create a final class called "MathUtils" with a method "addNumbers(int a, int b)" that adds two numbers and returns the result. 
// Implement a program to demonstrate the use of a final class by calling the "addNumbers()" method.

package com.finalkeyword.mathutils;

final class MathUtilsSuperClass {
	public int addNumbers(int num1, int num2) {
		return num1 + num2;
	}
}

public class MathUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathUtilsSuperClass newObject = new MathUtilsSuperClass();
		int num1 = 10;
		int num2 = 5;
		System.out.println("The sum of two numbers is: " + newObject.addNumbers(num1, num2));

	}

}
