<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Result</title>
<!-- Add the Bootstrap CSS link -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f5f5f5;
}

.container {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
	margin-top: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	font-weight: bold;
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
		<h2><%=email%></h2>
		<form action="new-result" method="post">
			<input type="hidden" name="email" value="<%=email%>">
			<div class="form-group">
				<label for="java">Java:</label> <input type="text"
					class="form-control" id="java" name="java">
			</div>
			<div class="form-group">
				<label for="javascript">JavaScript:</label> <input type="text"
					class="form-control" id="javascript" name="javascript">
			</div>
			<div class="form-group">
				<label for="python">Python:</label> <input type="text"
					class="form-control" id="python" name="python">
			</div>
			<div class="form-group">
				<label for="c">C:</label> <input type="text" class="form-control"
					id="c" name="c">
			</div>
			<div class="form-group">
				<label for="operatingsystem">Operating System:</label> <input
					type="text" class="form-control" id="operatingsystem"
					name="operatingsystem">
			</div>
			<div class="form-group">
				<label for="dbms">DBMS:</label> <input type="text"
					class="form-control" id="dbms" name="dbms">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<!-- Add the Bootstrap JS and jQuery scripts (optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
