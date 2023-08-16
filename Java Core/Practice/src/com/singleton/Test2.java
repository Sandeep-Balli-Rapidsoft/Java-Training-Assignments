package com.singleton;

class Employee {
	private String empID;
	private static int count = 035;
	private static Employee checkInstance = null;
	
	private static String generateId() {
		String id = "RST" + count;
		count++;
		return id;
	}
	
	Employee() {
		empID = generateId();
	}
	
	public String getEmpId() {
		return "Employee ID = "+  empID;
	}
	
	static Employee getInstance() {
		if(checkInstance == null) {
			checkInstance = new Employee();
		}
		return checkInstance;
	}
}

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		System.out.println(emp1.getEmpId() + " " + emp1.getInstance());
		System.out.println(emp2.getEmpId() + " " + emp2.getInstance());
		System.out.println(emp3.getEmpId() + " " + emp3.getInstance());
		
	}

}
