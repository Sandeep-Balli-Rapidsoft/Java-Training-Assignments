package com.CheckUserDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class AddServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
//		res.setContentType("text/html");
//		PrintWriter out = res.getWriter();
		
		if(name.equals(new String("Sandeep_Balli")) && password.equals(new String("sandeep@123"))) {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("<h1> Welcome: "+name+" </h1>");
			out.println("<h3> You have logged in successfully. </h3>");

		} else {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("<h1> Invalid credentials </h1>");
		}
	}
}
