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

import com.vms.dto.brand.BrandDTO;
import com.vms.entity.Brand;
import com.vms.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addNewBrand(@RequestBody BrandDTO brandDto) {
		try {
			brandService.save(brandDto);
			String msg = "Brand Created Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch(Exception e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		try {
			List<BrandDTO> list = this.brandService.getAll();
			if(!list.isEmpty() && list != null) {
				return new ResponseEntity<List<BrandDTO>>(list, HttpStatus.OK);
			} else {
				String msg = "No Brands Available";
				return new ResponseEntity<String>(msg, HttpStatus.NO_CONTENT);
			}
		} catch (NullPointerException e) {
			String msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}
