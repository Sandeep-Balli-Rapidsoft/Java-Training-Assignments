// Given a list of strings, use lambda expressions to concatenate all the strings and return the final result.
// (provide the string value in run time using scanner class)


package com.ConcatStrings;
import java.util.Scanner;
interface ConcatStrings {
	public String concatAllStrings(String[] str);
}

class Concat {
	public static String concatAllStrings(String[] strs) {
		String str = "";
		for(int i = 0; i < strs.length; i++) {
			str = str + strs[i] + " ";
		}
		return str;
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of the string array: ");
		int size = scn.nextInt();
		String words[] = new String[size];
		System.out.println("Enter the words: ");
		for(int i = 0; i < size; i++) {
			words[i] = scn.next();
		}
		
		// LAMDA EXPRESSION
		ConcatStrings concatStrings = Concat::concatAllStrings;
		String result = concatStrings.concatAllStrings(words);
		System.out.println(result);
	}

}
