// Create one abstract class Shape which contains two abstract methods area and perimeter. 
// Create two classes Circle and Triangle which are extends the Shape class and declare the method bodies there. 
// Create the main class and call the methods

package com.abstractKeywords;

abstract class ShapeSuper {
	abstract public int calculateArea();
	
	abstract public int calculatePerimeter();
}

class Circle extends ShapeSuper {
	double radius = 2;
	@Override
	public int calculatePerimeter() {
		int perimeter = (int) (2 * Math.PI * ((int) radius));
		return perimeter;
	}
	
	@Override
	public int calculateArea() {
		int area = (int) (Math.PI * ((int) radius * (int) radius));
		return area;
	}
}

class Triangle extends ShapeSuper {
	
	int side1 = 4; // Base of triangle
	int side2 = 6; // Height of triangle
	int side3 = 5;
	
	@Override
	public int calculatePerimeter() {
		int perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	@Override
	public int calculateArea() {
		int area = (side1 * side2) / 2;
		return area;
	}
}

public class Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		System.out.println("Area of Circle is: " + circle.calculateArea() + " and Perimeter of Circle is: " + circle.calculatePerimeter());
		
		Triangle triangle = new Triangle();
		System.out.println("Area of Triangle is: " + triangle.calculateArea() + " and Perimeter of Triangle is: " + triangle.calculatePerimeter());
	}

}
