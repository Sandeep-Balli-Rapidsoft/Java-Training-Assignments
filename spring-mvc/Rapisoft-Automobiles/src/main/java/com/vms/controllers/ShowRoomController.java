package com.vms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.ShowRoom;
import com.vms.service.ShowRoomService;

@RestController
@RequestMapping("/showroom")
public class ShowRoomController {

	@Autowired
	private ShowRoomService showRoomService;

	@PostMapping("/create")
	public ResponseEntity<?> addNewShowRoom(@RequestBody ShowRoom showRoom) {
		try {
			this.showRoomService.saveShowRoom(showRoom);
			String msg = "Show Room Created Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
