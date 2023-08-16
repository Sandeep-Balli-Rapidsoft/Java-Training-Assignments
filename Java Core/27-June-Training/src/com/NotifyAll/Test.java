package com.NotifyAll;

class Notifier {
	private boolean isNotified = false;
	public synchronized void notifyAllThreads() {		
		isNotified = true;
		notifyAll();
	}
	
	public synchronized void waitForNotification() {
		
		while(!isNotified) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notifier notifier = new Notifier();
		
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread 1 waiting for notification.");
			notifier.waitForNotification();
			System.out.println("Thread 1 received notification.");
		});
		
		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2 waiting for notification.");
			notifier.waitForNotification();
			System.out.println("Thread 2 received notification");

		});
		
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized(notifier) {
			notifier.notifyAllThreads();
		}
		
	}

}
