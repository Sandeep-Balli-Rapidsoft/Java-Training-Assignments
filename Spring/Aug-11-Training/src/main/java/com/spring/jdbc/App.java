package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.EmployeeDAO;
import com.spring.jdbc.dao.EmployeeDaoImplementation;
import com.spring.jdbc.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        
        EmployeeDAO employeeDao = context.getBean("getEmployeeDAO", EmployeeDaoImplementation.class);
        
//		INSERT EMPLOYEE        
//      Employee employee = new Employee();
//      employee.setId(101);
//      employee.setName("Smruti");
//      employee.setAge(22);
//      employee.setDept("DEV");
//      int result = employeeDao.insert(employee);

        
        
//		  UPDATE EMPLOYEE         
//        Employee employee = new Employee();
//        employee.setId(101);
//        employee.setName("Smruti Ranjan");
//        employee.setAge(22);
//        employee.setDept("DEV");
//        int result = employeeDao.update(employee);
        
//		  Get All Employees          
        List<Employee> list = employeeDao.getAllEmployees();
        System.out.println(list);
        
//		  Get EMployee By Id        
//        Employee emp = employeeDao.getEmployeById(102);
//        System.out.println(emp);
        
        
//         Delete Employee
//        int result = employeeDao.deleteEmployee(103);
//        if(result > 0) {
//        	System.out.println("Employee Deleted");
//        } else {
//        	System.out.println("Deletion Failed");
//        }
    }
}
