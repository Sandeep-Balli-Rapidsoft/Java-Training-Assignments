<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Custom Login Page</h1>
	<form:form action="process-login" method="POST">
	
	Username: <input type="text" placeholder="username" name="username">
	<br>
	Password: <input type="password" placeholder="password" name="password">	
	<br>
	<input type="submit">
	</form:form>
</body>
</html>