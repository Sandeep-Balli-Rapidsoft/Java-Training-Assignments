// Write a program to verify that can we inherit final method or not from an interface .

package com.inheritFinalMethodFromInterface;

interface iAmAnInterface {
	// The below line will throw an error as the methods need to be overridden and if declared final then,
	// they cannot be overridden
//	final void displayMe();
}

class Demo implements iAmAnInterface {
	public void displayMe() {
		System.out.println("I am from Demo class");
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo = new Demo();
		demo.displayMe();
	}

}
