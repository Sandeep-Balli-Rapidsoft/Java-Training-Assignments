package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.orm.entities.Employee;

@Component("employeeDao")
public class EmployeeDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(Employee employee) {
		Integer result = (Integer) this.hibernateTemplate.save(employee);
		return result;
	}
	
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = this.hibernateTemplate.loadAll(Employee.class);
		return employeeList;
	}
	
	@Transactional
	public void update(Employee employee) {
		this.hibernateTemplate.update(employee); 
	}
	
	@Transactional
	public void delete(Integer employeeId) {
		Employee employeeToBeDeleted = this.hibernateTemplate.get(Employee.class, employeeId);
		this.hibernateTemplate.delete(employeeToBeDeleted);
	}
}
