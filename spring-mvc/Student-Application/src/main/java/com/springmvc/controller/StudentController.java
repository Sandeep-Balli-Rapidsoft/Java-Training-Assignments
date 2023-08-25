package com.springmvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entities.Student;
import com.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/add-student")
	public String pageForNewStudent() {
		return "add-student";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addStudent(@RequestParam("name") String name, @RequestParam("email") String email) throws IOException {
		Integer i = this.studentService.insertNewStudent(name, email);
		ModelAndView modelAndView = new ModelAndView();
		if(i > 1) {	
			String msg = "Student Added Successfully";
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("test");
			return modelAndView;
		}
		String msg = "Student already exist";
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
