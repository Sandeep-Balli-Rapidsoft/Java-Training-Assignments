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

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<ShowRoom> list = this.showRoomService.getAll();
		try {
			if(!list.isEmpty()) {
				return new ResponseEntity<List<ShowRoom>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/location/{location}")
	public ResponseEntity<?> getShowRoomByLocation(@PathVariable ("location") String location) {
		List<ShowRoom> list = this.showRoomService.getShowroomByLocation(location);
		
		try {
			if(!list.isEmpty()) {
				return new ResponseEntity<List<ShowRoom>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
