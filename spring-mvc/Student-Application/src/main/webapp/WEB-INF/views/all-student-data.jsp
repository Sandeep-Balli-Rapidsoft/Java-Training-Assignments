<%@page import="com.springmvc.service.ResultService"%>
<%@page import="com.springmvc.entities.Subject"%>
<%@page import="com.springmvc.entities.Student"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Student Data</title>
<!-- Add the Bootstrap CSS link -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<%
		Map<Student, Map<Subject, Double>> map = (Map) request.getAttribute("allData");
		ResultService rs = new ResultService();
		for (Map.Entry<Student, Map<Subject, Double>> entry : map.entrySet()) {
			Student student = entry.getKey();
			Double totalMarks = 0.0;
			Map<Subject, Double> marksMap = entry.getValue();
		%>

		<h1><%=student.getStudent_name()%></h1>

		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th>Subject</th>
					<th>Marks</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Map.Entry<Subject, Double> markEntry : marksMap.entrySet()) {
					Subject subject = markEntry.getKey();
					Double marks = markEntry.getValue();
					totalMarks += marks;
				%>
				<tr>
					<td><%=subject.getSubject_name()%></td>
					<td><%=marks%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<%
		// Calculate percentage and grade after the inner loop
		Double percentage = rs.calculatePercentage(totalMarks);
		String grade = rs.calculateGrade(percentage);
		%>

		<p>
			Total Marks:
			<%=totalMarks%></p>
		<p>
			Percentage:
			<%=percentage%></p>
		<p>
			Grade:
			<%=grade%></p>

		<br>

		<%
		}
		%>
	</div>

	<!-- Add the Bootstrap JS and jQuery scripts (optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
