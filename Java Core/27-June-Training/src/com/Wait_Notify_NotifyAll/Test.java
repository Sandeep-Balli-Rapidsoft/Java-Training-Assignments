package com.Wait_Notify_NotifyAll;

class Sum extends Thread {
	int sum = 0;
	@Override
	public void run() {
		synchronized(this) {
			for(int i = 1; i <= 10; i++) {
				sum += i;
			}
			this.notify();
		}
	}
}


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum myThread = new Sum();
		myThread.start();
		synchronized(myThread) {
			try {
				myThread.wait();
				System.out.println("Sum of 10 numbers is: " + myThread.sum);
								 
			} catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}

}
