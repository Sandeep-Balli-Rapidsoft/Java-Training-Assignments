// Write a single program to showcase all the access modifiers implementation.

package com.accessModifiers;

class SuperClass {
	public int a = 10;
	private int b = 20;
	protected int c = 30;
	int d = 40;
	
	void display() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}

class BaseClass extends SuperClass {
	@Override
	void display() {
		System.out.println(a);
//		System.out.println(b); // Cannot be accessible as it is declared private
		System.out.println(c);
		System.out.println(d);
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperClass superClass = new SuperClass();
		superClass.display();
		BaseClass baseClass = new BaseClass();
		baseClass.display();
	}

}
