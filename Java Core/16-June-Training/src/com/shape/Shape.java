// Create a class called "Shape" with a method "calculateArea()". 
// Create two subclasses, "Rectangle" and "Circle", that inherit from the "Shape" class and override the "calculateArea()" method to calculate the area of a rectangle and circle, respectively. 
// Implement a program to demonstrate method overriding by calling the "calculateArea()" method on objects of both subclasses.

package com.shape;
import java.util.Scanner;

class ShapeSuperClass {
	public void calculateArea(double value1, double value2) {
		System.out.println("Parent class");
	}
}

class Rectangle extends ShapeSuperClass {
	@Override
	public void calculateArea(double length, double breadth) {
		System.out.println("The area of rectangle is: " + (length * breadth));
	}
}

class Circle extends ShapeSuperClass {
	@Override
	public void calculateArea(double radius, double pie) {
		System.out.println("The area of circle is: " + pie * (radius * radius));
	}
}

public class Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		ShapeSuperClass rectangle = new Rectangle();
		System.out.println("Enter the length of the rectangle: ");
		double len = scn.nextDouble();
		System.out.println("Enter the breadth of the rectangle: ");
		double breadth = scn.nextDouble();
		rectangle.calculateArea(len, breadth);
		
		ShapeSuperClass circle = new Circle();
		System.out.println("Enter the radius of the circle: ");
		double radius = scn.nextDouble();
		circle.calculateArea(radius, 3.14);
	}

}
