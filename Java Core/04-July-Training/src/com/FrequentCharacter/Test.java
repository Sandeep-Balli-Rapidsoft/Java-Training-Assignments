//  Given a map of characters and their corresponding frequencies in a string. 
// Write a Java method to find the character(s) that occur(s) the most number of times.


package com.FrequentCharacter;
import java.util.*;
public class Test {
	
	public static void mostFrequentCharacter(HashMap<Character, String> charMap) {
		Character ch = null;
		int max = Integer.MIN_VALUE;
		for(Map.Entry<Character, String> chMap : charMap.entrySet()) {
			Integer freq = Integer.parseInt(chMap.getValue());
			if(freq > max) {
				max = freq;
				ch = chMap.getKey();
			}
		}
		System.out.println(ch);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, String> charMap = new HashMap<>();
		charMap.put('A', "2");
		charMap.put('a', "12");
		charMap.put('B', "7");
		charMap.put('z', "21");
		charMap.put('S', "18");
		charMap.put('N', "15");
		
		System.out.print("Most Frequent Character: ");
		mostFrequentCharacter(charMap);
	}

}
