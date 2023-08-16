// Given a list of strings, remove all elements that start with a vowel and display the modified list.

package com.Vowel;
import java.util.*;

public class Test {
	
	public static boolean isValid(String str) {
		List<Character> charList = new ArrayList<>();
		charList.add('A');
		charList.add('E');
		charList.add('I');
		charList.add('O');
		charList.add('U');
		charList.add('a');
		charList.add('e');
		charList.add('i');
		charList.add('o');
		charList.add('u');
		
		if(charList.contains(str.charAt(0))) {
			return false;
		}
	
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Anaconda");
		list.add("Bull");
		list.add("Cheetah");
		list.add("elephant");
		list.add("Igauna");
		list.add("Lion");
		list.add("Owl");
		list.add("ox");
		list.add("Uakari");
		list.add("Zebra");
		
//		list.removeIf(s -> s.startsWith("A") || s.startsWith("E") || s.startsWith("I"));
//		System.out.println(list);
		
		for(String str : list) {
			if(isValid(str)) {
				System.out.println(str);
			}
		}
		
	}

}
