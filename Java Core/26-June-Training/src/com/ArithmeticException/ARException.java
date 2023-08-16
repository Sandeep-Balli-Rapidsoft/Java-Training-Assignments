package com.ArithmeticException;

public class ARException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			int value1 = 10;
			int value2 = 0;
			
			int result = value1/value2;
			System.out.println(result);
			
		} catch(ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Exception Handled");
			
		}
	}

}
