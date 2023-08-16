// Write a Java program to create and start two threads. Each thread should print numbers from 1 to 10. 
// Ensure that the numbers are printed in sequence.

package com.PrintNumbers;

class MyThread extends Thread {

	
	@Override
	public void run() {
		int count = 1;
		while(count <= 10) {
			System.out.print(count + " ");
			count++;
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

public class PrintNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread1 = new MyThread();
		MyThread myThread2 = new MyThread();
		try {
//			For output -> 1 2 3 4 5 6 7 8 9 10 1 2 3 4 5 6 7 8 9 10
//			myThread1.start();
//			myThread1.join();
//			myThread2.start();
			
// 			For output -> 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10 		
			myThread1.start();
			myThread2.start();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
