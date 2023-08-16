// Create a StringValidator class with an instance method isPalindrome() that checks if a given string is a palindrome. .
// Use a method reference  to refer to the instance method. Check if each word in the array is a palindrome.

package com.StringValidator;

interface MyLamda {
	public void checkEachWord(String[] str);
}

class StringValidator {
	public static boolean isPallindrome(String str) {	
		int start = 0;
		int end = str.length()-1;
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end)) {
				
				return false;
			}
			start++;
			end--;
		}
		return true;
	}	
	
	public static void checkEachWord(String strs[]) {
		for(int i = 0; i < strs.length; i++) {
			if(!isPallindrome(strs[i])) {
				System.out.println(strs[i] + " is not a pallindrome.");
			} else {
				System.out.println(strs[i] + " is a pallindrome.");
			}
		}
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str[] = {"MALAYALAM", "Rapidsoft", "MALAYALAm", "MOM"};
		
		// LAMDA EXPRESSION
		MyLamda ml = StringValidator::checkEachWord;
		ml.checkEachWord(str);
	}

}
