// Given a set of integers, write a Java method to find the maximum and minimum values in the set.

package com.MaximumAndMinimum;
import java.util.*;
public class Test {
	public static int findMaximum(HashSet<Integer> set) {
		int maximumValue = Integer.MIN_VALUE;
		for(int i : set) {
			maximumValue = Math.max(maximumValue, i);
		}
		return maximumValue;
	}
	
	public static int findMinimum(HashSet<Integer> set) {
		int minumumValue = Integer.MAX_VALUE;
		for(int i : set) {
			minumumValue = Math.min(minumumValue, i);
		}
		return minumumValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		set.add(23);
		set.add(21);
		set.add(22);
		set.add(24);
		set.add(99);
		set.add(9);
		System.out.println("Minimum Value = " + findMinimum(set));
		System.out.println("Maximum Value = " + findMaximum(set));
		System.out.println(set);
	}

}
