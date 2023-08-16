package com.CoffeeMachine_Synchronization;

class CoffeeMachine {
	synchronized public void makeSomething(String name, String item) {
		System.out.println(name + " is making " + item);
		try {
			Thread.sleep(1500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " has completed making " + item + "..");
	}
}

class Employee extends Thread {
	
	CoffeeMachine coffeeMachine;
	String name;
	String item;
	public Employee(CoffeeMachine coffeeMachine, String name, String item) {
		this.name = name;
		this.item = item;
		this.coffeeMachine = coffeeMachine;
	}

	@Override
	public void run() {
		coffeeMachine.makeSomething(name, item);
	}
	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		Employee employee1 = new Employee(coffeeMachine, "Abhisek", "Coffee");
		Employee employee2 = new Employee(coffeeMachine, "Manoranjan", "Chai");
		Employee employee3 = new Employee(coffeeMachine, "Dhrutimayee", "Chai");
		Employee employee4 = new Employee(coffeeMachine, "Akankshya", "Coffee");
		Employee employee5 = new Employee(coffeeMachine, "Banoranjan", "Coffee");
		
		employee1.start();
		employee2.start();
		employee3.start();
		employee4.start();
		employee5.start();
	}

}
