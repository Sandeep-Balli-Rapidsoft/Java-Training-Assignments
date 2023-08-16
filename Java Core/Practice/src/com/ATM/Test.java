package com.ATM;

class ATM {
	synchronized public void checkBalance(String name) {
		System.out.print(name + " Checking ");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Balance");
	}
	
	synchronized public void withdrawAmount(String name, int amount) {
		System.out.print(name + " withdrawing ");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(amount);
	}
}

class Customer extends Thread {
	ATM atm;
	String name;
	int amount;
	
	Customer(String name, ATM atm, int amount) {
		this.name = name;
		this.atm = atm;
		this.amount = amount;
	}
	
	public void useAtm() {
		atm.checkBalance(name);
		atm.withdrawAmount(name, amount);
	}
	
	@Override
	public void run() {
		useAtm();
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM atm = new ATM();
		Customer cst1 = new Customer("Sandeep", atm, 1000);
		Customer cst2 = new Customer("Balli", atm, 2000);
		
		cst1.start();
		cst2.start();
	}

}
