package com.finallyBlock;

public class FinalBlock {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			Class.forName("Test");
		} catch(ClassNotFoundException e) {
			System.out.println("Exception Handled");
			e.printStackTrace();
		} finally {
			System.out.println("No matter what, I'll execute.. because I'm in finally block");
		}
		
	}

}
