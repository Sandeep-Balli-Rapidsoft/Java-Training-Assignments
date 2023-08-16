//  Create an interface Vehicle and also create some abstract methods there. 
// Create some concrete classes those are implements the interface  and also override all the methods there. 
// Create a main class and call all the methods by Vehicle references.

package com.Interfaces;

interface Vehicle {
	public int wheels();
	public int strokes();
}

class Truck implements Vehicle {
	
	@Override
	public int wheels() {
		return 10;
	}
	
//	@Override
	public int strokes() {
		return 6;
	}
}

class Car implements Vehicle {
	
	@Override
	public int wheels() {
		return 4;
	}
	
	@Override
	public int strokes() {
		return 5;
	}
}

class Bike implements Vehicle {
	
	@Override
	public int wheels() {
		return 2;
	}
	
	@Override
	public int strokes() {
		return 4;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle truck = new Truck();
		System.out.println("A truck has " + truck.strokes() + " strokes and " + truck.wheels() + " wheels");
		
		Vehicle car = new Car();
		System.out.println("A car has " + car.strokes() + " strokes and " + car.wheels() + " wheels");
		
		Vehicle bike = new Bike();
		System.out.println("A bike has " + bike.strokes() + " strokes and " + bike.wheels() + " wheels");

	}

}
