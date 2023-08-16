// Create a project where you can input the balance in run time and use a static variable
// where you can store the balance as 5000. 
// if the user is input the value exceed than 5000 then create your own exception class as,
// BalanceExceedException and print the message in console as you're able to withdraw upto 5000.


package com.BankBalance;
import java.util.Scanner;

public class UserDefinedException extends Exception {
	
	static int balance = 5000;
	String str;
	
	UserDefinedException(String str) {
		System.out.println(str);
	}
	

	public static void main(String[] args) throws UserDefinedException {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the amount you want to withdraw: ");
		int amount = scn.nextInt();
		try {
			if(amount < 5000) {
				System.out.println("Withdraw successful");
			} else {
				throw new UserDefinedException("Insufficient Balance");
			}
		} finally {
			System.out.println("Exiting...");
		}
	}

}
