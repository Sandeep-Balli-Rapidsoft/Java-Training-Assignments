package com.StringConcept;

public class Test {
	
	public static void playWithString() {
		String firstName = "Rapidsoft";
		String lastName = " Technologies";
		
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		
		String fullName = firstName.concat(lastName);
		fullName = fullName.toUpperCase();
		System.out.println("Concatenation of Firstname & Lastname is: " + fullName);

		System.out.println("Length of the String, " + fullName + " is: " + fullName.length());
		
		System.out.println("SubString of " + fullName + " is: " + fullName.substring(5, 10));
		
		System.out.println("Index of Character, D is: " + fullName.indexOf('D'));
		
		String str1 = "hello";
		String str2 = "hello";
		
		System.out.println("Are str1 and str2 same? " + str1.equals(str2));
		System.out.println("-----------------");
	}
	
	public static void playWithStringBuilder() {
		StringBuilder sb = new StringBuilder("Hello,");
		System.out.println("String: " + sb);
		sb.append(" Yay");
		System.out.println("Appended String: "  +sb);
		System.out.println("Replacing String Yay with Good Morning: " + sb.replace(6, sb.length(), " Good Morning"));
		System.out.println("After Removing a Character in the String: " + sb.deleteCharAt(sb.length()-1));
		System.out.println("-----------------");
		
	}
	
	public static void playWithStringBuffer() {
		StringBuffer sb = new StringBuffer("Rapidsoft Technologies");
		System.out.println("Original String: " + sb);
		System.out.println("Reversing the String: " + sb.reverse());
		
		StringBuffer str1 = new StringBuffer("Hello");
		StringBuffer str2 = new StringBuffer("Hello");
		System.out.println("Are str1 and str2 same? " + str1.equals(str2));
		
		if(str1 == str2) {
			System.out.println("Both are equal");
		} else {
			System.out.println("Both are not equal");
		}
		
		sb.reverse();
		String str = sb.toString();
		System.out.println("Converting StringBuffer to String: " + str);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playWithString();
		playWithStringBuilder();
		playWithStringBuffer();
	}

}
