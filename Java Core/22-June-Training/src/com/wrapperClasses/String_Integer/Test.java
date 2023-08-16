package com.wrapperClasses.String_Integer;

//Write a program that demonstrates the usage of wrapper classes by converting an integer to a string and a string to an integer.


public class Test {
	
	public static void integerToString() {
		Integer intValue = new Integer(10);
		String strValue = String.valueOf(intValue);
		System.out.println(strValue);
	}
	
	public static void stringToInteger() {
		String strValue = new String("20");
		Integer intValue = Integer.valueOf(strValue);
		System.out.println(intValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		integerToString();
		stringToInteger();
	}

}
