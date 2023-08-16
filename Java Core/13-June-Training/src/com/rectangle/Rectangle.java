package com.rectangle;
import java.util.Scanner;
public class Rectangle {
	
	// Instance Variables
	int length;
	int width;
	
	// Calculating the perimeter 
	public int calculatePerimeter(int len, int wid) {
		this.length = len;
		this.width = wid;
		return 2 * (length + width);
	}
	
	// Calculating the area
	public int calculateArea(int len, int wid) {
		this.length = len;
		this.width = wid;
		return length * width;
	}
	
	// Printing the perimeter and area
	public void printPerimeterAndArea(int len, int wid) {
		System.out.println("Perimeter of the rectangle: " + calculatePerimeter(len, wid));
		System.out.println("Area of the rectangle: " + calculateArea(len, wid));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the length of the rectangle:");
		int length = scn.nextInt();
		
		System.out.println("Enter the width of the rectangle:");
		int width = scn.nextInt();
		
		Rectangle newRect = new Rectangle();
		newRect.printPerimeterAndArea(length, width);
		
	}

}
