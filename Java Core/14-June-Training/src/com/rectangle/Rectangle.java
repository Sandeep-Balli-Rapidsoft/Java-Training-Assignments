package com.rectangle;
import java.util.Scanner;
public class Rectangle {
	
	// Method To Calculate The Area Of The Rectangle
	public void calculateAreaOfRectangle(int length, int width) {
		int result = length * width;
		System.out.println("The area of the rectangle is: " + result);
	}
	
	public void calculateAreaOfSqaure(int side) {
		int result = side * side;
		System.out.println("The area of the square is: " + result);
	}

	public void prints() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the length of the rectangle: ");
		int len = scn.nextInt();
		System.out.println("Enter the width of the rectangle: ");
		int wid = scn.nextInt();
		
		if(wid == 0) {
			System.out.println("As you have entered only length, we can only calculate the area for sqaure.");
			calculateAreaOfSqaure(len);
		} else {			
			calculateAreaOfRectangle(len, wid);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle();
		rect.prints();

	}

}
