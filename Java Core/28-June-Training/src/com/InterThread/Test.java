package com.InterThread;

class MyData {
	
	int value;
	boolean flag = true;
	synchronized public void setValue(int v) {
		while(flag != true) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		value = v;
		flag = false;
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	}
	
	synchronized public int getValue() {
		while(flag != false) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		flag = true;
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		notify();
		return value;
	}
}

class Producer extends Thread {
	MyData d;
	public Producer(MyData d) {
		this.d = d;
	}
	
	@Override
	public void run() {
		int count = 1;
		while(true) {
			d.setValue(count);
			System.out.println("Producer - " + count);
			count++;
		}
	}
}

class Consumer extends Thread {
	MyData d;
	public Consumer(MyData d) {
		this.d = d;
	}
	@Override
	public void run() {		
		while(true) {
			System.out.println("Consumer - " + d.getValue());
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyData myData = new MyData();
		Producer producer = new Producer(myData);
		Consumer consumer = new Consumer(myData);
		producer.start();
		consumer.start();
	}

}
