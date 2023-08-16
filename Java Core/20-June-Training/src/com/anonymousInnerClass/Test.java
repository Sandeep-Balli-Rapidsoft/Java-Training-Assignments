package com.anonymousInnerClass;

abstract class AnonymousInnerClass {
	abstract public void display();
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonymousInnerClass myClass = new AnonymousInnerClass() {
			public void display() {
				System.out.println("I am sub class, myClass");
			}
		};
		myClass.display();
	}
}
