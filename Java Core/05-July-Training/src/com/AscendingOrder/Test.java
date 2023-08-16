//Question: Implement a program to sort a queue of integers in ascending order without using any
//additional data structures.
//Input: A queue of integers.
//Output: The same queue with integers sorted in ascending order.

package com.AscendingOrder;
import java.util.*;

public class Test {
	
	public static void sortQueue(PriorityQueue<Integer> integers) {
		Iterator<Integer> integer = integers.iterator();
		while(integer.hasNext()) {
			int currValue = integers.poll();
			System.out.println(currValue);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> integers = new PriorityQueue<>();
		integers.offer(5);
		integers.offer(6);
		integers.offer(2);
		integers.offer(4);
		integers.offer(3);
		integers.offer(1);
		sortQueue(integers);
	}
}
