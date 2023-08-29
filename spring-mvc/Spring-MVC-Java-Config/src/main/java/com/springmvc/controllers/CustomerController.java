package com.springmvc.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.entity.Customer;
import com.springmvc.service.CustomerService;

@RestController
@RequestMapping("/users")
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@PostMapping("/user")
	public ResponseEntity<?> insertUser(@RequestBody Customer customer) throws IOException {
		customerService.insertCustomer(customer);
		String msg = "User Created";
		System.out.println("Customer Inserted Successfully");
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> allUsers() {
		List<Customer> list = this.customerService.list();
		
		if(list.isEmpty() || list == null) {
			String msg = "No data found";
			return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getCustomerByUserName(@PathVariable("name") String username) {
		Customer customer = customerService.getUserByUsername(username);
		if(customer == null) {
			String msg = "No Customer found with username, " + username;
			return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
