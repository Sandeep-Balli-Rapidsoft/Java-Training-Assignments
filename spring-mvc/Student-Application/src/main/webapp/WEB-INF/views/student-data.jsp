<%@page import="com.springmvc.entities.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.springmvc.entities.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>

	<%
	List<Result> resultList = (List<Result>) request.getAttribute("list");
	if (resultList == null || resultList.isEmpty()) {
	%>
	<h1>No Results Found</h1>
	<%
	} else {
	%>
	<table border="1">
		<tr>
			<th>Subject</th>
			<th>Marks</th>
			<th>Status</th>
		</tr>
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
	</table>
	<%
	}
	%>

</body>
</html>
