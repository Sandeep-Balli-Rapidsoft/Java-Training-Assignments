// Create one Interface as name Vehicle create one abstract method as name calculateMileage(). 
// Create two classes as Honda and Suzuki which are implements the Vehicle interface. 
// Create a main class and provide all the data as already mentioned in question-1, 
// and calculate the runningMileage, engineHour mileage and actual mileage for Honda and Suzuki separetely.

package com.CalculateMileage;
import java.util.Scanner;

interface CheckMileage {
	public void calaculateMileage(double km, double ltr, double hour);
}

class Honda implements CheckMileage {

	@Override
	public void calaculateMileage(double km, double ltr, double hour) {
		// TODO Auto-generated method stub
		double runningMileage = km / ltr;
		double engineHourMileage = hour / ltr;
		double actualHourMileage = (runningMileage + engineHourMileage) / 2;
		
		System.out.println("Honda Running Mileage: " + runningMileage);
		System.out.println("Honda Engine Hour Mileage: " + engineHourMileage);
		System.out.println("Honda Actual Hour Mileage: " + actualHourMileage);
		
	}
}

class Suzuki implements CheckMileage {
	@Override
	public void calaculateMileage(double km, double ltr, double hour) {
		// TODO Auto-generated method stub
		double runningMileage = km / ltr;
		double engineHourMileage = hour / ltr;
		double actualHourMileage = (runningMileage + engineHourMileage) / 2;
		
		System.out.println("Suzuki Running Mileage: " + runningMileage);
		System.out.println("Suzuki Engine Hour Mileage: " + engineHourMileage);
		System.out.println("Suzuki Actual Hour Mileage: " + actualHourMileage);
		
	}
}


public class Mileage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Data for Honda");
		System.out.println("Enter the distance in Kilometers: ");
		double hondaKm = scn.nextDouble();
		System.out.println("Enter the petrol consumed in litres: ");
		double hondaLtr = scn.nextDouble();
		System.out.println("Enter the time taken in hours: ");
		double hondaHour = scn.nextDouble();
		CheckMileage honda = new Honda();
		honda.calaculateMileage(hondaKm, hondaLtr, hondaHour);
		
		System.out.println("");
		System.out.println("--------------------");
		System.out.println("");
		
		System.out.println("Enter Data for Suzuki");
		System.out.println("Enter the distance in Kilometers: ");
		double suzukiKm = scn.nextDouble();
		System.out.println("Enter the petrol consumed in litres: ");
		double suzukiLtr = scn.nextDouble();
		System.out.println("Enter the time taken in hours: ");
		double suzukiHour = scn.nextDouble();
		CheckMileage suzuki = new Suzuki();
		suzuki.calaculateMileage(suzukiKm, suzukiLtr, suzukiHour);
	}

}
