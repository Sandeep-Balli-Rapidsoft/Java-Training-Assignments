<%@page import="java.util.List"%>
<%@page import="com.springmvc.entities.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recheck Data</title>
</head>
<body>
	<h1>Recheck Applications</h1>
	<table border="1">
		<tr>
			<th>Student Email</th>
			<th>Student Name</th>
			<th>Subject</th>
			<th>Mark</th>
		</tr>
		<%
		List<Result> list = (List<Result>) request.getAttribute("list");
		if (list != null && !list.isEmpty()) {
			for (Result result : list) {
		%>
		<tr>
			<td><%=result.getStudent().getStudent_email()%></td>
			<td><%=result.getStudent().getStudent_name()%></td>
			<td><%=result.getSubject().getSubject_name()%></td>
			<td><%=result.getMark()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">No student has applied for recheck.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
