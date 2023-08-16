package com.Sandeep.CustomFunctions;
import java.util.Scanner;
public class Custom {
	
	public boolean isInteger(String value) {
		try {
			Integer intValue = Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {
			System.out.println(value + " is not a valid integer");
			return false;
		}
	}
	
	public boolean isDouble(String value) {
		try {
			Double doubleValue = Double.parseDouble(value);
			return true;
		} catch(NumberFormatException e) {
			System.out.println(value + " is not a valid Double");
			return false;
		}
	}
	
	public int toInteger(String value) {
		if(isInteger(value)) {
			return Integer.parseInt(value);
		}
		
		return 0;
	}
	
	public Double toDouble(String value) {
		if(isDouble(value)) {
			return Double.parseDouble(value);
		}
		
		return 0.0;
	}
	
	public void checkType(String value) {
		if(isInteger(value)) {
			toInteger(value);
		} else if(isDouble(value)) {
			toDouble(value);
		}
	}
	

	public static void main(String[] args) {
		Custom cst = new Custom();
	}
}
