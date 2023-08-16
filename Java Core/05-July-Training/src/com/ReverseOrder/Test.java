//Question: Implement a program to reverse the order of elements in a queue.
//Input: A queue of integers.
//Output: The same queue with elements reversed.

package com.ReverseOrder;
import java.util.*;
public class Test {
	
	public static ArrayList<Integer> reverseQueue(Queue<Integer> queue) {
		ArrayList<Integer> list = new ArrayList<>();
		Iterator queueItem = queue.iterator();
		while(queueItem.hasNext()) {
			list.add((Integer) queueItem.next());
		}
		Collections.reverse(list);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		queue.offer(40);
		queue.offer(50);
		System.out.println("Original Queue - " + queue);
		System.out.println("Reversed Queue - " + reverseQueue(queue));
	}

}
