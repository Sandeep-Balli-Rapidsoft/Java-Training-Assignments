package com.shape;
import java.util.*;
public class Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeBaseClass rectangle = new Rectangle();
		rectangle.calculatePerimeter(10, 5);
		rectangle.calculateArea(10, 5);
		
		ShapeBaseClass traingle = new Triangle();
		traingle.calculateArea(10, 3);
		
		ShapeBaseClass circle = new Circle();
		circle.calculateArea(7, 3.14);
	}

}

class ShapeBaseClass {
	
	public void calculateArea(double value1, double value2) {
		System.out.println("Parent Class calculateArea");
	}
	
	public void calculatePerimeter(double value1, double value2) {
		System.out.println("Parent Class calculatePerimeter");
	}
}

class Rectangle extends ShapeBaseClass {
	
	
	public void calculatePerimeter(double length, double breadth) {
		System.out.println("Perimter of rectangle is: " + 2 * (length + breadth));
	}
	
	public void calculateArea(double length, double breadth) {
		System.out.println("Area of rectangle is: " + length * breadth);
	}
}

class Triangle extends ShapeBaseClass {
	public void calculateArea(double height, double base) {
		System.out.println("Area of Traingle is: " + (base * height) / 2);
	}
}

class Circle extends ShapeBaseClass{
	public void calculateArea(double radius, double pie) {
		System.out.println("Area of circle is: " + pie * (radius * radius));
	}
}
