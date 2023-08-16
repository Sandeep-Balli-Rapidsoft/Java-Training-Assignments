package com.staticInnerClass;

class Outer {
	static int x = 10;
	static int y = 20;
	
	static class Inner {
		public void display() {
			System.out.println(x);
			System.out.println(y);
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer.Inner test = new Outer.Inner();
		test.display();
		
	}

}
