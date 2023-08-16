package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.EmployeeDao;
import com.spring.orm.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);

		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("------------------------------------");
			System.out.println("Enter 1, for adding new employee.");
			System.out.println("Enter 2, to get a employee by id.");
			System.out.println("Enter 3, to get all employees.");
			System.out.println("Enter 4, to update a employee.");
			System.out.println("Enter 5, to delete a employee.");
			System.out.println();
			System.out.println("------------------------------------");

			Integer optionEntered = Integer.parseInt(br.readLine());
			if (optionEntered == 1) {
				Employee newEmployee = new Employee(102, "Smruti Ranjan", 22, "Male");
				int result = employeeDao.insert(newEmployee);
				System.out.println(result);
			} else if (optionEntered == 2) {
				System.out.println("Enter Employee Id");
				Integer employeeId = Integer.parseInt(br.readLine());
				Employee employee = employeeDao.getEmployeeById(employeeId);
				System.out.println(employee);
			} else if (optionEntered == 3) {
				List<Employee> employeeList = employeeDao.getAllEmployees();
				for (Employee employee : employeeList) {
					System.out.println("Employee Name: " + employee.getName() + " Employee Age: " + employee.getAge()
							+ " Employee Gender: " + employee.getGender());
					
				}
			} else if (optionEntered == 4) {
				Employee employee = new Employee(102, "Smruti Ranjan Nayak", 22, "Male");
				employeeDao.update(employee);
				System.out.println("Employee Data Updated");
			} else if (optionEntered == 5) {
				System.out.println("Enter Employee Id");
				Integer employeeId = Integer.parseInt(br.readLine());
				employeeDao.delete(employeeId);
				System.out.println("Employee Deleted");
			} else {
				System.out.println("Exiting..");
				System.exit(0);
			}
		}

	}
}
