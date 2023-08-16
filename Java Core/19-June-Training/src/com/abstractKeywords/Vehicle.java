// Create abstract class super which have some abstract methods. 
// Then create some concrete classes those are extends the super class and override all the abstract methods . 
// Create the main class and call all the abstract methods by using interface reference.

package com.abstractKeywords;

abstract class Super {
	abstract public void start();
	abstract public void stop();
}

class Honda extends Super {
	@Override
	public void start() {
		System.out.println("Honda Started");
	}
	
	@Override
	public void stop() {
		System.out.println("Honda Stopped");
	}
}

class Nexa extends Super {
	
	@Override
	public void start() {
		System.out.println("Nexa Started");
	}
	
	@Override
	public void stop() {
		System.out.println("Nexa Stopped");
	}
}

class Mahindra extends Super {
	@Override
	public void start() {
		System.out.println("Mahindra Started");
	}
	
	@Override
	public void stop() {
		System.out.println("Mahindra Stopped");
	}
}

public class Vehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Honda honda = new Honda();
		honda.start();
		honda.stop();
		
		Nexa nexa = new Nexa();
		nexa.start();
		nexa .stop();
		
		Mahindra mahindra = new Mahindra();
		mahindra.start();
		mahindra.stop();
	}

}
