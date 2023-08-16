package com.NestedException;

public class NestedException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int arr[] = {12,3,5,7,0};
		
		try {
			System.out.println(arr[2] / 0);
			System.out.println(arr[0] / arr[14]);
		} catch(ArithmeticException e) {
			System.out.println("Handled By Arithmetic Exceptions");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Handled By Index Out Of Bounds Exceptions");
			e.printStackTrace();
		}
	}

}
