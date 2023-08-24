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

form {
	display: flex;
	flex-direction: column;
	align-items: center;
}

label {
	display: block;
	font-weight: bold;
	margin-top: 10px;
}

.checkbox-group {
	display: flex;
	flex-wrap: wrap;
}

.checkbox-group label {
	flex-basis: 33.33%;
}

input[type="checkbox"] {
	margin-top: 5px;
	margin-bottom: 10px;
}

button {
	margin-top: 20px;
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

	<div class="container">
		<h1>Apply for recheck</h1>
		<%
		String email = (String) request.getAttribute("email");
		%>

		<div class="container">
			
			<h2>
				<%=email%>
			</h2>
			<form action="recheck-form-data" method="post">
				<input type="hidden" name="email" value="<%=email%>">
				<div class="checkbox-group">
					<label for="java"><input type="checkbox" id="java"
						name="subjects" value="Java"> Java</label> <label for="javascript"><input
						type="checkbox" id="javascript" name="subjects" value="JavaScript">
						JavaScript</label> <label for="python"><input type="checkbox"
						id="python" name="subjects" value="Python"> Python</label> <label
						for="c"><input type="checkbox" id="c" name="subjects"
						value="C"> C</label> <label for="operatingsystem"><input
						type="checkbox" id="operatingsystem" name="subjects"
						value="Operating System"> Operating System</label> <label
						for="dbms"><input type="checkbox" id="dbms"
						name="subjects" value="DBMS"> DBMS</label>
				</div>

				<button type="submit">Submit</button>
			</form>
		</div>
</body>
</html>
