// Given a list of integers, find the second smallest element using a collection.

package com.SecondSmallest;
import java.util.*;
public class Test {
	
	public static int smallestElement(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for(int i : list) {
			min = Math.min(min, i);
		}
		return min;
	}
	
	public static int secondSmallestElement(List<Integer> list) {
		int smallest = smallestElement(list);
		int secondSmallest = Integer.MAX_VALUE;
		for(int i = 0; i <  list.size(); i++) {
			if(list.get(i) < secondSmallest && list.get(i) > smallest) {
				secondSmallest = list.get(i);
			}
		}
		return secondSmallest;
	}
	
	// Using Collections.
	public static int secondSmallestElementUsingCollection(List<Integer> list) {
		Collections.sort(list);
		return list.get(1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println("Second Smallest Element is, " + secondSmallestElement(list));
		System.out.println("Second Smallest Element is using collections, " + secondSmallestElementUsingCollection(list));
	}

}
