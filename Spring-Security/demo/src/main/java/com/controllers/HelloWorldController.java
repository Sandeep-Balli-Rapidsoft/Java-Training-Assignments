package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "hello-world";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello from BBSR";
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}

}
