// Create a class called Shape with a method calculateArea() that returns the area of the shape. 
// Then, create classes Rectangle and Circle that inherit from Shape and override the calculateArea() method.

package com.inheritance;
import java.util.*;
class ShapeSuperClass {
	public double calculateArea(String str) {
		return 0;
	}
}

class Rectangle extends ShapeSuperClass {
	public double calculateArea(String str) {
		String splittedStrings[] = str.split(" ");
		
		List<Double> list = new ArrayList<>();
		for(String subString : splittedStrings) {
			double num = Double.parseDouble(subString);
			list.add(num);
		}
		
		double length = list.get(0);
		double breadth = list.get(1);
		
		double areaOfRectangle = 2 * (length + breadth);
		return areaOfRectangle;
	}
}

class Circle extends ShapeSuperClass {
	public double calculateArea(String str) {
		double radius = Double.parseDouble(str);
		
		return Math.PI * (radius * radius);
	}
}

public class Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		ShapeSuperClass rectangle = new Rectangle();
		System.out.println("Enter the length & breadth of the rectangle: ");
		String inputForRectangle = scn.nextLine();
		System.out.println("The area of the rectangle is: " + rectangle.calculateArea(inputForRectangle));
		
		ShapeSuperClass circle = new Circle();
		System.out.println("Enter the radius circle: ");
		String inputForCircle = scn.nextLine();
		System.out.println("The area of the rectangle is: " + circle.calculateArea(inputForCircle));
	}

}
