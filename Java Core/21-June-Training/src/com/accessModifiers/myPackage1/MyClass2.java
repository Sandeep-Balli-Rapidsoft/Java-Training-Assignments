package com.accessModifiers.myPackage1;

public class MyClass2 {
	
	public static void main(String [] args) {
		MyClass1 myClass = new MyClass1();
		myClass.publicMethod();
		myClass.protectedMethod();
		myClass.defaultMethod();
	}
}
