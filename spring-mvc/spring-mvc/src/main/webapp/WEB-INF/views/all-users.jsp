<%@page import="com.springmvc.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
</head>
<body>
		<%
	List<User> list = (List<User>) request.getAttribute("list");
	%>

	<h2>List of All Users</h2>
	<%
	for (User user : list) {
	%>
	<h4>
		<%=user.getFirstName()%>
		</h2>
		<%
		}
		%>

</body>
</html>