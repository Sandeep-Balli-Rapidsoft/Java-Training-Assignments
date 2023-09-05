<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Page</title>
</head>
<body>
	<h1>Hello RST</h1>
	
	<form:form action="logout" method="POST">
		<input type="submit" value="Logout">
	
	</form:form>

</body>
</html>