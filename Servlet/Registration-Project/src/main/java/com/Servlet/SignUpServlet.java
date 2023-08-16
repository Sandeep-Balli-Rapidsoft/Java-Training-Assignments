package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ServiceLayer.ServiceLayer;
import com.UserDAO.UserDAO;
import com.UserEntity.User;

public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		// TODO Auto-generated method stub
		String firstName = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		String dobString = req.getParameter("dob");
		
		String phone_no = req.getParameter("phone_no");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String empCode = req.getParameter("empcode");
		String password = req.getParameter("password");
		
		

		
		User user = new User(1, firstName, lastname, dobString, phone_no, empCode, email, gender, password);
		
		boolean flag = ServiceLayer.isInsertedData(user);
		HttpSession session = req.getSession();
		
		if(flag) {
			resp.sendRedirect("login.html");
			
			System.out.println("Employee Registred Successfully");
		} else {
			
			System.out.println("Employee registration failed");
		}

	}

}
