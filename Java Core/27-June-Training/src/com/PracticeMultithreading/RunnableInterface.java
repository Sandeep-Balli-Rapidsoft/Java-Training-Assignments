package com.PracticeMultithreading;

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread is running - Runnable Interface");
	}
}

public class RunnableInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable myRunnable = new MyRunnable();
		Thread myThread = new Thread(myRunnable);
		myThread.start();
	}
}
