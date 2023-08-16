// Given two lists of integers, find the common elements between them and display the result.

package com.CommonNumbers;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(4);
		list1.add(5);
		list1.add(8);
		list1.add(6);
		list1.add(9);
		List<Integer> list2 = new ArrayList<>();
		list2.add(7);
		list2.add(6);
		list2.add(3);
		list2.add(4);
		list2.add(10);
		list2.add(2);
		
		list2.retainAll(list1);
		System.out.println(list2);
	}

}
