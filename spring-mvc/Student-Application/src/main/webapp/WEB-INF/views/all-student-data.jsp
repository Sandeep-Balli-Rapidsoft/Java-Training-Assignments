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
</head>
<body>

	<%
	Map<Student, Map<Subject, Double>> map = (Map) request.getAttribute("allData");
	ResultService rs = new ResultService();
	for (Map.Entry<Student, Map<Subject, Double>> entry : map.entrySet()) {
		Student student = entry.getKey();
		Double totalMarks = 0.0;
		Map<Subject, Double> marksMap = entry.getValue();
	%>

	<h1><%=student.getStudent_name()%></h1>

	<table border="1">
		<tr>
			<th>Subject</th>
			<th>Marks</th>
		</tr>
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

</body>
</html>
s
