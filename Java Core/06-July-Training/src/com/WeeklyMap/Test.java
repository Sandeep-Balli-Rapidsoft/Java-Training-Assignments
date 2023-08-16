// Create two map with name as todayMap<string,arrayList> and weeklyMap<string, arrayList>. 
// Basically the key contains the vehicle number and the arrayList contains the speed with respective vehicles. 
//i) find the vehicle number and speed where the speed is greater than the provided speed (through scanner class)
// 	 and print it.
//ii) find the common speed of the vehicles in both the maps and print the speed with vehicle number.


package com.WeeklyMap;
import java.util.*;
public class Test {
	
	public static void vehicleSpeed(HashMap<String, ArrayList<Integer>> todayMap, HashMap<String, ArrayList<Integer>> weeklyMap, int speed) {
		HashMap<String, ArrayList<Integer>> finalMap = new HashMap<>();
		
		// Method to find the vehicles that exceeded the speed limit
		for(Map.Entry<String, ArrayList<Integer>> vehicle1 : todayMap.entrySet()) {
			String vehicleName = vehicle1.getKey();
			ArrayList<Integer> list = vehicle1.getValue();
			ArrayList<Integer> speedExceededList = new ArrayList<>();
			for(int i : list) {
				if(i > speed) {
					speedExceededList.add(i);
				}
			}
			finalMap.put(vehicleName, speedExceededList);
		}
		
		for(Map.Entry<String, ArrayList<Integer>> vehicle2 : weeklyMap.entrySet()) {
			String vehicleName = vehicle2.getKey();
			ArrayList<Integer> list = vehicle2.getValue();
			ArrayList<Integer> speedExceededList = new ArrayList<>();
			for(int i : list) {
				if(i > speed) {
					speedExceededList.add(i);
				}
			}
			finalMap.put(vehicleName, speedExceededList);
		}
		System.out.println(finalMap);
	}
	
	// Method for finding common speed in both the Maps
	public static void commonSpeed(HashMap<String, ArrayList<Integer>> todayMap, HashMap<String, ArrayList<Integer>> weeklyMap) {
		TreeMap<Integer, ArrayList<String>> commonSpeedList = new TreeMap<>(Collections.reverseOrder());
		ArrayList<String> vehicleList = new ArrayList<>();
		
		// Iterating Today Map
		for(Map.Entry<String, ArrayList<Integer>> map1 : todayMap.entrySet()) {
			String carName = map1.getKey();
			
			ArrayList<Integer> list = map1.getValue();
			for(int i : list) {
				if(i > 100) {					
					if(!commonSpeedList.containsKey(i)) {
						
						commonSpeedList.put(i, new ArrayList<>());
					}
					// Adding the car name to the value(ArrayList) of the commonSpeedList
					commonSpeedList.get(i).add(carName);
				}

			}
		}

		// Iterating Weekly Map, With Multiple Vehicles
		for(Map.Entry<String, ArrayList<Integer>> map2 : weeklyMap.entrySet()) {
			String carName = map2.getKey();
			
			ArrayList<Integer> list = map2.getValue();
			
			for(int i : list) {
				
				if(i > 100) {
					
					if(!commonSpeedList.containsKey(i)) {	
						commonSpeedList.put(i, new ArrayList<>());
					}
					commonSpeedList.get(i).add(carName);
				}

				
			}
		}

		for(Map.Entry<Integer, ArrayList<String>> map : commonSpeedList.entrySet()) {
			System.out.println("Speed: " + map.getKey() + " -- Vehicle No.: " + map.getValue());
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		HashMap<String, ArrayList<Integer>> todayMap = new HashMap<>();
		todayMap.put("V1", new ArrayList<>(Arrays.asList(10, 120, 30, 130)));
		HashMap<String, ArrayList<Integer>> weeklyMap = new HashMap<>();
		weeklyMap.put("V2", new ArrayList<>(Arrays.asList(10, 20, 70, 130, 110)));
		weeklyMap.put("V3", new ArrayList<>(Arrays.asList(10, 120, 50, 130, 70)));
		weeklyMap.put("V4", new ArrayList<>(Arrays.asList(10, 120, 30, 80, 100)));
		weeklyMap.put("V5", new ArrayList<>(Arrays.asList(40, 120, 70, 130, 110)));
		weeklyMap.put("V6", new ArrayList<>(Arrays.asList(60, 120, 50, 110, 100)));
		
		System.out.println("Enter the speed limit: ");
		int speed = scn.nextInt();
		vehicleSpeed(todayMap, weeklyMap, speed);
		
		
		System.out.println("---------------------------");
		System.out.println("Speed Report--");
		commonSpeed(todayMap, weeklyMap);
		
	}

}
