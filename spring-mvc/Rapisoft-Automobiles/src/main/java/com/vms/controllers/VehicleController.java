package com.vms.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.Vehicle;
import com.vms.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
//	@PostMapping("/create")
//	public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle vehicle) {
//		// [i.e DEMO-Yamaha-2023-1]
//		String vehicleName = vehicle.getName();
//		String brandName = vehicle.getShowRoom().getBrand().getName();
//		Date date = new Date();
//		Integer year = date.getYear();
//		String currentYear = year.toString();
//	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllVehicles() {
		List<Vehicle> list = this.vehicleService.vehicleList();
		try {
			if(!list.isEmpty() || list == null) {
				return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
			} else {
				String msg = "No Data found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch(Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
}
