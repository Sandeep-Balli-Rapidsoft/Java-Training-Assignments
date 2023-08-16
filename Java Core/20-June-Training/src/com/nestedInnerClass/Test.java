package com.nestedInnerClass;

class Outer {
	int x = 10;
	
	class Inner {
		int y = 20;
		public void displayInner() {
			System.out.println("Outer class variable, x = " + x);
			System.out.println("Inner class variable, y = " + y);
		}
	}
	
	public void displayOuter() {
		Inner inner = new Inner();
		inner.displayInner();
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer();
		outer.displayOuter();
		
	}

}
