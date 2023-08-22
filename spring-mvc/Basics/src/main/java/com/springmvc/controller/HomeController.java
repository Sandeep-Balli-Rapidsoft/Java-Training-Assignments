package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.User;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("In Home");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("Chicken");
		list.add("Fish");
		list.add("Mutton");
		model.addAttribute("name", "SANDEEP BALLI");
		model.addAttribute("id", "RSTB042");
		model.addAttribute("list", list);
		return "about";
	}
	
	@RequestMapping("/departments")
	public ModelAndView departments() {
		List<String> list = new ArrayList<String>();
		ModelAndView md = new ModelAndView();
		list.add("Frontend");
		list.add("Backend");
		list.add("Testing");
		
		md.addObject("list", list);
		md.setViewName("departments");
		
		return md;

	}
	
	@RequestMapping("/list")
	public List<String> listAll() {
		List<String> list = new ArrayList<String>();
		ModelAndView md = new ModelAndView();
		list.add("Frontend");
		list.add("Backend");
		list.add("Testing");
		
		md.addObject("list", list);
		md.setViewName("departments");
		
		return list;

	}

	
	@RequestMapping("/form")
	public String register() {
		return "form";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerDetails(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("firstName", user.getFirstName());
		modelAndView.addObject("lastName", user.getLastName());
		modelAndView.setViewName("success");
		System.out.println("Full Name: " + user.getFirstName() + " " + user.getLastName());
		return modelAndView;
	}
}
