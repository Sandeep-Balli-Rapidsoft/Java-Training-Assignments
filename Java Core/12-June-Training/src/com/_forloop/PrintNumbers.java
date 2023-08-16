package com._forloop;
import java.util.Scanner;
public class PrintNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the nth number: " + " ");
		int n = scn.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}

	}

}
