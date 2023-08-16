package com.MonitorExample;

class Welcome {
	synchronized void displayMessage(String text) {
		for(int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i) + " ");
		}
	}
}

class MyThread1 extends Thread {
	Welcome welcome;
	String name;
	public MyThread1(Welcome welcome, String name) {
		this.welcome = welcome;
		this.name = name;
	}
	
	@Override
	public void run() {
		welcome.displayMessage("Good Morning," + name);
	}
}

class MyThread2 extends Thread {
	Welcome welcome;
	public MyThread2(Welcome welcome) {
		this.welcome = welcome;
	}
	
	@Override
	public void run() {
		System.out.println();
		System.out.println();
		welcome.displayMessage("Welcome To Rapidsoft Technologies");
	}
}


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Welcome welcome = new Welcome();
		MyThread1 myThread1 = new MyThread1(welcome, "Sandeep");
		MyThread2 myThread2 = new MyThread2(welcome);
		
		myThread1.start();
		try {
			myThread2.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		myThread2.start();
	}

}
