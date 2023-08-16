// Write a Java method that takes a set of strings and returns a new set containing the
// unique characters present in all the strings of the input set.
package com.UniqueCharacters;
import java.util.*;
public class Test {
	
	public static LinkedHashSet<Character> returnUniqueCharacters(LinkedHashSet<String> stringSet) {
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		String newString = stringSet.toString();
		char chArray[] = newString.toCharArray();
		for(char ch : chArray) {
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			set.add(ch);
		}
		
		return set;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<String> str = new LinkedHashSet<>();
		str.add("I am a boy");
		System.out.println("Unique Characters - " + returnUniqueCharacters(str));
	}

}
