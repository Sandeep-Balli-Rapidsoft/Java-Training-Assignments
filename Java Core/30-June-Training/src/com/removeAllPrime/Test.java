// Given a list of integers, remove all prime numbers from the list and display the modified list.

package com.removeAllPrime;
import java.util.*;
public class Test {
	
	public static boolean isPrime(int n) {
		int count = 0;
		for(int i = 1; i < n; i++) {
			if(n % i == 0) {
				count++;
			}
		}
		if(count > 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(11);
		
//		List<Integer> primeList = new ArrayList<>();
//		for(int i : list) {
//			if(isPrime(i)) {
//				primeList.add(i);
//			}
//		}
//		list.removeAll(primeList);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int num = iterator.next();
			if(isPrime(num)) {
				iterator.remove();
			}
		}
		System.out.println(list);
	}

}
