package com.CommonSpeedMap;
import java.util.*;
public class Test {
	
	public static void commonSpeed(HashMap<String, ArrayList<Integer>> todayMap, HashMap<String, ArrayList<Integer>> weeklyMap) {
		HashMap<String, ArrayList<Integer>> mergeMaps = new HashMap<>();
		todayMap.forEach((key, value) -> {
			mergeMaps.put(key, value);
		});
		
		weeklyMap.forEach((key, value) -> {
			mergeMaps.put(key, value);
		});
		
		HashMap<Integer, ArrayList<String>> commonSpeedMap = new HashMap<>();
		ArrayList<String> vehicleList = new ArrayList<>();
		
		mergeMaps.forEach((key, value) -> {
			String carName = key;
			for(int i : value) {
				if(i > 100) {
					
					if(!commonSpeedMap.containsKey(i)) {
						commonSpeedMap.put(i, new ArrayList<>());
					}
					commonSpeedMap.get(i).add(carName);
				}
			}
		});
		System.out.println(commonSpeedMap);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<Integer>> todayMap = new HashMap<>();
		todayMap.put("V1", new ArrayList<>(Arrays.asList(10, 120, 30, 130)));
		HashMap<String, ArrayList<Integer>> weeklyMap = new HashMap<>();
		weeklyMap.put("V2", new ArrayList<>(Arrays.asList(10, 20, 70, 130, 110)));
		weeklyMap.put("V3", new ArrayList<>(Arrays.asList(10, 120, 50, 130, 70)));
		weeklyMap.put("V4", new ArrayList<>(Arrays.asList(10, 120, 30, 80, 100)));
		weeklyMap.put("V5", new ArrayList<>(Arrays.asList(40, 120, 70, 130, 110)));
		weeklyMap.put("V6", new ArrayList<>(Arrays.asList(60, 120, 50, 110, 100)));
		
		commonSpeed(todayMap, weeklyMap);
	}

}
