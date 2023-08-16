package com.NullPointerException;

public class NullException {
	int value = 10;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			NullException obj = null;
			System.out.println(obj.value);
		} catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("Exception Handled");
		}
		
	}

}
