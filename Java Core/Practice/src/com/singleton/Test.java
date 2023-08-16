package com.singleton;
import java.util.Calendar;
class Student {
	private String rollNo;
	private static int count = 1;
	private static Student myInstance = null;
	
	private String generateRollNo() {
		Calendar calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		String rn = "RST" + year + count;
		count++;
		return rn;
		
	}
	Student() {
		rollNo = generateRollNo();
	}
	
	public String getRollNo() {
		return rollNo;
	}
	
//	static Student getInstance() {
//		if(myInstance == null) {
//			myInstance = new Student();
//		}
//		return myInstance;
//	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student std1 = new Student();
		System.out.println(std1.getRollNo());
	}

}
