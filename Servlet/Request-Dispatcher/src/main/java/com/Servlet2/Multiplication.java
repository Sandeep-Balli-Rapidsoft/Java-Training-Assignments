package com.Servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Multiplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer value1 = Integer.parseInt(req.getParameter("value1"));
		Integer value2 = Integer.parseInt(req.getParameter("value2"));
		
		Integer product = value1 * value2;
		
		Integer add = (int) req.getAttribute("sum");
		
		PrintWriter out = resp.getWriter();
		out.println("<h3> Multiplication of " + value1 + " and " + value2 + " is: " + product + " </h3>");
		out.println("<h3> Addition of " + value1 + " and " + value2 + " is: " + add + " </h3>");

	}

}
