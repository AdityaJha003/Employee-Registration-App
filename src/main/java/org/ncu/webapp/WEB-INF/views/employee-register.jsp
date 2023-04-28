<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Input Form</title>
</head>
<body>
<div align="center">

		<h2 align="center">Employee Input Form</h2>
		<br>
		<hr>
		<div align="center">
		<form:form action="process" method="post" modelAttribute="employees">

			<label for="id">Employee ID</label>
			<form:input type="text" path="empId" />
			<br>
			<br>

			<label for="name">Employee Name</label>
			<form:input type="text" path="empName" />
			<br>
			<br>
			
			<label for="salary">Employee Salary</label>
			<form:input type="text" path="empSalary" />
			<br>
			<br>

			<label for="address">Employee Address</label>
			<br>
			<form:textarea path="empAddress" rows="5" cols="30" />
			<br>
			<br>

			<input type="submit" value="submit" />

		</form:form>
		</div>
		<hr>

	</div>
</body>
</html>