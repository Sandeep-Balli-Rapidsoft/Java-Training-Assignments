// Create two interfaces with name as Area and Perimeter. 
// In Area interface create a abstract method as area and in Perimeter interface create one abstract method as perimeter. 
// Create a class Circle which will implements Area and Perimeter both interfaces and override all the methods in circle class. 
// create a main class and call all the methods by using Circle class reference.

package com.Interfaces;
interface Area {
	int calculateArea();
}

interface Perimeter {
	int calculatePerimeter();
}

class Circle implements Area,Perimeter {
	int radius = 5;
	@Override
	public int calculatePerimeter() {
		// TODO Auto-generated method stub
		int perimeter = (int) ((int) 2 * Math.PI * (radius));
		return perimeter;
	}

	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		
		int area = (int) (Math.PI * (radius * radius));
		return area;
	}
	
}

public class AreaAndPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		System.out.println(circle.calculatePerimeter());
		System.out.println(circle.calculateArea());
	}

}
