package com.bank;

import java.math.BigInteger;
//Create a program for bank account management system that handles different types of accounts. 
//Create a BankAccount superclass with attributes like accountNumber, balance, and methods like withdraw() and deposit(). 
//Implement subclasses such as SavingsAccount and CheckingAccount that inherit from BankAccount and override methods as needed. 
//Use the super keyword to invoke superclass methods when necessary.
import java.util.*;

class BankAccount {
	String accountHolderName;
	BigInteger accountNumber;
	double balance;
	String accountType;
	int pin;

	public void withdraw(String accountType, double amount, int pin) {

	}

	public void deposit(double amount) {
		this.balance += amount;
	}

}

class SavingsAccount extends BankAccount {
	int allowedNoOfTransactions = 1;
	int noOfTotalTransactions = 0;
	boolean isChecked = true;
	public void show() {
		super.accountType = "Savings";
	}
}

class CheckingAccount extends BankAccount {
	public void setAccountType() {
		super.accountType = "Checking";
	}
}

class BankManagementSystem extends BankAccount {
	SavingsAccount savingAccount = new SavingsAccount();
	CheckingAccount checkingAccount = new CheckingAccount();

	Scanner scn = new Scanner(System.in);

	public void defaultPrints() {
		System.out.println("Welcome To Rapidsoft Bank");
		System.out.println("Enter 1 For Creating a Bank Account.");
		System.out.println("Enter 2 For Exit.");

		int optionEntered = scn.nextInt();

		while (optionEntered != 1 && optionEntered != 2) {
			handleInvalidInputs();
			defaultPrints();
		}

		if (optionEntered == 1) {
			createBankAccount();
		} else if (optionEntered == 2) {
			System.out.println("Thank you. Exiting...");
			System.exit(0);
		}
	}

	public void createBankAccount() {
		System.out.println("Enter your full name: ");
		super.accountHolderName = scn.next();
		System.out.println("Enter the account number: ");
		super.accountNumber = scn.nextBigInteger();
		System.out.println("Choose the account type: ");
		System.out.println("Enter 1 For Savings Account");
		System.out.println("Enter 2 For Current Account");
		int optionEntered = scn.nextInt();

		while (optionEntered != 1 && optionEntered != 2) {
			handleInvalidInputs();
			System.out.println("Choose the account type: ");
			System.out.println("Enter 1 For Savings Account");
			System.out.println("Enter 2 For Current Account");
		}
		if (optionEntered == 1) {
//			savingAccount.isChecked = true;
			super.accountType = "Savings";
		} else if (optionEntered == 2) {
//			savingAccount.isChecked = false;
			super.accountType = "Checking";
		}
		
		System.out.println("Enter the PIN number: ");
		super.pin = scn.nextInt();
		
		System.out.println("Enter the Amount you want to deposit: ");
		double amountToBeDeposited = scn.nextDouble();
		super.deposit(amountToBeDeposited);
		
		System.out.println("Account created successfully");
		toContinueOrExit();
	}
	
	public int accountType() {
		System.out.println("Choose the account type: ");
		System.out.println("Enter 1, For Savings Account: ");
		System.out.println("Enter 2, For Checking Account: ");
		int optionEntered = scn.nextInt();

		while (optionEntered != 1 && optionEntered != 2) {
			handleInvalidInputs();
			accountType();
		}
		return optionEntered;
	}
	
	public boolean verifyPin(int enteredPin) {
		if(enteredPin != super.pin) {
			System.out.println("Incorrect PIN");
			return false;
		}
		
		return true;
	}
	
	public void savingsAccountWithDrawal() {
		if(savingAccount.noOfTotalTransactions > savingAccount.allowedNoOfTransactions) {
			System.out.println("You have exceeded the limit of no. of transactions");
		} else {
			System.out.println("Enter the amount you want to withdraw: ");
			double amountToBeWithDrawal = scn.nextDouble();
			System.out.println("Enter the pin: ");
			int enteredPin = scn.nextInt();
			if(verifyPin(enteredPin)) {
				if(amountToBeWithDrawal > super.balance) {
					System.out.println("Insufficient Balance");
					toContinueOrExit();
				} else {
					super.balance -= amountToBeWithDrawal;
					System.out.println("Amount Withdrawal Successful.");
					savingAccount.noOfTotalTransactions++;
					toContinueOrExit();
				}
			}
		}
	}
	
	public void checkingAccountWithDrawal() {
		System.out.println("Enter the amount you want to withdraw: ");
		double amountToBeWithDrawal = scn.nextDouble();
		System.out.println("Enter the pin: ");
		int enteredPin = scn.nextInt();
		if(verifyPin(enteredPin)) {
			if(amountToBeWithDrawal > super.balance) {
				System.out.println("Insufficient Balance");
				toContinueOrExit();
			} else {
				super.balance -= amountToBeWithDrawal;
				System.out.println("Amount Withdrawal Successful.");
				toContinueOrExit();
			}
		}
	}
	
	public void withdrawMoney() {
		if(accountType() == 1) {
			savingsAccountWithDrawal();
		} else if (accountType() == 2) {
			checkingAccountWithDrawal();
		}
	}
	
	public void toContinueOrExit() {
		System.out.println("Enter 1, To Continue");
		System.out.println("Enter 2, To Exit");
		
		int optionEntered = scn.nextInt();
		while(optionEntered != 1 && optionEntered != 2) {
			handleInvalidInputs();
			toContinueOrExit();
			optionEntered = scn.nextInt();
		}
		if(optionEntered == 1) {
			userView();
		} else if(optionEntered == 2) {
			System.out.println("Exiting..");
			System.exit(0);
		}
	}
	
	public void userView() {
		System.out.println("Enter 1, To Withdraw Money.");
		System.out.println("Enter 2, To Deposit Money.");
		System.out.println("Enter 3, To Print E-Receipt");
		System.out.println("Enter 4, To Exit");
		
		int optionEntered = scn.nextInt();
		while(optionEntered < 1 && optionEntered > 4) {
			handleInvalidInputs();
			userView();
		}
		
		if(optionEntered == 1) {
			withdrawMoney();
		} else if(optionEntered == 2) {
			System.out.println("Enter the amount you want to deposit: ");
			double amountToBeDeposited = scn.nextDouble();
			super.deposit(amountToBeDeposited);
			System.out.println("Amount Deposited Successfully.");
			toContinueOrExit();
		} else if(optionEntered == 3) {
			displayUserInfo();
			toContinueOrExit();
		} else if(optionEntered == 4) {
			System.out.println("Thank you for choosing us.");
			System.exit(0);
		}
	}
	
	public void displayUserInfo() {
		System.out.println("Account Holder Name: " + super.accountHolderName);
		System.out.println("Account Number: " + super.accountNumber);
		System.out.println("Account Type: " + super.accountType);
		System.out.println("Balance: " + super.balance);
	}

	public void handleInvalidInputs() {
		System.out.println("Kindly choose from the given options");
	}

}

public class Bank {

	
	public static void main(String[] args) {
		BankManagementSystem bms = new BankManagementSystem();
		bms.defaultPrints();
	}
}
