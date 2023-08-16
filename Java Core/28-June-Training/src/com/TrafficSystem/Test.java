package com.TrafficSystem;

class TrafficPoint {
	String signal = "RED";
	 synchronized public void changeSignal() {
		 System.out.println("Signal is, " + signal);
		 try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		this.signal = "GREEN";
		System.out.println("Signal is, " + signal);
		moveCar();
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		this.signal = "RED";
		notifyAll();
		changeSignal();
	}
	
	public void moveCar() {
		int i = 1;
		while(signal.equals("GREEN")) {
			System.out.println("Car - " + i + " has crossed traffic line");
			i++;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
	}
	
	synchronized public void waitForSignal() {
		changeSignal();
//		while(!signal.equals("GREEN")) {
//			try {
//				wait();
//			} catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}

class Car extends Thread {
	TrafficPoint trafficPoint;
	
	public Car(TrafficPoint trafficPoint) {
		this.trafficPoint = trafficPoint;
	}
	
	synchronized public void run() {
		while(true) {
			trafficPoint.waitForSignal();
		}
	}
}

public class Test {
	
	public static void main(String args[]) {
		TrafficPoint trafficPoint = new TrafficPoint();
		Car car1 = new Car(trafficPoint);
		car1.start();
	}
}
