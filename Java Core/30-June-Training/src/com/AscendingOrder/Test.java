// Given a list of words, arrange them in ascending order of their lengths using a collection.

package com.AscendingOrder;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Sandeep");
		list.add("Balli");
		list.add("I ");
		Collections.sort(list, (str1, str2) -> str1.length() - str2.length());
		System.out.println(list);
	}

}
