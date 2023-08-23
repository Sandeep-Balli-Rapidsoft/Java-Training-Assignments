package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping("/form")
	public String register() {
		return "form";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerDetails(@ModelAttribute("user") User user, Model model) {
		System.out.println(user);
		this.userService.createUser(user);
		return "success";
	}
	
	@RequestMapping("/all-users")
	public ModelAndView getAllUsers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", this.userService.getAllUsers());
		modelAndView.setViewName("all-users");
		return modelAndView;
	}
	
	@RequestMapping("/menu")
	public String userMenu() {
		return "menu";
	}

}
