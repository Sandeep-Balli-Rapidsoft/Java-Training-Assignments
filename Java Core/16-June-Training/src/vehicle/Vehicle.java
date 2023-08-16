// Create a class called "Vehicle" with a method "startEngine()". 
// Create another class called "Car" that extends "Vehicle" and, overrides the "startEngine()" method to display "Car engine started." 
// Implement a program to demonstrate upcasting and call the "startEngine()" method on both a "Vehicle" object and a "Car" object.

package vehicle;

class VehcileSuperClass {
	public void startEngine() {
		System.out.println("Parent class engine started");
	}
}

class Car extends VehcileSuperClass {
	public void startEngine() {
		System.out.println("Car Engine Started.");
	}
}

public class Vehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehcileSuperClass parent = new VehcileSuperClass();
		parent.startEngine();
		
		VehcileSuperClass child = new Car();
		child.startEngine();

	}

}
