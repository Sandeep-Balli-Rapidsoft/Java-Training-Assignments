package com.Test;
import com.SandeepBalli.CustomFunctions.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomFunctions myFunctions = new CustomFunctions();
		String str = "12A3";
		if(myFunctions.checkDouble(str)) {
			Double value = myFunctions.convertToDouble(str);
			System.out.println(value);
		} else {
			System.out.println("Not a valid Double value");
		}
		
	}

}
