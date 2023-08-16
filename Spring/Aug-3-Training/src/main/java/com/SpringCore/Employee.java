package com.SpringCore;

public class Employee {

	private Integer id;
	
	private String name;
	
	private String empcode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public Employee(Integer id, String name, String empcode) {
		super();
		this.id = id;
		this.name = name;
		this.empcode = empcode;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", empcode=" + empcode + "]";
	}
	
	
	
}
