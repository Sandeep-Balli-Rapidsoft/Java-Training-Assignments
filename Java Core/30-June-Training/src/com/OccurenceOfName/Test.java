// Given a list of names, count the number of occurrences of each name and display the result.

package com.OccurenceOfName;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Sandeep");
		list.add("Balli");
		list.add("Sandeep");
		
		HashSet<String> set = new HashSet<>();
		for(String str : list) {
			if(!set.contains(str)) {
				int frequency = Collections.frequency(list, str);
				set.add(str + " - " + Integer.toString(frequency));
			}
		}
		
		System.out.println(set);
		
//		for(int i = 0; i < list.size(); i++) {
//			int count = 0;
//			for(int j = i + 1; j < list.size(); j++) {
//				if(list.get(i) == list.get(j)) {
//					count++;
//				}
//			}
//			System.out.println(list.get(i) + count);
//		}

	}

}
