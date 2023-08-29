package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.CustomerDAO;
import com.springmvc.entity.Customer;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerDAO customerDao;
	
	public void insertCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
	
	public List<Customer> list() {
		return customerDao.list();
	}
	
	public Customer getUserByUsername(String name) {
		return customerDao.getCustomerByUsername(name);
	}
}
