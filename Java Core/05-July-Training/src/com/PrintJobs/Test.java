//Question: Write a Java program to simulate a printing queue. 
// Implement a function that takes a queue of print jobs as input and prints them in the order they were added to the queue.
//Input: A queue of print jobs, where each job is represented by a string.
//Output: The print jobs printed in the order they were added.

package com.PrintJobs;
import java.util.*;
public class Test {
	
	public static void printJobs(Queue<String> jobs) {
		Iterator job = jobs.iterator();
		while(job.hasNext()) {
			System.out.println(job.next());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> jobs = new ArrayDeque<>();
		jobs.offer("Wake up");
		jobs.offer("Get Ready");
		jobs.offer("Go to Office");
		jobs.offer("Work");
		jobs.offer("Go back Home");
		jobs.offer("Good night");
		
		printJobs(jobs);
	}

}
