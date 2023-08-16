// Question: Write a Java program to simulate a call center. 
// Implement a function that takes a queue of customer calls and processes them in a fair manner, 
// where each customer is served in a round-robin fashion.
// Input: A queue of customer calls, where each call is represented by a string.
// Output: The processed customer calls in the order they were received.

package com.CallCenter;
import java.util.*;
public class Test {
	
	public static void callProcessing(PriorityQueue<String> callQueue) {
		Iterator call = callQueue.iterator();
		while(call.hasNext()) {
			System.out.println(call.next());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> calls = new PriorityQueue<>();
		calls.offer("Amazon-Sandeep");
		calls.offer("Smruti");
		calls.offer("asish");
		calls.offer("Amazon-Biswajit");
		calls.offer("Manajit");
		callProcessing(calls);
	}

}
