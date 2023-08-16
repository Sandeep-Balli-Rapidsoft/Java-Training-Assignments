// Given two lists of integers, merge them into a single list in sorted order using a collection.

package com.MergeLists;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list1.addAll(list2);
		Collections.sort(list1);
		System.out.println(list1);
	}

}
