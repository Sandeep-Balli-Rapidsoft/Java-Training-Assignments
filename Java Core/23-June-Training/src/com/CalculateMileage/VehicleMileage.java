package com.CalculateMileage;

import java.util.Scanner;
import com.SandeepBalli.CustomFunctions.*;
public class VehicleMileage {
	
	public static void calculateMileageOfVehicle(double km, double ltr, double hour) {
		double runningMileage = km / ltr;
		double engineHourMileage = hour / ltr;
		double actualHourMileage = (runningMileage + engineHourMileage) / 2;
		
		System.out.println("Running Mileage: " + runningMileage);
		System.out.println("Engine Hour Mileage: " + engineHourMileage);
		System.out.println("Actual Hour Mileage: " + actualHourMileage);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		CustomFunctions checkDataType = new CustomFunctions();
		System.out.println("Enter the distance in Kilometers: ");
		double km = scn.nextDouble();
		System.out.println("Enter the petrol consumed in litres: ");
		double ltr = scn.nextDouble();
		System.out.println("Enter the time taken in hours: ");
		double hour = scn.nextDouble();
		
		calculateMileageOfVehicle(km, ltr, hour);
	}

}
