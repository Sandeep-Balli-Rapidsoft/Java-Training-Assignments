// Create a class called "Vehicle" with a constructor that accepts a String parameter representing the vehicle's brand. 
// Create a subclass called "Car" that extends "Vehicle" and has a constructor that calls the superclass constructor using the "super" keyword. 
// Implement a program to demonstrate the use of the "super" keyword by creating a "Car" object and displaying its brand.

package com.supervehicle;

class VehicleSuperClass {
	public VehicleSuperClass(String brandName) {
		System.out.println("Parent Brand - " + brandName);
	}
}

class Car extends VehicleSuperClass {
	
	public Car(String brandName) {
		super("Tata");
		System.out.println("Child Brand - " + brandName);
	}
}

public class Vehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("Nano");
	}

}
