package com.PracticeMultithreading;

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread is running..");
	}
}

public class ThreadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread = new MyThread();
		myThread.start();
	}

}
