package com.AscendingOrder;
import java.util.*;

class IntegerComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if((Integer) o1 > (Integer) o2) {
			return 1;
		} else if((Integer) o1 < (Integer) o2) {
			return -1;
		}
		return 0;
	}
}

public class Test2 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> integersQueue = new PriorityQueue<>(new IntegerComparator());
		integersQueue.offer(1);
		integersQueue.offer(10);
		integersQueue.offer(0);
		integersQueue.offer(4);
		integersQueue.offer(5);
		System.out.println(integersQueue);
	}

}
