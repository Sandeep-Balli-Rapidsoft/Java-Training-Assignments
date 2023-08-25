<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Email Verification</title>
<!-- Add the Bootstrap CSS link -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2>Student Email Verification</h2>
		<form action="verify-for-result" method="post">
			<div class="form-group">
				<label for="email">Student Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
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
