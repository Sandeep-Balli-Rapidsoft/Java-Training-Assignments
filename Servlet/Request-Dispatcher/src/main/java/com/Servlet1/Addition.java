package com.Servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Addition extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer value1 = Integer.parseInt(req.getParameter("value1"));
		Integer value2 = Integer.parseInt(req.getParameter("value2"));
		Integer sum = value1 + value2;
		
		resp.setContentType("text/html");
		
		req.setAttribute("sum", sum);
		RequestDispatcher rd = req.getRequestDispatcher("multiply");
		rd.forward(req, resp);
		
	}

}
