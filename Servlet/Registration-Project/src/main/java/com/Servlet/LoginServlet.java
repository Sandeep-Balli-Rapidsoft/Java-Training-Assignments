package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceLayer.ServiceLayer;
import com.UserEntity.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = ServiceLayer.login(email, password);

		PrintWriter out = resp.getWriter();

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		resp.setContentType("text/html");

		if (user != null) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>User Information</title>");
			out.println("<style>");
			out.println("body {");
			out.println("    font-family: Arial, sans-serif;");
			out.println("    background-color: #f0f0f0;");
			out.println("    display: flex;");
			out.println("    justify-content: center;");
			out.println("    align-items: center;");
			out.println("    height: 100vh;");
			out.println("}");
			out.println(".container {");
			out.println("    padding: 20px;");
			out.println("    border-radius: 5px;");
			out.println("    background-color: #fff;");
			out.println("    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);");
			out.println("}");
			out.println("table {");
			out.println("    width: 100%;");
			out.println("    border-collapse: collapse;");
			out.println("}");
			out.println("th, td {");
			out.println("    padding: 12px 10px;"); // Added spacing between rows and columns
			out.println("    border-bottom: 1px solid #ddd;");
			out.println("}");
			out.println("th {");
			out.println("    background-color: #f2f2f2;");
			out.println("}");
			out.println(".explore-more {");
			out.println("    margin-top: 20px;");
			out.println("    text-align: center;");
			out.println("}");
			out.println(".explore-button {"); // CSS for the "Explore More" button
			out.println("    display: inline-block;");
			out.println("    padding: 12px 20px;");
			out.println("    background-color: #4CAF50;");
			out.println("    color: #fff;");
			out.println("    font-size: 16px;");
			out.println("    border: none;");
			out.println("    border-radius: 5px;");
			out.println("    cursor: pointer;");
			out.println("    text-decoration: none;");
			out.println("}");
			out.println(".explore-button:hover {");
			out.println("    background-color: #45a049;");
			out.println("}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");

			out.println("<div class=\"container\">");

			out.println("<table>");
			out.println("<tr><th>Name</th><td>" + user.getFirstName() + " " + user.getLastName() + "</td></tr>");
			out.println("<tr><th>Email</th><td>" + user.getEmail() + "</td></tr>");
			out.println("<tr><th>Employee Code</th><td>" + user.getEmpcode() + "</td></tr>");
			out.println("<tr><th>DOB</th><td>" + user.getDob() + "</td></tr>");

			LocalDate dob = LocalDate.parse(user.getDob(), formatter);
			int age = currentDate.getYear() - dob.getYear();
			out.println("<tr><th>Age</th><td>" + age + "</td></tr>");

			out.println("<tr><th>Gender</th><td>" + user.getGender() + "</td></tr>");

			out.println("</table>");

			out.println("<div class=\"explore-more\">");
			out.println("<a href=\"colleagues.html\" class=\"explore-button\">Explore More</a>");

			// Sign out button
			out.println("<a href=\"login.html\" class=\"explore-button\">Sign out</a>");

			out.println("</div>");

			out.println("</div>"); // Closing the container div

			out.println("</body>");
			out.println("</html>");

		} else {
			out.println("<h3> Invalid Credentials</h3>");
		}
	}
}
