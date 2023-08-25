<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<%
		String msg = (String) request.getAttribute("msg");
		%>

		<h1 class="text-danger">
			<%=msg%>
		</h1>
	</div>
</body>
</html>
