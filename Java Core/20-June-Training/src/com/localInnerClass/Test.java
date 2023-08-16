package com.localInnerClass;

class Outer {
	public void displayOuter() {
		String name = "Sandeep Balli";
		class Inner {
			public void displayInner() {
				System.out.println(name);
			}
		}
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
