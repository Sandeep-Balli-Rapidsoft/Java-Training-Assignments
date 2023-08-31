package com.vms.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.dto.user.ConvertUser;
import com.vms.dto.user.UserDTO;
import com.vms.entity.User;
import com.vms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<?> addNewUser(@RequestBody UserDTO userDto) {
		try {
			userService.saveUser(userDto);
			String msg = "User Created";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping("/all")
	public ResponseEntity<?> getAllUsers() {

		try {
			List<UserDTO> list = this.userService.getAllUsers();
			return new ResponseEntity<List<UserDTO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
