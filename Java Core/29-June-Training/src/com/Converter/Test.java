// Create a functional interface called Converter with a method convert(String str) that returns an integer. 
// Write a lambda expression that implements the Converter interface to parse a string and 
// return its length as an integer.

package com.Converter;

@FunctionalInterface
interface Converter {
	public int convert(String str);
}

public class Test {

	public static void main(String[] args) {
		String name = "Rapidsoft Technologies";
		
		// LAMDA EXPRESSION
		Converter converter = (str) -> {
			return str.length();
		};
		System.out.println("Length of the string " + name + " is - " + converter.convert(name));
		
	}
}
