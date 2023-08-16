// Create a Vehicle class as the base class with attributes like make, model, and year.
// Implement subclasses such as Car, Motorcycle, and Truck that inherit from Vehicle. 
// Override methods like calculateRentalCost() in each subclass based on specific rental rules.
// Use dynamic method dispatch to call the appropriate method based on the type of vehicle.

package com.vehicle.rental;

import java.util.Scanner;

public class Vehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.show();

//		MotorCycle bike = new MotorCycle();
//		bike.show();
//
//		Truck truck = new Truck();
//		truck.show();
	}

}

class RentVehicle {
	String make;
	String model;
	int year;

	public void calculateRentalCost(String make, int days, double amount) {
		System.out.println(
				"The " + make + " , Model No - " + model + " will cost " + amount + " rupees for " + days + " days.");
	}
}

class Car extends RentVehicle {
	void show() {
		Scanner scn = new Scanner(System.in);
		String[] cars = {"MG Hector", "Audi", "Mercedez", "Range Rover", "Jaguar"};
		Prints prints = new Prints();
		prints.defaultPrints(cars, 8000);
	}
	
}

class MotorCycle extends RentVehicle {
	void show() {
		Scanner scn = new Scanner(System.in);
		String[] motorCycles = {"TVS", "Hero", "Apache", "Royal Enfield", "Kawasaki"};
		Prints prints = new Prints();
		prints.defaultPrints(motorCycles, 8000);
	}

}

class Truck extends RentVehicle {
	void show() {
		Scanner scn = new Scanner(System.in);
		String[] trucks = {"Tata", "Ashok", "Apto", "Mercedez"};
		Prints prints = new Prints();
		prints.defaultPrints(trucks, 8000);
	}
}

class Prints {

	public Prints() {
		super();
		// TODO Auto-generated constructor stub
	}

	void defaultPrints(String vehicles[], double price) {
		Scanner scn = new Scanner(System.in);
		price = 8000;
		System.out.print("Currenly available Bikes - ");
		for (int i = 0; i < vehicles.length; i++) {
			System.out.println(vehicles[i] + " ");
		}

		String choosenVehicle = "Choosen Model Not Available";
		boolean choose = false;
		int idx = 1;
		System.out.println("Enter the model you want to rent: " + " ");
		String car = scn.nextLine();
		for (int i = 0; i < vehicles.length; i++) {
			if (car.equalsIgnoreCase(vehicles[i])) {
				choosenVehicle = vehicles[i];
				choose = true;
				idx++;
			}
		}
		if (choose) {
			System.out.println("You choose: " + choosenVehicle);
		} else {
			System.out.println("The model you entered is currently not available");
		}
		System.out.println("No. of days: ");
		int days = scn.nextInt();
		double finalPrice = price + (idx * 2000) * days;

		System.out.println("Final price: " + finalPrice);

		System.out.println("The " + choosenVehicle + " will cost " + finalPrice + " rupees for " + days + " days.");
	}
}
//	