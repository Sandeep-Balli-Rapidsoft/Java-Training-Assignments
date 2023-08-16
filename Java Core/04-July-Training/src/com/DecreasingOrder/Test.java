// Write a Java method that takes a list of words calculates their frequencies
// and stores them into a map frequence as key and words as value and sorts the map by descending order.


// SABSE KHATARNAK QUESTION...

package com.DecreasingOrder;
import java.util.*;
import java.util.Map.Entry;
public class Test {
	
	public static void decreasingOrderOfMap(ArrayList<String> list) {
		
		LinkedHashMap<String, Integer> wordMap = convertListToHashMap(list);
		
		LinkedHashMap<String, Integer> finalMap = new LinkedHashMap<>();
		
		ArrayList<Integer> valueList = new ArrayList<>();
		for(Map.Entry<String, Integer> value : wordMap.entrySet()) {
			valueList.add(value.getValue());
		}
		
		Collections.sort(valueList, Collections.reverseOrder());
		System.out.println(wordMap);
		System.out.println(valueList);
		
		for(int idx : valueList) {
			System.out.println(returnEntry(wordMap, idx));
		}
		
	}
	
	public static Entry<String, Integer> returnEntry(LinkedHashMap<String, Integer> map, int value) {
		
		LinkedHashMap<String, Integer> finalMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> idx : map.entrySet()) {
			if(value == idx.getValue()) {
				return idx;
			}
		}
		return null;
	}
	
	public static LinkedHashMap convertListToHashMap(ArrayList<String> list) {
		LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
		for(String str : list) {
			if(wordMap.containsKey(str)) {
				wordMap.put(str, wordMap.get(str) + 1);
			} else {				
				wordMap.put(str, 1);
			}
		}
		return wordMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("orange");
		list.add("grapes");
		list.add("apple");
		list.add("grapes");
		list.add("grapes");
		decreasingOrderOfMap(list);
	}

}
