<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About</title>
</head>
<body>
	<h1>Rapidsoft Technologies</h1>
	<%
	String name = (String) request.getAttribute("name");
	String id = (String) request.getAttribute("id");
	List<String> list = (List<String>) request.getAttribute("list");
	%>

	<h3>
		Name =
		<%=name%>
		<br> EmpCode =
		<%=id%>
	</h3>
	<br>
	<h2>List of Fav Foods</h2>
	<%
	for (String food : list) {
	%> <h4>
	<%=food%>
	</h2>
	<%
	}
	%>

</body>
</html>