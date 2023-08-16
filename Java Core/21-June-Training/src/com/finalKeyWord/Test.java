// Program to show in how many ways we can initialize the Final variable and use them in a method .

package com.finalKeyWord;

class Demo {
	// Declaring variables
	
	// Initializing value directly.
	final int a = 10;
	static final int b;
	final int c;
	
	// Initializing value inside a static block.
	static {
		b = 20;
	}
	
	// Initializing value inside a constructor.
	Demo() {
		c = 30;
	}
	
	public void display() {
		System.out.println("Value initialized directly as an instance variable: " + a);
		System.out.println("Value initialized with in a static block: " + b);
		System.out.println("Value initialized inside a constructor: " + c);
	}
	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo = new Demo();
		demo.display();
	}

}
