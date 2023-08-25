package com.springmvc.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dao.ResultDao;
import com.springmvc.dao.StudentDao;
import com.springmvc.dao.SubjectDao;
import com.springmvc.entities.Result;
import com.springmvc.entities.Student;
import com.springmvc.entities.Subject;
import com.springmvc.service.ResultService;

@Controller
public class ResultController {

	@Autowired
	private ResultService resultService;

	@Autowired
	private ResultDao resultDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	SubjectDao subjectDao;

	@RequestMapping("/verify")
	public String verify() {
		return "verify-email";
	}

	@RequestMapping("/verifyEmail")
	public ModelAndView verifyEmail(@RequestParam("email") String email) {
		Student student = studentDao.getStudentByEmail(email);
		List<Result> resultList = resultDao.resultList();
		ModelAndView modelAndView = new ModelAndView();

		if (student == null) {
			String msg = "No student found with the mail " + email;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		for (Result result : resultList) {
			String msg = "Student Result is already published. You cannot update untill the student applies for recheck ";
			modelAndView.addObject("msg", msg);
			if (result.getStudent().getStudent_email().equals(email)) {
				modelAndView.setViewName("error");
				return modelAndView;
			}
		}

		modelAndView.addObject("email", email);
		modelAndView.setViewName("add-result");
		return modelAndView;
	}

	@RequestMapping(value = "/new-result", method = RequestMethod.POST)
	public ModelAndView addResult(@RequestParam("java") String java, @RequestParam("javascript") String javaScript,
			@RequestParam("python") String python, @RequestParam("c") String c,
			@RequestParam("operatingsystem") String operatingSystem, @RequestParam("dbms") String dbms,
			@RequestParam("email") String email) {
		
		ModelAndView modelAndView = new ModelAndView();

		List<Double> mark = Arrays.asList(Double.parseDouble(java), Double.parseDouble(javaScript),
				Double.parseDouble(python), Double.parseDouble(c), Double.parseDouble(operatingSystem),
				Double.parseDouble(dbms));

		resultService.addNewResult(email, mark);
		
		String msg = "Result added successfully";
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("test");
		return modelAndView;
	}

	@RequestMapping("/validateEmail")
	public String formForEmail() {
		return "verify-email-result";
	}

	@RequestMapping("/verify-for-result")
	public ModelAndView getStudentResultByEmail(@RequestParam("email") String email) {
		ModelAndView modelAndView = new ModelAndView();
		List<Result> resultList = resultDao.resultList();
		List<Result> studentResultList = new ArrayList<>();

		Student student = studentDao.getStudentByEmail(email);
		if (student == null) {
			String msg = "No student found with the mail " + email;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		for (Result result : resultList) {
			if (result.getStudent().getStudent_email().equals(email)) {
				studentResultList.add(result);
			}
		}

		if (studentResultList == null || studentResultList.isEmpty()) {
			String msg = "No result found for student with email, " + email;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		Double totalMarks = 0.0;
		for (Result result : studentResultList) {
			totalMarks += result.getMark();
		}
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		Double percentage = resultService.calculatePercentage(totalMarks);
		String grade = resultService.calculateGrade(percentage);

		modelAndView.addObject("name", studentResultList.get(0).getStudent().getStudent_name());
		modelAndView.addObject("email", studentResultList.get(0).getStudent().getStudent_email());
		modelAndView.addObject("totalMarks", totalMarks);
		modelAndView.addObject("percentage", decimalFormat.format(percentage));
		modelAndView.addObject("grade", grade);

		modelAndView.addObject("list", studentResultList);
		modelAndView.setViewName("student-data");

		return modelAndView;
	}

	@RequestMapping("/all-results")
	public ModelAndView getAllResults() {
		ModelAndView md = new ModelAndView();
		Map<Student, Map<Subject, Double>> allData = resultService.getAllStudentData();
		md.addObject("allData", allData);
		md.setViewName("all-student-data");
		return md;

	}

	@RequestMapping("/apply-recheck")
	public String recheckPage() {
		return "recheck-email";
	}

	@RequestMapping("/verify-email-recheck")
	public ModelAndView verifyEmailForRecheck(@RequestParam("email") String email) {
		Student student = studentDao.getStudentByEmail(email);
		ModelAndView modelAndView = new ModelAndView();

		if (student == null) {
			String msg = "No student found with the mail " + email;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		modelAndView.addObject("email", email);
		modelAndView.setViewName("recheck-form");
		return modelAndView;
	}

	@RequestMapping(value = "/recheck-form-data", method = RequestMethod.POST)
	public ModelAndView recheck(@RequestParam("email") String email,
			@RequestParam(value = "subjects", required = false) List<String> subjects)
			throws NumberFormatException, IOException {
		ModelAndView modelAndView = new ModelAndView();

		if (subjects != null && !subjects.isEmpty()) {
			Integer result = resultService.applyForRecheck(email, subjects);
			
			

			if (result == 0) {
				String msg = "You can apply for recheck only once or your result have not been published yet";
				modelAndView.addObject("msg", msg);
				modelAndView.setViewName("error");
				return modelAndView;
			}
		} else {
			String msg = "No Subject Selected";
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		String msg = "Recheck request processed successfully";
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("test");

		return modelAndView;
	}

	@RequestMapping("/view-recheck-applications")
	public ModelAndView getRecheckData() throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		List<Result> recheckApplicationList = resultService.studentsAppliedForRecheck();
		modelAndView.addObject("list", recheckApplicationList);
		modelAndView.setViewName("recheck-student-data");
		return modelAndView;
	}

	@RequestMapping("/update-mark")
	public String updateMark() {
		return "update-mark-email";
	}

	@RequestMapping("/update-verify-email")
	public ModelAndView verifyEmailForUpdate(@RequestParam("email") String email) throws IOException {
		Student student = studentDao.getStudentByEmail(email);
		List<Result> resultList = resultDao.resultList();
		ModelAndView modelAndView = new ModelAndView();
		List<Result> studentsAppliedForRecheckList = resultService.studentsAppliedForRecheck();
		List<Result> studentResultList = new ArrayList<>();

		if (student == null) {
			String msg = "No student found with the mail " + email;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		Boolean flag = false;
		for (Result result : resultList) {
			if (result.getStudent().getStudent_email().equals(email)) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			String msg = "No result found for student with email, " + email;
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("error");
			return modelAndView;
		}

		for (Result result : resultList) {
			if (result.getStudent().getStudent_email().equals(email)) {
				try {
					if (result.getIsRecheck() == true) {
						studentResultList.add(result);
					}

				} catch (NullPointerException e) {

				}

			}
		}

		modelAndView.addObject("email", email);
		modelAndView.addObject("list", studentResultList);

		modelAndView.setViewName("update-mark-form");
		return modelAndView;
	}

	@RequestMapping(value = "/update-mark-process", method = RequestMethod.POST)
	public ModelAndView updateMarkProcess(@RequestParam("subjects") List<String> subjects,
			@RequestParam("marks") List<Double> marks, @RequestParam("email") String email) {
		ModelAndView modelAndView = new ModelAndView();
		resultService.updateMarkLatest(email, marks, subjects);
		String msg = "Mark updated successfully for the user with email,  " + email;
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("test");
		return modelAndView;
	}

}
