// Given a list of strings, find the longest word using a collection.
package com.LongestWord;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Uber");
		list.add("Citadel");
		list.add("Rapidsoft");
		list.add("Netflix");
		
		String longestString = Collections.max(list, (a,b) -> a.length() - b.length());
		System.out.println(longestString);
	}

}
