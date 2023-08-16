package com.singleton.EngineCode;

import java.util.Scanner;

public class EngineCode {
	static Scanner scn = new Scanner(System.in);

	private static EngineCode myInstance = null;
	int initialNumber = 3000;
	
	private EngineCode() {

	}

	final String generateUniqueNo(String modelName, String year) {
		String uniqueNo = modelName + "/" + year +  "/" + initialNumber;
		initialNumber++;
		return uniqueNo;
	}
	
	static EngineCode getInstance() {
		if(myInstance == null) {
			myInstance = new EngineCode();
		}
		return myInstance;
	}
	
//	 Trying to check if input is an integer
	public static boolean checkInteger(String value) {
		try {
			Integer intValue = Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static void defaultPrints() {
		System.out.println("Enter 1, To Generate A New Identification Number For Car Engine");
		System.out.println("Enter 2, To Exit");
		String optionEntered = scn.nextLine();
		checkInvalidInput(optionEntered, 1,  2);
	}
	
	public static void checkInvalidInput(String optionEntered, int minValue, int maxValue) {
		if(!checkInteger(optionEntered)) {
			System.out.println("Enter a valid integer");
			defaultPrints();
		} else {
			Integer intValue = Integer.parseInt(optionEntered);
			while(intValue < minValue || intValue > maxValue) {
				System.out.println("You can only enter, " + minValue + " " + maxValue);
				defaultPrints();
			}
			if(intValue == 1) {
				prints();
			} else if(intValue == 2) {
				System.out.println("Exiting..");
				System.exit(0);
			} else {
				System.exit(0);
			}

		}
		
	}
	
	public static void prints() {
		
		System.out.println("Enter the model name: ");
		String carModelName = scn.next();
		System.out.println("Enter the manufacturing year: ");
		String manufacturingYear = scn.next();
		while(!checkInteger(manufacturingYear)) {
			System.out.println();
			System.out.println("Enter a valid year.");
			prints();
		}
		EngineCode newEngine = EngineCode.getInstance();
		System.out.println("Unique Code - " + newEngine.generateUniqueNo(carModelName, manufacturingYear) + " Instance " + newEngine.getInstance());
		System.out.println("-------------");
		defaultPrints();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		defaultPrints();
	}
}

// Output Generated

//Enter 1, To Generate A New Identification Number For Car Engine
//Enter 2, To Exit
//1
//Enter the model name: 
//Audi-V1
//Enter the manufacturing year: 
//2023
//Unique Code - Audi-V1/2023/3000 Instance com.generateUniqueCode.EngineCode@23ceabc1

// FLOW OF THE CODE


//-> In line no. 8, I have declared and initialized myInstance as null,
//	because to make sure the instance is created only once when it is invoked for the first time.

//-> In line no. 9, I have set a initialNumber to 3000(random number), so that it will be incremented from here only.

//-> In line no.11, I have set the Constructor(EngineCode) to private
//	to prevent direct instantiation from the main function or outside the class.

//-> In line no.15, I have declared a final method generateUniqueMethod() that will return us an unique string
// 	after the concatenation of the parameters that are modelName and year with intialNumber. 
//	The initialVariable will be incremented in this method. 
//	I have declared this method final because, this method should not be overridden by any other subclasses
//	and the functionality of this method should remain same across all instances.

//-> In line no.21, I have created the getInstance() method that will return a new Instance of the Object
//	if it is null else it will return the existing one. 
//	This method makes sure that the singleton pattern is followed as we are only creating the object only once.


