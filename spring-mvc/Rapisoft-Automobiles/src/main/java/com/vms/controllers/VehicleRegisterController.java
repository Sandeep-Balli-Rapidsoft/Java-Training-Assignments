package com.vms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.Register;
import com.vms.service.VehicleRegisterService;

@RestController
@RequestMapping("/order")
public class VehicleRegisterController {
	
	@Autowired
	private VehicleRegisterService vehicleRegisterService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Register register) {
		try {
			this.vehicleRegisterService.save(register);
			String msg = "Registration Successful";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<Register> list = this.vehicleRegisterService.getAll();
		try {
			if(!list.isEmpty() && list != null) {
				return new ResponseEntity<List<Register>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{email}")
	public ResponseEntity<?> getPurchaseListByEmail(@PathVariable("email") String email) {
		List<Register> list = this.vehicleRegisterService.getPurchaseHistoryByUserEmail(email);
		try {
			if(!list.isEmpty() && list != null) {
				return new ResponseEntity<List<Register>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
