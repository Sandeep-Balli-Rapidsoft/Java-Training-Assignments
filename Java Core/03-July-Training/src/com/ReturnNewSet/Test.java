// Write a Java method that takes two sets, set1 and set2, as parameters and returns a new set that contains 
// the elements present in set1 but not in set2.
package com.ReturnNewSet;
import java.util.*;
public class Test {
	
	public static HashSet<Integer> returnOnlyUnique(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> finalSet = new HashSet<>();
		for(int i : set1) {
			if(!set2.contains(i)) {
				finalSet.add(i);
			}
		}
		return finalSet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(6);
		
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set2.add(6);
		
		System.out.println(returnOnlyUnique(set1, set2));
		
	}

}
