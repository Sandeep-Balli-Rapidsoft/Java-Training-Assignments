<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
</head>
<body>

	<h2>Departments</h2>

	<%
	List<String> list = (List<String>) request.getAttribute("list");
	%>

	<h2>List of Fav Foods</h2>
	<%
	for (String dept : list) {
	%>
	<h4>
		<%=dept%>
		</h2>
		<%
		}
		%>
	
</body>
</html>