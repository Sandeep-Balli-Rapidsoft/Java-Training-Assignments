<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Result</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	display: block;
	font-weight: bold;
	margin-top: 10px;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

button {
	display: block;
	margin: 20px auto;
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<%
	String email = (String) request.getAttribute("email");
	%>

	<div class="container">
		<h1>Add Result</h1>
		<h2>
		<%=email %>
		</h2>
		<form action="new-result" method="post">
			<input type="hidden" name="email" value="<%= email %>">
			<label for="java">Java:</label> <input type="text" id="java"
				name="java"> <label for="javascript">JavaScript:</label> <input
				type="text" id="javascript" name="javascript"> <label
				for="python">Python:</label> <input type="text" id="python"
				name="python"> <label for="c">C:</label> <input type="text"
				id="c" name="c"> <label for="operatingsystem">Operating
				System:</label> <input type="text" id="operatingsystem"
				name="operatingsystem"> <label for="dbms">DBMS:</label> <input
				type="text" id="dbms" name="dbms">

			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
