package com._nested_if;
import java.util.Scanner;
public class DLF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a floor no." + " ");
		int floor_no = scn.nextInt();
		if(floor_no > 11) {
			System.out.println("There are only 11 floors in DLF.");
		} else if(floor_no == 1) {
			System.out.println("Microsoft");
		} else if(floor_no == 2) {
			System.out.println("Google");
		} else if(floor_no == 3) {
			System.out.println("Rapidsoft Technologies");
		} else if(floor_no == 4) {
			System.out.println("Meta");
		} else if(floor_no == 5) {
			System.out.println("Rubrik");
		} else if(floor_no == 6) {
			System.out.println("Jane Street");
		} else {
			System.out.println("The floor you entered is either UG / LG");
		}
	}
}
