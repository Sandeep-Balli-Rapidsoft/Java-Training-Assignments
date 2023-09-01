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

import com.vms.dto.showroom.ShowroomDTO;
import com.vms.entity.ShowRoom;
import com.vms.service.ShowRoomService;

@RestController
@RequestMapping("/showroom")
public class ShowRoomController {

	@Autowired
	private ShowRoomService showRoomService;

	@PostMapping("/create")
	public ResponseEntity<?> addNewShowRoom(@RequestBody ShowroomDTO showroomDto) {
		try {
			this.showRoomService.saveShowRoom(showroomDto);
			String msg = "Show Room Created Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<ShowroomDTO> list = this.showRoomService.getAll();
		try {
			if(!list.isEmpty()) {
				return new ResponseEntity<List<ShowroomDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/location/{location}")
	public ResponseEntity<?> getShowRoomByLocation(@PathVariable ("location") String location) {
		List<ShowroomDTO> list = this.showRoomService.getShowroomByLocation(location);
		
		try {
			if(!list.isEmpty()) {
				return new ResponseEntity<List<ShowroomDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Content";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}
