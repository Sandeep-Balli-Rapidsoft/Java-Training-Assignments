// Given a list of integers, remove all duplicate elements and display the modified list.
package com.DuplicateElements;
import java.util.*;
import java.util.stream.Collectors;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(5);
		
		List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
		System.out.println(newList);
	}

}
