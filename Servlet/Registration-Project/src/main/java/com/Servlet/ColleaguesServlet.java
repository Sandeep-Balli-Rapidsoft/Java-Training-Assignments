package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ServiceLayer.ServiceLayer;
import com.UserEntity.User;

public class ColleaguesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<User> colleaguesList = ServiceLayer.getAllColleagues();

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Colleagues Information</title>");
		out.println("<style>");
		out.println("body {");
		out.println("    font-family: Arial, sans-serif;");
		out.println("    background-color: #f0f0f0;");
		out.println("    padding: 20px;");
		out.println("}");
		out.println("table {");
		out.println("    width: 100%;");
		out.println("    border-collapse: collapse;");
		out.println("    margin: 0 auto;"); // Centering the table
		out.println("}");
		out.println("th, td {");
		out.println("    padding: 10px 5px;");
		out.println("    border-bottom: 1px solid #ddd;");
		out.println("    text-align: center;"); // Centering the table cell content
		out.println("}");
		out.println("th {");
		out.println("    background-color: #f2f2f2;");
		out.println("}");
		out.println(".signout-button {"); // CSS for the "Sign Out" button
		out.println("    display: inline-block;");
		out.println("    padding: 10px 20px;");
		out.println("    background-color: #f44336;");
		out.println("    color: #fff;");
		out.println("    font-size: 16px;");
		out.println("    border: none;");
		out.println("    border-radius: 5px;");
		out.println("    cursor: pointer;");
		out.println("    text-decoration: none;");
		out.println("    margin-top: 20px;");
		out.println("}");
		out.println(".signout-button:hover {");
		out.println("    background-color: #d32f2f;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		if (colleaguesList != null && !colleaguesList.isEmpty()) {
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Employee Code</th>");
			out.println("<th>DOB</th>");
			out.println("<th>Age</th>");
			out.println("<th>Gender</th>");
			out.println("<th>Email</th>");
			out.println("<th>Phone</th>");
			out.println("</tr>");

			for (User colleague : colleaguesList) {
				out.println("<tr>");
				out.println("<td>" + colleague.getFirstName() + " " + colleague.getLastName() + "</td>");
				out.println("<td>" + colleague.getEmpcode() + "</td>");
				out.println("<td>" + colleague.getDob() + "</td>");

				LocalDate dob = LocalDate.parse(colleague.getDob(), formatter);
				int age = currentDate.getYear() - dob.getYear();

				out.println("<td>" + age + "</td>");
				out.println("<td>" + colleague.getGender() + "</td>");
				out.println("<td>" + colleague.getEmail() + "</td>");
				out.println("<td>" + colleague.getPhone_no() + "</td>");
				out.println("</tr>");
			}

			out.println("</table>");

			// Sign out button
			out.println("<a href=\"login.html\" class=\"signout-button\">Sign Out</a>");

		} else {
			out.println("<h3>You have no colleagues</h3>");
		}

		out.println("</body>");
		out.println("</html>");
	}
}
