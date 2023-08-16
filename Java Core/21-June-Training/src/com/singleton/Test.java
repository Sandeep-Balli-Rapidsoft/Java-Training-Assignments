// Write a program to restrict a class to create more than one object .

package com.singleton;

class CoffeeMachine {
	private int coffeeQuantity;
	private int waterQuantity;
	
	private static CoffeeMachine checkInstance = null;
	
	private CoffeeMachine() {
		coffeeQuantity = 1;
		waterQuantity = 2;
	}
	
	static CoffeeMachine getInstance() {
		if(checkInstance == null) {
			checkInstance = new CoffeeMachine();
		}
		return checkInstance;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeeMachine cm1 = CoffeeMachine.getInstance();
		CoffeeMachine cm2 = CoffeeMachine.getInstance();
		
		System.out.println(cm1);
		System.out.println(cm2);
	}

}
