package com.atm.management.system;
import java.util.Scanner;
import java.math.BigInteger; 
public class Atm {
	
	// Instance Variables
	private BigInteger accountNumber;
	private String accountHolderName;
	private double balance;
	private int pin;
	
	
	// Setter For Account Number
	public void setAccountNumber(BigInteger accNum) {
		this.accountNumber = accNum;
	}
	
	// Setter For Account Holder Name
	public void setAccountHolderName(String username) {
		this.accountHolderName = username;
	}
	
	// Setter For Name
	public void setPin(int pinNumber) {
		this.pin= pinNumber;
	}
	
	// Setter For Balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// Setter For Depositing Money
	public void depositMoney(double money) {
		this.balance += money;
	}
	
	// Method To Withdraw Money
	public String withdrawMoney(double money) {
		if(balance < money) {
			return "INSUFFICIENT BALANCE";
		} else {
			this.balance -= money;
		}
		return "MONEY WITHDRAW SUCCESSFUL";
	}
	
	// Getter For Account Number
	public BigInteger getAccountNumber() {
		return this.accountNumber;
	}
	
	// Getter For Account Holder Name
	public String getAccountHolderName() {
		return this.accountHolderName;
	}
	
	// Getter For Balance
	public double getBalance() {
		return this.balance;
	}
	
	// Method To Verify PIN
	public boolean verifyPin() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Kindly enter your pin:"+ " ");
		int pinNumber = scn.nextInt();
		if(this.pin == pinNumber) {
			return true;
		} else {
			System.out.println("INCORRECT PIN CODE");
		}
		return false;
	}
	
	// Some Default Prints
	public void defaultPrints() {
		
		System.out.println("----------------------------------------------");
		System.out.println("To Deposit Money, Enter 1");
		System.out.println("To Withdraw Money, Enter 2");
		System.out.println("For E-Reciept, Enter 3");
		System.out.println("To Exit, Enter 4");
		System.out.println("----------------------------------------------");
		mainExecution();
	}
	
	// Code For Executing Withdrawal, Deposit, E-Receipt, Exit
	public void mainExecution() {
		Scanner scn = new Scanner(System.in);
		int value = scn.nextInt();
		if(value == 1) {
			// Verifying PIN Before Depositing Money
			if(verifyPin()) {
				System.out.print("Enter the money to be deposited:" + " ");
				double moneyToBeDeposited = scn.nextDouble();
				this.balance += moneyToBeDeposited;
				System.out.println("MONEY DEPOSITED SUCCESSFULLY");
			}
			defaultPrints();
		} else if(value == 2) {
			// Verifying PIN Before Withdrawal Of Money
			if(verifyPin()) {
				System.out.print("Enter the money to be withdrawed:" + " ");
				double moneyToBeWithDrawed = scn.nextDouble();
				String answer = withdrawMoney(moneyToBeWithDrawed);
				System.out.println(answer);
			}
			defaultPrints();
		} else if(value == 3) {
			// Verifying PIN Before Viewing E-Receipt
			if(verifyPin()) {
				getAllDetails();
			}
			defaultPrints();
		} else if(value == 4) {
			System.out.println("Exiting...");
			System.out.println("Thank you");
			System.exit(0);
		} else {
			defaultPrints();
		}
	}
	
	
	public void getAllDetails() {
		System.out.println("----------------------------------------------");
		System.out.println("Account Number: " + getAccountNumber());
		System.out.println("Account Holder Name: " + getAccountHolderName());
		System.out.println("Balance: " + getBalance());
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("WELCOME TO RAPIDSOFT BANK");
		
		System.out.print("Enter Your Full Name: ");
		String username = scn.nextLine();
		
		System.out.print("Enter the account number: ");
		BigInteger accountNumber = scn.nextBigInteger();
		
		System.out.print("Enter the Pin number: ");
		int pinNumber = scn.nextInt();
		
		System.out.print("Enter the amount you want to deposit: ");
		double depositMoney = scn.nextDouble();
		
		
		Atm newAccount = new Atm();
		newAccount.setAccountHolderName(username);
		newAccount.setAccountNumber(accountNumber);
		newAccount.setPin(pinNumber);
		newAccount.depositMoney(depositMoney);
		
		newAccount.defaultPrints();
		newAccount.mainExecution();
	}

}
