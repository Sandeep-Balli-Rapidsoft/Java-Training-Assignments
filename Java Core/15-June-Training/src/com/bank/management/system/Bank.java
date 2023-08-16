//  Create a program for bank account management system that handles different types of accounts. 
// Create a BankAccount superclass with attributes like accountNumber, balance, and methods like withdraw() and deposit(). 
// Implement subclasses such as SavingsAccount and CheckingAccount that inherit from BankAccount and override methods as needed. 
// Use the super keyword to invoke superclass methods when necessary.

package com.bank.management.system;

import java.math.BigInteger;

class BankSuperClass {
	BigInteger accountNumber;
	double balance;
	
	public void widthDraw(double money) {
		System.out.println("I am parent class - Withdrwal");
	}
	
	public void deposit(double money) {
		System.out.println("I am parent class - Deposit");
	}
}

class SavingsAccount extends BankSuperClass {
	
	public void withdraw(double money) {
		System.out.println("This is a Savings account.");
		if(super.balance < money) {
			System.out.println("Insufficient Balance.");
		} else {
			super.balance -= money;
			System.out.println("Amount Withdrawal Successful");
		}
	}
	
	public void deposit(double money) {
		System.out.println("This is a Savings account.");
		super.balance += money;
		System.out.println("Amount credited successfully.");
	}
}

class CheckingAccount extends BankSuperClass {
	public void withdraw(double money) {
		System.out.println("This is a checking account.");
		if(super.balance < money) {
			System.out.println("Insufficient Balance.");
		} else {
			super.balance -= money;
			System.out.println("Amount Withdrawal Successful");
		}
	}
	
	public void deposit(double money) {
		System.out.println("This is a checking account.");
		super.balance += money;
		System.out.println("Amount credited successfully.");
	}
}

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount bank = new SavingsAccount();
		bank.deposit(1000);
		bank.withdraw(100);

	}

}
