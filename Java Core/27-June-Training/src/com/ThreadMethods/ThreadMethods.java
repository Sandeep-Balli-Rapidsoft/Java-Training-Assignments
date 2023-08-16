// Create program to use the mentioned methods using java  multi-threading- 
// start(),run(),sleep(),currentThread(),getPriority(),setPriority(),isAlive(),stop(), destroy(),notify(),notifyAll() 
// add each screen shot of the output.

package com.ThreadMethods;

class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		int count = 1;
		while(count <= 10) {
			System.out.print(count + " ");
			count++;
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

public class ThreadMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread1 = new MyThread("Thread 1");
		MyThread myThread2 = new MyThread("Thread 2");
		
		try {
			myThread1.start();
//			myThread1.stop();
			
			System.out.println("ID - " + myThread1.getId());
			System.out.println("Name - " + myThread1.getName());
			myThread1.setPriority(myThread1.MAX_PRIORITY);
			System.out.println("Priority - " + myThread1.getPriority());
			System.out.println("State - " + myThread1.getState());
			System.out.println("Alive - "+ myThread1.isAlive());
			myThread1.join();
			
			System.out.println(myThread1.currentThread());
			
//			myThread2.start();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}



