package com.NumberFormatException;

public class NumberException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			String str = "Rapidsoft";
			Integer intValue = Integer.parseInt(str);
			System.out.println(intValue);
		} catch (NumberFormatException e) {
			System.out.println("Exception Handled");
			e.printStackTrace();
		}
	}

}
