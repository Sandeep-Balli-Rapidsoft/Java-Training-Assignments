// Using the concepts of final, static, singleton, and different access modifiers, 
// how would you implement the automatic generation and accessibility of a unique identification number for
// each engine created in the car manufacturing application?

// Note: Provide a brief explanation along with the code snippet that demonstrates your solution.
package com.singleton;

class CarNumber {
	private static CarNumber myInstance = null;
	int initialNumber = 3000;
	
	private CarNumber() {

	}

	public String generateUniqueNo(String modelName, int year) {
		String uniqueNo = modelName + "/" + year +  "/" + initialNumber;
		initialNumber++;
		return uniqueNo;
	}
	
	final static CarNumber getInstance() {
		if(myInstance == null) {
			myInstance = new CarNumber();
		}
		return myInstance;
	}
}

public class UniqueNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarNumber newCar = CarNumber.getInstance();
		System.out.println(newCar.generateUniqueNo("Nano", 2015) + " Instance - " + newCar.getInstance());
		System.out.println(newCar.generateUniqueNo("Nano", 2015) + " Instance - " + newCar.getInstance());
	}

}


// Output Generated - 
