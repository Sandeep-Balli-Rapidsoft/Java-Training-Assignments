package com.array.maximumElement;
import java.util.*;
public class ArrayOperations {
	
	// Method To Find Maximum Element In Integer Array
	public int maximumElement(int arr[]) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
	// Method To Find Maximum Element In Double Array
	public double maximumElement(double arr[]) {
		double max = arr[0];
		for(double i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[(int) i]);
		}
		return max;
	}
	
	// Method To Find String That Is Lexicographically Maximum	
	public String maxString(String[] strings) {
		String str = strings[0];
		for(int i = 0; i < strings.length; i++) {
			if(str.compareTo(strings[i]) <= 0) {
				str = strings[i];
			}
		}
		return str;
	}
	
	// For Integer array
	public void printsForIntegerArray() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the integer array: ");
		int size = scn.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the elements of the array: ");
		for(int i = 0; i < size; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println("The maximum element in the integer array is: "+ maximumElement(arr));
		
	}
	
	// For Double array
	public void printsForDoubleArray() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the double array: ");
		int size = scn.nextInt();
		double arr[] = new double[size];
		System.out.println("Enter the elements of the array: ");
		for(double i = 0; i < size; i++) {
			arr[(int) i] = scn.nextDouble();
		}
		System.out.println("The maximum element in the double array is: "+ maximumElement(arr));
		
	}
	
	// For String Array
	public void printsStringArray() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the string array: ");
		int size = scn.nextInt();
		String strings[] = new String[size];
		System.out.println("Enter the elements of the array: ");
		for(int i = 0; i < size; i++) {
			strings[i] = scn.next();
		}
		System.out.println("The string with maximum length in the array is: " + maxString(strings));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayOperations ops = new ArrayOperations();
//		ops.printsForIntegerArray();
//		System.out.println();
//		ops.printsForDoubleArray();
		System.out.println();
		ops.printsStringArray();

	}

}
