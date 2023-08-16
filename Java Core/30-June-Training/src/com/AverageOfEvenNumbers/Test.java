// Given a list of integers, find the average of all even numbers using a collection.

package com.AverageOfEvenNumbers;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		
		int countEven = 0;
		int sum = 0;
		for(int i : list) {
			if(i % 2 == 0) {
				sum += i;
				countEven += 1;
			}
		}
		System.out.println("Average of even numbers is: " + sum / countEven);
	}

}
