package com.vms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.Response;
import com.vms.dto.user.UserDTO;
import com.vms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public Response<?> addNewUser(@RequestBody UserDTO userDto) {
		try {
			return userService.saveUser(userDto);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			return new Response<String>(msg, null, HttpStatus.BAD_REQUEST);
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
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}
