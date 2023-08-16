package com.Monitor;

class MyData {
	
	synchronized void display(String str) {
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + " ");
		}
	}
}

class MyThread1 extends Thread {
	MyData d;
	
	public MyThread1(MyData d){
		this.d = d;
	}
	
	@Override
	public void run() {
		d.display("Sandeep");
	}
}

class MyThread2 extends Thread {
	MyData d;
	
	public MyThread2(MyData d){
		this.d = d;
	}
	
	@Override
	public void run() {
		d.display("Balli");
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyData myData = new MyData();
		MyThread1 myThread1 = new MyThread1(myData);
		MyThread2 myThread2 = new MyThread2(myData);
		
		myThread1.start();
		try {
			myThread2.sleep(1000);
		} catch(InterruptedException e) {
			
		}
		myThread2.start();
	}

}
