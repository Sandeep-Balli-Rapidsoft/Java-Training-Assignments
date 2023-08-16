package com.SpringCore.CI;

public class Employee {
	private String name;
	
	private String empcode;
	
	private Certificate certificate;

	public Employee(String name, String empcode, Certificate certificate) {
		this.name = name;
		this.empcode = empcode;
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empcode=" + empcode + "] .Certificate = " + this.certificate.name ;
	}
	
	 
}
