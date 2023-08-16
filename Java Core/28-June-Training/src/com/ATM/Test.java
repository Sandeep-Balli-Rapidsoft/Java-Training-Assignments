package com.ATM;

class ATM {
	synchronized public void checkBalance(String name) {
		System.out.print(name + " Checking ");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Balance");
	}
	
	synchronized public void withDrawMoney(String name, int amount) {
		System.out.print(name + " withdrawing ");
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(amount + " rupees");
	}
}

class Customer extends Thread {
	String name;
	ATM atm;
	int amount;
	
	public Customer(String name, ATM atm, int amount) {
		this.name = name;
		this.atm = atm;
		this.amount = amount;
	}
	
	public void run() {
		atm.checkBalance(name);
		atm.withDrawMoney(name, amount);
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM atm = new ATM();
		Customer cst1 = new Customer("Sandeep", atm, 2000);
		Customer cst2 = new Customer("Balli", atm, 1000);
		
		cst1.start();
		try {
			cst2.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		cst2.start();
	}

}
