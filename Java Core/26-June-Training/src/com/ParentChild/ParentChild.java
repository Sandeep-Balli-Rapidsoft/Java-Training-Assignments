package com.ParentChild;

public class ParentChild {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int arr[] = {1,12,4,16,8,10};
		try {
			System.out.println(arr[2] / 10);
			try {
				System.out.println(arr[12]);
			} catch(Exception e) {
				System.out.println("Handles Generic Exception");
				e.printStackTrace();
			}
		} catch(ArithmeticException e) {
			System.out.println("Handles Child Exception");
			e.printStackTrace();
		}
	}

}
