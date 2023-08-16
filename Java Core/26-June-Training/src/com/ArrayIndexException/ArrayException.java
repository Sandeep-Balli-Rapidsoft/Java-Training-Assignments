package com.ArrayIndexException;

public class ArrayException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5,7,9};
		try {
			System.out.println(arr[14]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception Handled");
			e.printStackTrace();
		}
	}

}
