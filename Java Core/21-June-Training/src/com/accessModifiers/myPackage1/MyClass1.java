package com.accessModifiers.myPackage1;
public class MyClass1 {
	
	public void publicMethod() {
		System.out.println("I am public method");
	}
	
	private void privateMethod() {
		System.out.println("I am a private method");
	}
	
	protected void protectedMethod() {
		System.out.println("I am a protected method");
	}
	
	void defaultMethod() {
		System.out.println("I am a default method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass1 myClass = new MyClass1();
		myClass.publicMethod();
		myClass.privateMethod();
		myClass.protectedMethod();
		myClass.defaultMethod();
	}

}
