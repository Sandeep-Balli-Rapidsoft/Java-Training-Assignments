// Write a Java method that takes a map of city names and their corresponding populations as parameters and 
// returns the name of the city with the highest population.

package com.HighestPopulation;
import java.util.*;
public class Test {
	
	public static String cityWithHighestPopulation(HashMap<String, Integer> cities) {
		String cityName = "";
		int maxPopulation = Integer.MIN_VALUE;
		for(Map.Entry<String, Integer> city : cities.entrySet()) {
			if(city.getValue() > maxPopulation) {
				maxPopulation = city.getValue();
				cityName = city.getKey();
			}
		}
		return cityName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> cityMap= new HashMap<>();
		cityMap.put("Bengaluru", 15000000);
		cityMap.put("Mumbai", 25000000);
		cityMap.put("Hyderabad", 19000000);
		cityMap.put("Delhi", 16000000);
		System.out.println("City with highest population is: " + cityWithHighestPopulation(cityMap));
	}

}
