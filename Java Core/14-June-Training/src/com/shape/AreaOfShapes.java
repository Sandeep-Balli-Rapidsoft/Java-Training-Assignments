package com.shape;
import java.util.Scanner;
class Shape {
	
	public double calculateArea(double x, double y) {
		return x * y;
	}
	
	public double calculateArea(double radius) {
		System.out.println("Base Class");
		return 3.14 * radius * radius;
	}
}

class Rectangle extends Shape {
	public double calculateArea(double length, double width) {
		return length * width;
	}
}

class Traingle extends Shape {
	public double calculateArea(double base, double height) {
		return (base * height) / 2;
	}
}

class Circle extends Shape {
	public double calclateArea(double radius) {
		return 3.14 * radius * radius;
	}
}

public class AreaOfShapes {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		Shape rectangle = new Rectangle();
		System.out.println("Enter the length of the rectangle: ");
		double length = scn.nextInt();
		System.out.println("Enter the width of the rectangle: ");
		double width = scn.nextInt();
		System.out.println("The area of triangle is: " + rectangle.calculateArea(length, width));
		
		Shape triangle = new Traingle();
		System.out.println("Enter the base of the triangle: ");
		double base = scn.nextInt();
		System.out.println("Enter the height of the triangle: ");
		double height = scn.nextInt();
		System.out.println("The area of triangle is: " + triangle.calculateArea(base, height));
		
		Shape circle = new Circle();
		System.out.println("Enter the radius of the circle: ");
		double radius = scn.nextInt();
		
		System.out.println("The area of circle is: " + circle.calculateArea(radius));

	}

}
