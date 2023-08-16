package com.DiaryShop;

class Notifier {
	private boolean isShopOpen = false;
	
	public synchronized void openShop() {
		isShopOpen = true;
		System.out.println("Shop Opened");
		notifyAll();
	}
	
	public synchronized void waitTillShopOpened() {
		while(!isShopOpen) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Test {
	public static void main(String [] args) {
		Notifier notifier = new Notifier();
		Thread person1 = new Thread(() -> {
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Person 1 waiting in queue");
			notifier.waitTillShopOpened();
			System.out.println("Person 1 received product");
		});
		
		Thread person2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Person 2 waiting in queue");
			notifier.waitTillShopOpened();
			System.out.println("Person 2 received product");
		});
		
		person1.start();
		person2.start();
		
		try {
			Thread.sleep(1500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		notifier.openShop();
		
	}
}
