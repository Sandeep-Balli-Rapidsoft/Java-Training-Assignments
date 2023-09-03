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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.util.MyEnum;
import com.vms.dto.vehicle.VehicleDTO;
import com.vms.entity.Vehicle;
import com.vms.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/create")
	public ResponseEntity<?> addNewVehicle(@RequestBody VehicleDTO vehicleDto) {
		try {
			this.vehicleService.saveVehicle(vehicleDto);
			String msg = "Vehicle Created Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllVehicles() {
		List<VehicleDTO> list = this.vehicleService.vehicleList();
		try {
			if (!list.isEmpty() || list == null) {
				return new ResponseEntity<List<VehicleDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Data found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		}
	}

//	@GetMapping("/id/{id}")
//	public ResponseEntity<?> getVehicleById(@PathVariable("id") Integer id) {
//		VehicleDTO vehicle = this.vehicleService.getVehcileById(id);
//		try {
//			if (vehicle != null) {
//				System.out.println(vehicle.getShowroom().getBrand().getName());
//				System.out.println(vehicle.getIsAvailable());
//				return new ResponseEntity<VehicleDTO>(vehicle, HttpStatus.OK);
//			} else {
//				String msg = "No Vehicle found";
//				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			String msg = e.getMessage();
//			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//		}
//	}

//	@GetMapping("/vehicle-number/{vehicle-number}")
//	public ResponseEntity<?> getVehicleByVehicleNumber(@PathVariable("vehicle-number") String vehicleNumber) {
//		VehicleDTO vehicle = this.vehicleService.getVehicleByVehicleNumber(vehicleNumber);
//
//		try {
//			if (vehicle != null) {
//				return new ResponseEntity<VehicleDTO>(vehicle, HttpStatus.OK);
//			} else {
//				String msg = "No Vehicle found";
//				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			String msg = e.getMessage();
//			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//		}
//	}

	@GetMapping("/status/{status}")
	public ResponseEntity<?> getAvailableVehiclesByStatus(@PathVariable("status") Boolean status) {
		List<VehicleDTO> list = this.vehicleService.getVehicleAccordingToAvailability(status);
		try {
			if (!list.isEmpty() || list == null) {
				return new ResponseEntity<List<VehicleDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Data found";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/location")
	public ResponseEntity<?> getDataDynamically(
			@RequestParam(required = false) Integer location,
			@RequestParam(required = false) MyEnum type, 
			@RequestParam(required = false) Integer brand) {

		List<VehicleDTO> list = this.vehicleService.getVehicleDataDynamically(location, type, brand);

		return new ResponseEntity<List<VehicleDTO>>(list, HttpStatus.OK);
	}

}
