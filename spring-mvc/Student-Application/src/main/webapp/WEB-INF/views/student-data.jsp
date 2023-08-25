<%@page import="com.springmvc.entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.springmvc.entities.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Data</title>
<!-- Add the Bootstrap CSS link -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<%
		String userName = (String) request.getAttribute("name");
		String userEmail = (String) request.getAttribute("email");
		String userPercentageStr = (String) request.getAttribute("percentage");
		Double userPercentage = Double.parseDouble(userPercentageStr);

		String userGrade = (String) request.getAttribute("grade");
		List<Result> resultList = (List<Result>) request.getAttribute("list");

		if (resultList == null || resultList.isEmpty()) {
		%>
		<h1 class="text-center">No Results Found</h1>
		<%
		} else {
		%>
		<h1 class="text-center"><%=userName%>'s Student Data
		</h1>
		<p class="text-center">
			Email:
			<%=userEmail%></p>
		<p class="text-center">
			Percentage:
			<%=userPercentage%>%
		</p>
		<p class="text-center">
			Grade:
			<%=userGrade%></p>
		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th>Subject</th>
					<th>Marks</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Result result : resultList) {
					Subject subject = result.getSubject();
					Double marks = result.getMark();
					Boolean isRecheck = result.getIsRecheck();
					String status = "";

					if (isRecheck == null) {
						status = "Not Available";
					} else if (isRecheck) {
						status = "Pending";
					} else {
						status = "Updated";
					}
				%>
				<tr>
					<td><%=subject.getSubject_name()%></td>
					<td><%=marks%></td>
					<td><%=status%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
	</div>

	<!-- Add the Bootstrap JS and jQuery scripts (optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
