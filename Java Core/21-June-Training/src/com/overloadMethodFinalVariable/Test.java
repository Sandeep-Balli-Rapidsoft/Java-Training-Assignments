// Write a program to showcase overloading of method with the use of final variables .

package com.overloadMethodFinalVariable;

public class Test {
	
	static final int VALUE = 10;
	
	public static void display(int value) {
		value = VALUE;
		System.out.println("I have a parameter and value is: " + value);
	}
	
	public static void display() {
		System.out.println("I do not have any parameters");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(10);
		display();
	}

}
