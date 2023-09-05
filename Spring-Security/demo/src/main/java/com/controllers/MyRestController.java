package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@ResponseBody
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Good morning " + name;
	}
}
