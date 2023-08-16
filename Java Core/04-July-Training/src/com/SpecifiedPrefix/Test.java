// Given a map of words and their meanings, write a Java method to find all the words 
// that have a meaning starting with a specified prefix.

package com.SpecifiedPrefix;
import java.util.*;
public class Test {
	
	public static void prefixOfAMeaning(HashMap<String, String> stringMap, String prefix) {
		
		for(Map.Entry<String, String> string : stringMap.entrySet()) {
			if(string.getValue().startsWith(prefix)) {
				System.out.println("Word " + string.getKey() + ", Name: " + string.getValue());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> stringMap = new HashMap<>();
		String prefix = "Sa";
		stringMap.put("Student - 1", "Sandeep");
		stringMap.put("Student - 2", "Santosh");
		stringMap.put("Student - 3", "Sai");
		System.out.println("Names Starting with, Sa: ");
		prefixOfAMeaning(stringMap, "San");
	}

}
