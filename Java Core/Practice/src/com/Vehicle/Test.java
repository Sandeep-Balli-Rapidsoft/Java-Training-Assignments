package com.Vehicle;
import java.util.*;
public class Test {
	
	// Using For Each to Iterate over a map
	public static void vehicleListUsingForEach(TreeMap<String, String> vehicleMap) {
		
		vehicleMap.forEach((key, value) -> {
			System.out.println(key + " " +  value);
		});
		
	}
	
	// Using KeySet() to Iterate over a map
	public static void vehicleListUsingKeySet(TreeMap<String, String> vehicleMap) {
		
		for(String key : vehicleMap.keySet()) {
			String value = vehicleMap.get(key);
			System.out.println(key + " " + value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, String> vehicleMap = new TreeMap<>();
		vehicleMap.put("V1-101", "V1");
		vehicleMap.put("V2-102", "V2");
		vehicleMap.put("V3-103", "V3");
		vehicleMap.put("V4-104", "V4");
		
		System.out.println("Using For Each: ");
		vehicleListUsingForEach(vehicleMap);
		System.out.println("-----------------------");
		
		System.out.println("Using Key Set: ");
		vehicleListUsingKeySet(vehicleMap);
		System.out.println("-----------------------");
		
	}

}
