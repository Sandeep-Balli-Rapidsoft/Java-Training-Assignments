// Create a map with name as weekmap. Basically the key contains the day of the week. 
// After that push some speed data on the day basics to the map. 
// iterate over the map and find the average speed of that vehicle.

package com.AverageSpeed;
import java.util.*;
public class Test {
	
	public static int calculateAverage(HashMap<String, ArrayList<Integer>> weekMap) {
		ArrayList<Integer> speedList = new ArrayList<>();
		for(Map.Entry<String, ArrayList<Integer>> current : weekMap.entrySet()) {
			ArrayList<Integer> currentList = current.getValue();
			for(int speed : currentList) {
				speedList.add(speed);
			}
		}
		int totalSpeed = 0;
		for(int speed : speedList) {
			totalSpeed += speed;
		}
		int average = totalSpeed / 7;
		return average;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		map.put("Monday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		map.put("Tuesday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		map.put("Wednesday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		map.put("Thursday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		map.put("Friday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		map.put("Saturday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		map.put("Sunday", new ArrayList<>(Arrays.asList(10, 20, 30)));
		
		System.out.println("Average speed: " + calculateAverage(map));
	}

}
