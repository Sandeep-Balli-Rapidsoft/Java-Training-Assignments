//Question: Implement a program to find the largest element in a queue of integers without removing any elements from the queue.
//Input: A queue of integers.
//Output: The largest element in the queue.

package com.LargestElement;
import java.util.*;
public class Test {
	
	public static int findLargestElement(Queue<Integer> queue) {
		int largestElement = Integer.MIN_VALUE;
		Iterator element = queue.iterator();
		while(element.hasNext()) {
			if((Integer) element.next() > largestElement) {
				largestElement = (Integer) element.next();
			}
		}
		return largestElement;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(5);
		queue.offer(3);
		queue.offer(4);
		queue.offer(6);
		queue.offer(1);
		
		System.out.println("Largest Element: " + findLargestElement(queue));
	}

}
