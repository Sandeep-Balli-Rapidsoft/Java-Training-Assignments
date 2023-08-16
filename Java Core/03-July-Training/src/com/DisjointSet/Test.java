// Write a Java method to check if two sets, set1 and set2, are disjoint. 
// (Two sets are disjoint if they have no elements in common.)

package com.DisjointSet;
import java.util.*;
public class Test {
	
	public static boolean areDisjoint(HashSet<Integer> set1, HashSet<Integer> set2) {
		for(int i : set1) {
			if(set2.contains(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		set1.add(10);
		set1.add(25);
		set1.add(30);
		set1.add(50);
		set2.add(15);
		set2.add(26);
		set2.add(35);
		set2.add(20);
		set2.add(21);
		set2.add(30);
		set2.add(10);
		if(areDisjoint(set1, set2)) {
			System.out.println("Two Sets Are Disjoint..");			
		} else {
			System.out.println("Two Sets Are Not Disjoint..");
		}
	}

}
