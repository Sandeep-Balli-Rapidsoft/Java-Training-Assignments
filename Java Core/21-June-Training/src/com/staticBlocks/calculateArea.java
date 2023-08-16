package com.staticBlocks;

class MyClass {
	static double pie;
	
	static {
		pie = 3.14;
	}
}

public class calculateArea {
	
	public static double calculateAreaOfCircle(int radius, double pie) {
		return pie * (radius * radius);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double result  = calculateAreaOfCircle(5, MyClass.pie);
		System.out.println(result);
	}

}
