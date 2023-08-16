package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter(); 	
		
		String name = req.getParameter("userName");
		String password = req.getParameter("userPassword");
		
		out.println("Hello: " + name);
		out.println(" Password: " + password);
		
		Cookie c1 = new Cookie("username", name);
		Cookie c2 = new Cookie("password", password);
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		out.print("<br><a href='welcome'>View Details</a>");

	}
	
	
}
