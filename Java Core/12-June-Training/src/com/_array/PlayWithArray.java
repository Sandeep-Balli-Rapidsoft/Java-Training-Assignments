package com._array;
import java.util.Scanner;
public class PlayWithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		// Taking input size of the array
		System.out.print("Enter the size of the array: " + " ");
		int size = scn.nextInt();
		int arr[] = new int[size];
		
		// Loop for taking array elements as input.
		System.out.print("Enter the array elements: " + " ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println();
		
		// Loop for printing array elements.
		System.out.print("The array elements are: " + " ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
