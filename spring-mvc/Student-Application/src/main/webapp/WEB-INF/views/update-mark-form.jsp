<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.springmvc.service.ResultService"%>
<%@page import="com.springmvc.entities.Result"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Mark</title>
</head>
<body>

	<%
	ResultService resultService = new ResultService();

	String email = (String) request.getAttribute("email");

	List<Result> list = (List) request.getAttribute("list");
	List<Result> studentResult = new ArrayList<>();

	for (Result result : list) {
		try {
			if (result.getIsRecheck()) {
		studentResult.add(result);
			}
		} catch (NullPointerException e) {

		}

	}
	%>

	<h1>Update Mark</h1>
	<form action="update-mark-process" method="post">
		  <input type="hidden" name="email" value="<%=email%>">
		<table border="1">
			<tr>
				<th>Student Email</th>
				<th>Student Name</th>
				<th>Subject</th>
				<th>Mark</th>
			</tr>
			<%
			for (Result result : studentResult) {
			%>
			<tr>
				<td><%=result.getStudent().getStudent_email()%></td>
				<td><%=result.getStudent().getStudent_name()%></td>
				<td><%=result.getSubject().getSubject_name()%></td>
				<td><input type="text" name="marks"
					value="<%=result.getMark()%>"></td>
				<input type="hidden" name="subjects"
					value="<%=result.getSubject().getSubject_name()%>">
				
			</tr>
			<%
			}
			%>
		</table>
		<input type="submit" value="Update Marks">
	</form>


</body>
</html>
