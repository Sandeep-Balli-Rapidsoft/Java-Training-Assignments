package com.springmvc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.ResultDao;
import com.springmvc.dao.StudentDao;
import com.springmvc.dao.SubjectDao;
import com.springmvc.entities.Result;
import com.springmvc.entities.Student;
import com.springmvc.entities.Subject;

@Service
public class ResultService {

	@Autowired
	private ResultDao resultDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private SubjectDao subjectDao;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int insertNewResult() throws IOException {
		System.out.println("Enter Student Email: ");
		String email = br.readLine();

		Student student = studentDao.getStudentByEmail(email);

		if (student != null) {
			Integer studentId = student.getId();

			List<Result> resultList = resultDao.resultList();
			List<Subject> subjectList = subjectDao.subjectList();

			for (Result result : resultList) {
				if (result.getStudent().getId() == studentId) {
					System.out.println("Student Data Already Exists.");
					return 0;
				}
			}

			for (Subject subject : subjectList) {

				System.out.println("Enter Marks For " + subject.getSubject_name());

				System.out.println("Enter Mark: ");
				Double mark = Double.parseDouble(br.readLine());

				int r = resultDao.insert(new Result(new Student(studentId), new Subject(subject.getId()), mark, null));
				System.out.println("Student Result Added Successfully.");
			}

		} else {
			System.out.println("Student does not exist");
		}

		return 0;
	}

	public void addNewResult(String email, List<Double> marksList) {
		Student student = studentDao.getStudentByEmail(email);
		System.out.println(email);
		int idx = 1;
		for (Double mark : marksList) {
			resultDao.insert(new Result(new Student(student.getId()), new Subject(idx), mark, null));
			idx++;
		}
		System.out.println("Data insertion successful");

	}

	public Map<Student, Map<Subject, Double>> getResultThroughMap(String email) {
		Map<Student, Map<Subject, Double>> resultMap = resultDao.calculateMarksByEmail(email);
		return resultMap;
	}

	public void getResultByEmail(String email) {
		List<Result> resultList = resultDao.resultList();
		List<Result> studentResult = new ArrayList<>();

		for (Result result : resultList) {
			if (result.getStudent().getStudent_email().equals(email)) {
				studentResult.add(result);
			}
		}

		if (studentResult.isEmpty()) {
			System.out.println("No Data found with email, " + email);
			return;
		}
		Student student = studentResult.get(0).getStudent();

		System.out.println("Email: " + student.getStudent_email());

		Double marks = 0.0;

		for (Result res : studentResult) {
			try {
				if (res.getIsRecheck() == null) {
					System.out.println("Subject name: " + res.getSubject().getSubject_name());
					System.out.println("Mark: " + res.getMark());
				}
			} catch (NullPointerException e) {

			}

			try {
				if (res.getIsRecheck() == false) {
					System.out.println("Subject name: " + res.getSubject().getSubject_name() + " (Updated)");
					System.out.println("Mark: " + res.getMark());
				}
			} catch (NullPointerException e) {

			}

			try {
				if (res.getIsRecheck() == true) {
					System.out.println("Subject name: " + res.getSubject().getSubject_name() + " (In Process)");
					System.out.println("Mark: " + res.getMark());
				}
			} catch (NullPointerException e) {

			}

			marks += res.getMark();

		}
		Double percentage = calculatePercentage(marks);
		String grade = calculateGrade(percentage);

		System.out.println("Percentage: " + percentage);
		System.out.println("Grade: " + grade);
		System.out.println();

	}

	public Map<Student, Map<Subject, Double>> getAllStudentData() {
		Map<Student, Map<Subject, Double>> map = resultDao.displayAllStudentResult();

		return map;
	}

	public int applyForRecheck(String email, List<String> subjects) throws NumberFormatException, IOException {

		List<Result> resultList = resultDao.resultList();
		List<Result> studentResultList = new ArrayList<>();
		List<Subject> subjectList = subjectDao.subjectList();

		// Find the student's results
		for (Result result : resultList) {
			if (result.getStudent().getStudent_email().equals(email)) {
				studentResultList.add(result);
			}
		}

		// Check if the studentResultList is empty before accessing the first element
		if (studentResultList.isEmpty()) {
			System.out.println("No results found for the specified student.");
			return 0;
		}

		Student student = studentResultList.get(0).getStudent();

		for (Result result : studentResultList) {
			if (subjects.contains(result.getSubject().getSubject_name())) {
				try {
					if (result.getIsRecheck() == true) {
						System.out.println(result.getSubject().getSubject_name());
						System.out.println("Already applied");
						return 0;
					}
				} catch (NullPointerException e) {
					// Handle null pointer exception
				}

				try {
					if (result.getIsRecheck() == false) {
						System.out.println(result.getSubject().getSubject_name());
						System.out.println("Already updated");
						return 0;
					}
				} catch (NullPointerException e) {
					// Handle null pointer exception
				}

				try {
					if (result.getIsRecheck() == null) {
						System.out.println(result.getSubject().getSubject_name());
					}
				} catch (NullPointerException e) {
					// Handle null pointer exception
				}
			}
		}

		for (Subject sub : subjectList) {

			for (String subject : subjects) {

				if (sub.getSubject_name().equals(subject)) {
					System.out.println(sub.getSubject_name() + " " + sub.getId());
					Result result = resultDao.getResultBySubjectAndStudentIds(sub.getId(), student.getId());
					Double existingMark = result.getMark();
					Result recheckResult = new Result(result.getId(), student, sub, existingMark, true);
					resultDao.applyRecheck(recheckResult);
					System.out.println("Applied successfully");
				}
			}
		}
		return 1;

	}

	public List<Result> studentsAppliedForRecheck() throws IOException {
		List<Result> resultList = resultDao.resultList();
		System.out.println(resultList);
		List<Result> appliedForRecheckList = new ArrayList<>();
		for (Result result : resultList) {
			try {
				if (result.getIsRecheck()) {
					appliedForRecheckList.add(result);
				}

			} catch (NullPointerException e) {

			}
		}
		System.out.println(appliedForRecheckList);
		if (appliedForRecheckList.isEmpty() || appliedForRecheckList == null) {
			System.out.println("No student have applied for recheck");
			return null;
		}

		System.out.println(appliedForRecheckList);
		return appliedForRecheckList;

	}

	public void updateMarkForStudent(String email) {
		try {
			List<Result> resultList = resultDao.resultList();
			List<Result> subjectMarksToBeUpdatedList = new ArrayList<>();

			for (Result result : resultList) {
				try {
					if (result.getStudent().getStudent_email().equals(email) && result.getIsRecheck()) {
						subjectMarksToBeUpdatedList.add(result);
					}
				} catch (Exception e) {

				}

			}

			if (subjectMarksToBeUpdatedList.isEmpty()) {
				System.out.println("This student has not applied for recheck.");
				return;
			}

			for (Result result : subjectMarksToBeUpdatedList) {
				System.out.println("Enter Marks for " + result.getSubject().getSubject_name());

				try {
					Double mark = Double.parseDouble(br.readLine());
					Result updatedResult = result;
					updatedResult.setMark(mark);
					updatedResult.setIsRecheck(false);

					resultDao.updateMark(updatedResult);
				} catch (NumberFormatException e) {
					System.err.println("Invalid input for mark. Please enter a valid number.");
				} catch (IOException e) {
					System.err.println("An error occurred while reading input: " + e.getMessage());
				}
			}
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	public int updateMarkLatest(String email, List<Double> marks, List<String> subjects) {
		List<Subject> subjectList = subjectDao.subjectList();
		Student student = studentDao.getStudentByEmail(email);
		System.out.println("Name: " + student.getStudent_name());
		for (Subject subject : subjectList) {

			for (int i = 0; i < subjects.size(); i++) {
				if (subject.getSubject_name().equals(subjects.get(i))) {
					System.out.println("Subject: " + subject.getSubject_name());
					System.out.println("ID: " + subject.getId());
					System.out.println("Marks" + marks.get(i));
					Double mark = marks.get(i);
					Integer subjectId = subject.getId();
					Integer studentId = student.getId();
					Result result = resultDao.getResultBySubjectAndStudentIds(subjectId, studentId);
					Result updatedResult = result;
					result.setMark(mark);
					result.setIsRecheck(false);
					resultDao.updateMark(updatedResult);
				}
			}
		}

		return 0;
	}

	public Double calculatePercentage(Double marksSecured) {
		return (marksSecured / 600) * 100;
	}

	public String calculateGrade(Double percentage) {
		String grade = "";
		if (percentage > 90 && percentage <= 100) {
			grade = "A1";
		} else if (percentage > 80 && percentage <= 90) {
			grade = "A2";
		} else if (percentage > 60 && percentage <= 80) {
			grade = "B";
		} else if (percentage > 40 && percentage <= 60) {
			grade = "C";
		} else if (percentage > 30 && percentage <= 40) {
			grade = "D";
		} else {
			grade = "Fail";
		}
		return grade;
	}

}