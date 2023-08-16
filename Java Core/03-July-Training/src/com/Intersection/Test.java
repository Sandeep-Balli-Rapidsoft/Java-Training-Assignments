
// Given two sets of integers, write a Java method to find the intersection of the two sets,
// (i.e., the elements present in both sets).

package com.Intersection;
import java.util.*;
public class Test {
	
	public static HashSet<Integer> findInterSection(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> newSet = new HashSet<>();
		for(int i : set1) {
			if(set2.contains(i)) {
				newSet.add(i);
			}
		}
		return newSet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		System.out.println("Intersection = " + findInterSection(set1, set2));
	}

}
