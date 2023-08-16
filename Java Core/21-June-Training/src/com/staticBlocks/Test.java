// Write a program implementing  multiple static blocks with a use-case scenario.

package com.staticBlocks;

class Demo {

	static {
		System.out.println("Wake Up");
	}
	
	static {
		System.out.println("Get Ready");
	}
	
	static {
		System.out.println("Go To Office");
	}
}

public class Test {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo demo = new Demo();
		System.out.println("Office Work");
		System.out.println("Office Completed, Bye");
	}
	

}
