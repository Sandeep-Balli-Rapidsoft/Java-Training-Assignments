package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.ResultDao;
import com.dao.StudentDao;
import com.dao.SubjectDao;
import com.entities.Result;
import com.entities.Student;
import com.entities.Subject;
import com.main.DbConfig;

public class ResultService {
	ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
	ResultDao resultDao = context.getBean(ResultDao.class);
	StudentDao studentDao = context.getBean(StudentDao.class);
	SubjectDao subjectDao = context.getBean(SubjectDao.class);

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int insertNewResult() throws IOException {
		System.out.println("Enter Student Email: ");
		String email = br.readLine();

		// Fetching the student object by email.
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

				int r = resultDao.insert(new Result(new Student(studentId), new Subject(subject.getId()), mark, false));
			}

		} else {
			System.out.println("Student does not exist");
		}

		return 0;
	}

	public void getResultByEmail(String email) {
		Map<Student, Map<Subject, Double>> studentMap = resultDao.calculateMarksByEmail(email);

		for (Map.Entry<Student, Map<Subject, Double>> studentEntry : studentMap.entrySet()) {
			Student student = studentEntry.getKey();
			Map<Subject, Double> subjectMarksMap = studentEntry.getValue();
			Double totalMarks = 0.0;

			for (Double mark : subjectMarksMap.values()) {
				totalMarks += mark;
			}

			Double percentage = calculatePercentage(totalMarks);
			String grade = calculateGrade(percentage);

			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("Name: " + student.getStudent_name());
			System.out.println("Percentage: " + percentage);
			System.out.println("Grade: " + grade);
			System.out.println("Subject-wise Marks:");

			for (Map.Entry<Subject, Double> subjectEntry : subjectMarksMap.entrySet()) {
				Subject subject = subjectEntry.getKey();
				Double mark = subjectEntry.getValue();
				System.out.println("Subject: " + subject.getSubject_name() + ", Mark: " + mark);
			}

			System.out.println("---------------------------------------------");
			System.out.println();
		}
	}

	public void getAllStudentData() {
		Map<Student, Map<Subject, Double>> map = resultDao.displayAllStudentResult();

		for (Map.Entry<Student, Map<Subject, Double>> entry : map.entrySet()) {
			Student student = entry.getKey();
			Map<Subject, Double> resultMap = entry.getValue();

			System.out.println("Student: " + student.getStudent_name());
			double totalMarks = 0.0;
			for (Map.Entry<Subject, Double> resultEntry : resultMap.entrySet()) {
				String subject = resultEntry.getKey().getSubject_name();
				Double mark = resultEntry.getValue();
				System.out.println("Subject: " + subject + ", Mark: " + mark);
				totalMarks += mark;
			}
			Double percentage = calculatePercentage(totalMarks);
			String grade = calculateGrade(percentage);

			System.out.println("Percentage: " + percentage);
			System.out.println("Grade: " + grade);
			System.out.println();
		}
	}

	public void applyForRecheck(String email) throws NumberFormatException, IOException {
		Map<Student, Map<Subject, Double>> resultMap = resultDao.calculateMarksByEmail(email);

		resultMap.entrySet().forEach(entry -> {
			Student studentKey = entry.getKey();
			System.out.println("Hello, " + studentKey.getStudent_name());
			System.out.println("Choose the subject to apply for recheck below.");
			Map<Subject, Double> marksMap = entry.getValue();
			for (Map.Entry<Subject, Double> entryForMark : marksMap.entrySet()) {
				Subject subject = entryForMark.getKey();
				Double mark = entryForMark.getValue();
				System.out.println("Enter " + subject.getId() + ", to apply for recheck,  Subject: "
						+ subject.getSubject_name() + " Mark: " + mark);
			}

			try {
				Integer subjectId = Integer.parseInt(br.readLine());
				Result result = resultDao.getResultByStudentEmailAndSubjectId(email, subjectId);
				result.setIsRecheck(true);
				resultDao.applyRecheck(result);
			} catch (IOException e) {
				System.err.println("An error occurred while reading input: " + e.getMessage());
			} catch (NumberFormatException e) {
				System.err.println("Invalid input. Please enter a valid number.");
			}
		});
	}

	public void studentsAppliedForRecheck() throws IOException {
		List<Result> resultList = resultDao.resultList();
		for (Result result : resultList) {
			if (result.getIsRecheck()) {
				System.out.println("Student ID: " + result.getStudent().getStudent_email());
				System.out.println("Student Name: " + result.getStudent().getStudent_name());
				System.out.println("Subject: " + result.getSubject().getSubject_name());
				System.out.println("Mark " + result.getMark());

				System.out.println("-----------------------");
			}
		}

	}

	public void updateMarkForStudent(String email) throws NumberFormatException, IOException {
		List<Result> resultList = resultDao.getStudentMarksByEmail(email);
		List<Result> subjectMarksToBeUpdatedList = new ArrayList<>();
		for (Result result : resultList) {
			if (result.getIsRecheck()) {
				subjectMarksToBeUpdatedList.add(result);
			}
		}

		for (Result result : subjectMarksToBeUpdatedList) {
			System.out.println("Enter Marks for " + result.getSubject().getSubject_name());
			Double mark = Double.parseDouble(br.readLine());
			Result updatedResult = resultDao.getResultByStudentEmailAndSubjectId(result.getStudent().getStudent_email(),
					result.getSubject().getId());
			updatedResult.setMark(mark);
			updatedResult.setIsRecheck(false);
			resultDao.updateMark(updatedResult);
		}

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