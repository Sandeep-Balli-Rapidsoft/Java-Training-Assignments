package com.custom.markerInterface;

interface Area {
	public int calculateArea();
}

interface Perimeter {
	public int calculatePerimeter();
}

class Rectangle implements Area, Perimeter {
	int length = 10;
	int breadth = 5;
	
	@Override
	public int calculateArea() {
		return length * breadth;
	}
	
	@Override
	public int calculatePerimeter() {
		return 2 * (length + breadth);
		
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle = new Rectangle();
		System.out.println("Perimeter: " + rectangle.calculatePerimeter());
		System.out.println("Area: " + rectangle.calculateArea());
	}

}
