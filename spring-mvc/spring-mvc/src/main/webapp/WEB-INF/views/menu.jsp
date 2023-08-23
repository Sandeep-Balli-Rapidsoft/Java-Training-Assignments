<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Grade System</title>
<style>
/* Add CSS for the grid-like structure */
.grid-container {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	/* Adjust the number of columns as needed */
	gap: 20px; /* Adjust the gap between boxes as needed */
	text-align: center;
	margin: 20px;
}

.grid-item {
	padding: 20px;
	border: 1px solid #ccc;
	background-color: #f9f9f9;
	text-decoration: none;
	color: #333;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 18px;
}
</style>
</head>
<body>

	<h2>Student Grade System!</h2>

	<div class="grid-container">
		<a href="#" class="grid-item">Add New Student</a> <a href="#"
			class="grid-item">Add Student Result</a> <a href="#"
			class="grid-item">View Student Data By Email</a> <a href="#"
			class="grid-item">View All Students</a> <a href="#" class="grid-item">Apply
			For Recheck</a> <a href="#" class="grid-item">View Recheck
			Applications</a> <a href="#" class="grid-item">Update Mark</a>
	</div>

</body>
</html>
