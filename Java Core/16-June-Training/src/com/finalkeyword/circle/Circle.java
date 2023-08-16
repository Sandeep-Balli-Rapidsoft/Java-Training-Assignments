// Create a class called "Circle" with a final method "calculateArea()" that calculates and returns the area of a circle. 
// Create a subclass called "Cylinder" that extends "Circle" and tries to override the "calculateArea()" method. 
// Implement a program to demonstrate the use of a final method and explain the resulting behavior.

package com.finalkeyword.circle;
import java.util.Scanner;

class CircleSuperClass {
	Scanner scn = new Scanner(System.in);
	final public void calculateArea() {
		System.out.println("Enter the radius of the circle: ");
		double radius = scn.nextDouble();
		System.out.println("Area of circle is: " + 3.14 * (radius * radius));
	}
}

class Cyclinder extends CircleSuperClass {
	
	// The below method cannot be overridden, as the method is already declared final in the
	// parent class, We cannot modify any methods that are declared once final.

	// // Area of cylinder = 2π r h + 2π r².
	
//		public void calculateArea() {
//			System.out.println("Enter the radius of the cylinder: ");
//			double radius = scn.nextDouble();
//			System.out.println("Enter the height of the cylinder: ");
//			double height = scn.nextDouble();
//			double area = 2 * 3.14 * height + (2 * 3.14 * (radius * radius));
//			System.out.println("The area of the cylinder is: " + area);
//		}
}

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
