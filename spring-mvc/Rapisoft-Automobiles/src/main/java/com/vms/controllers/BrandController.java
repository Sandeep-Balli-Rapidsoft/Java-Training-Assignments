package com.vms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.Brand;
import com.vms.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addNewBrand(@RequestBody Brand brand) {
		try {
			brandService.saveBrand(brand);
			String msg = "Brand Created Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch(Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
