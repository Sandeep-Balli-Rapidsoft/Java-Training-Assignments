package com.vms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.SubBrand;
import com.vms.service.SubBrandService;

@RequestMapping("/sub-brand")
@RestController
public class SubBrandConroller {
	
	@Autowired
	private SubBrandService subBrandService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addNewSubBrand(@RequestBody SubBrand subBrand) {
		try {
			this.subBrandService.saveSubBrand(subBrand);
			String msg = "Sub Brand Created Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch(Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> allSubBrands() {
		List<SubBrand> list = this.subBrandService.subBrandList();
		try {
			if(!list.isEmpty()) {
				String msg = "Sub Brand List";
				return new ResponseEntity<List<SubBrand>>(list, HttpStatus.OK);
			} else {
				String msg = "No Data Found";
				return new ResponseEntity<List<SubBrand>>(list, HttpStatus.NO_CONTENT);
			}
		} catch(Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}
