<%@page import="com.springmvc.entities.Subject"%>
<%@page import="java.util.Map"%>
<%@page import="com.springmvc.entities.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>

	<%
Student student = (Student) request.getAttribute("student");
Map<Subject, Double> marksMap = (Map) request.getAttribute("marksMap");
Double percentage = (Double) request.getAttribute("percentage");
String grade = (String) request.getAttribute("grade");
%>

	<h1>
		<%=student.getStudent_name()%>
	</h1>

	<table border="1">
		<tr>
			<th>Subject</th>
			<th>Marks</th>
		</tr>
		<%
		for (Map.Entry<Subject, Double> entry : marksMap.entrySet()) {
			Subject subject = entry.getKey();
			Double marks = entry.getValue();
		%>
		<tr>
			<td><%=subject.getSubject_name()%></td>
			<td><%=marks%></td>
		</tr>
		<%
		}
		%>
	</table>
	<h3>Percentage: <%= percentage %> </h3>
	<br>
	<h3>Grade: <%= grade %> </h3>

</body>
</html>
