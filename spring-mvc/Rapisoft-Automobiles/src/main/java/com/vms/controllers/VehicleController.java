package com.vms.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/create")
	public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle vehicle) {
		try {
			this.vehicleService.saveVehicle(vehicle);
			String msg = "Vehicle Created SUccessfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllVehicles() {
		List<Vehicle> list = this.vehicleService.vehicleList();
		try {
			if (!list.isEmpty() || list == null) {
				return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
			} else {
				String msg = "No Data found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getVehicleById(@PathVariable("id") Integer id) {
		Vehicle vehicle = this.vehicleService.getVehcileById(id);
		try {
			if (vehicle != null) {
				System.out.println(vehicle.getShowroom().getBrand().getName());
				System.out.println(vehicle.getIsAvailable());
				return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
			} else {
				String msg = "No Vehicle found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/vehicle-number/{vehicle-number}")
	public ResponseEntity<?> getVehicleByVehicleNumber(@PathVariable("vehicle-number") String vehicleNumber) {
		Vehicle vehicle = this.vehicleService.getVehicleByVehicleNumber(vehicleNumber);

		try {
			if (vehicle != null) {
				return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
			} else {
				String msg = "No Vehicle found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<?> getAvailableVehiclesByStatus(@PathVariable("status") Boolean status) {
		List<Vehicle> list = this.vehicleService.getVehicleAccordingToAvailability(status);
		try {
			if (!list.isEmpty() || list == null) {
				return new ResponseEntity<List<Vehicle>>(list, HttpStatus.OK);
			} else {
				String msg = "No Data found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch(Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
