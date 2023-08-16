package com.SandeepBalli.CustomFunctions;

public class CustomFunctions {
	
	public static boolean checkInteger(String value) {
		try {
			Integer intValue = Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean checkDouble(String value) {
		try {
			Double doubleValue = Double.parseDouble(value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static Double convertToDouble(String value) {
		Double doubleValue = Double.parseDouble(value);
		return doubleValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomFunctions myFunctions = new CustomFunctions();
	}

}
