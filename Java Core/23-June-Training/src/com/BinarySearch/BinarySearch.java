// Implement Binary search. Provide the size of the array in run time and also provide the array elements in run time 
// and the elements are in the sorted format. 
// and also provide the search element in run time and find the index of the search element in the array.

package com.BinarySearch;
import java.util.Scanner;
public class BinarySearch {
	
	// Below method checks if the array is sorted in ascending order.
	public static boolean isSortedAscendingOrder(int arr[]) {
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	// Below method checks if the array is sorted in descending order.
	public static boolean isSortedDescendingOrder(int arr[]) {
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] < arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	// Below method checks the element in sorted ascending order array.
	public static int searchElementAscendingOrder(int arr[], int value) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == value) {
				return mid;
			} else if(arr[mid] > value) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
		
	}
	
	// Below method checks the element in sorted descending order array.

	public static int searchElementDescendingOrder(int arr[], int value) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == value) {
				return mid;
			} else if(arr[mid] < value) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the array.");
		int size = scn.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the array elements: ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		// If the array is in ascending order then, below block will be executed
		if(isSortedAscendingOrder(arr)) {	
			System.out.println("Enter the value you want to search for: ");
			int value = scn.nextInt();
			int result = searchElementAscendingOrder(arr, value);
			if(result != -1) {
				System.out.println("Value found at index, " + result);
			} else {
				System.out.println("Value not found");
			}
			
			// If the array is in descending order then, below block will be executed
		} else if(isSortedDescendingOrder(arr)) {
			System.out.println("Enter the value you want to search for: ");
			int value = scn.nextInt();
			int result = searchElementDescendingOrder(arr, value);
			if(result != -1) {
				System.out.println("Value found at index, " + result);
			} else {
				System.out.println("Value not found");
			}
			
			// If the array is unsorted then, below block will be executed
		} else {
			System.out.println("Array not sorted");
		}

	}

}
