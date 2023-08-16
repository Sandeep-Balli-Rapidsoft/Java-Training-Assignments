package com.WrapperClasses.AutoBoxingAndUnBoxing;

public class Test {
	
	public static void autoBoxing() {
		System.out.println("AutoBoxing");
		int intValue1 = 10;
		Integer intValue2 = Integer.valueOf(intValue1);
		Integer intValue3 = intValue1;
		System.out.println("Integer: " + intValue2);
		System.out.println("Integer: " + intValue3);
		
		System.out.println();
		
		float floatValue1 = 10.65f;
		Float floatValue2 = Float.valueOf(floatValue1);
		Float floatValue3 = floatValue1;
		System.out.println("Float: " + floatValue2);
		System.out.println("Float: " + floatValue3);
		
		System.out.println();
		
		char charValue1 = 'A';
		Character charValue2 = Character.valueOf(charValue1);
		Character charValue3 = charValue1;
		System.out.println("Character: " + charValue2);
		System.out.println("Character: " + charValue3);
		System.out.println();
	}
	
	public static void unBoxing() {
		System.out.println("Unboxing.");
		Integer intValue1 = new Integer(10);
		Integer intValue2 = intValue1.intValue();
		Integer intValue3 = intValue1;
		System.out.println("Integer: " + intValue1);
		System.out.println("Integer: " + intValue2);
		System.out.println("Integer" + intValue3);
		
		System.out.println();
		
		Float floatValue1 = new Float(10.50);
		Float floatValue2 = floatValue1.floatValue();
		Float floatValue3 = floatValue1;
		System.out.println("Float: " + floatValue1);
		System.out.println("Float: "  + floatValue2);
		System.out.println("Float: " + floatValue3);
		
		System.out.println();
		
		Character charValue1 = new Character('A');
		Character charValue2 = charValue1.charValue();
		Character charValue3 = charValue1;
		System.out.println("Character: " + charValue1);
		System.out.println("Character: " + charValue2);
		System.out.println("Character: " + charValue3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// AutoBoxing
		autoBoxing();
		System.out.println("-------------");
		unBoxing();
	}

}

