package com.GenericCaseException;

public class GenericCase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int arr[] = {10, 3, 14, 5, 12, 20};
		try {
			System.out.println(arr[10]);
		} catch(Exception e) {
			System.out.println("Generic Case Exception Handled");
			e.printStackTrace();
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("Child Case Exception Handled");
//			e.printStackTrace();
//		}
	}

	}
}
