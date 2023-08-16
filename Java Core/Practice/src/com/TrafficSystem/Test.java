package com.TrafficSystem;

class Signal extends Thread {
	String signal = "RED";
	int count = 1;
	synchronized public void callRed() {
		System.out.println("Signal is " + signal);
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void callGreen() {
		signal = "GREEN";
		System.out.println("Signal is " + signal);
	}
	
	public void run() {
		
		while(signal == "GREEN") {
			System.out.println("Car " + count + " is moving");
			count++;
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		callRed();
		callGreen();
		run();
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Signal signal = new Signal();
		signal.start();
	}

}
