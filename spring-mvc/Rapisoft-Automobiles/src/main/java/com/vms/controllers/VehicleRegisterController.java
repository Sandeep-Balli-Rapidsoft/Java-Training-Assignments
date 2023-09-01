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

import com.vms.dto.register.RegisterDTO;
import com.vms.dto.user.UserDTO;
import com.vms.dto.vehicle.VehicleDTO;
import com.vms.entity.Register;
import com.vms.service.UserService;
import com.vms.service.VehicleRegisterService;
import com.vms.service.VehicleService;

@RestController
@RequestMapping("/order")
public class VehicleRegisterController {

	@Autowired
	private VehicleRegisterService vehicleRegisterService;

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RegisterDTO registerDto) {
		try {
			
			VehicleDTO vehDto = this.vehicleService.getVehcileById(registerDto.getVehicle().getId());
			UserDTO userDto = this.userService.getUser(registerDto.getUser().getId());
			
//			try {
//				if(userDto == null) {
//					String msg = "User Not Found. Please Register the user first";
//					return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
//				}
//			} catch(NullPointerException e) {
//				String msg = "User Not Found. Please Register the user first";
//				return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
//			}
			
			
			if (!vehDto.getIsAvailable()) {
				String msg = "Vehicle Not Available. Already Booked";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}
			
			

			this.vehicleRegisterService.save(registerDto);
			String msg = "Registration Successful";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<RegisterDTO> list = this.vehicleRegisterService.getAll();
		try {
			if (!list.isEmpty() && list != null) {
				return new ResponseEntity<List<RegisterDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get/{email}")
	public ResponseEntity<?> getPurchaseListByEmail(@PathVariable("email") String email) {
		List<RegisterDTO> list = this.vehicleRegisterService.getPurchaseHistoryByUserEmail(email);
		try {
			if (!list.isEmpty() && list != null) {
				return new ResponseEntity<List<RegisterDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}