package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Employee;

public interface EmployeeDAO {
	public int insert(Employee employee);
	
	public int update(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeById(Integer id);
	
	public int deleteEmployee(Integer id);
}
