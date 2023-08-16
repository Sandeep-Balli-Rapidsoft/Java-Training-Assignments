package com.OccurenceOfName;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("Sandeep");
		list.add("Balli");
		list.add("Sandeep");
		
		List<String> newList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(!newList.contains(list.get(i))) {
				newList.add(list.get(i));
			}
		}
		
		for(int i = 0; i < newList.size(); i++) {
			int count = 0;
			for(int j = 0; j < list.size(); j++) {
				if(newList.get(i) == list.get(j)) {
					count++;
				}
			}
			System.out.println("String - " + newList.get(i) + ", frequency - " + count);
		}
	}

}
