package com.springmvc.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.Customer;

@Repository
@Transactional
public class CustomerDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveCustomer(Customer customer) {
		this.hibernateTemplate.save(customer);
	}
	
	public Customer getCustomerByUsername(String name) {
		String query = "FROM Customer WHERE name = :name";
		List<Customer> list = (List<Customer>) this.hibernateTemplate.findByNamedParam(query, "name", name);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public List<Customer> list() {
		List<Customer> list = this.hibernateTemplate.loadAll(Customer.class);
		return list;
	}
	
	
	
}
