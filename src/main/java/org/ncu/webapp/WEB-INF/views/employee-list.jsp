<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<h1 align="center">Employee Dashboard</h1>
	<i>Employees data coming soon...</i>

	<br>
	<div align="center">

		<table border=1>
			<thead>
				<tr>
					<td>Employee Id</td>
					<td>Employee Name</td>
					<td>Employee Salary</td>
					<td>Employee Address</td>
					<td>Operation</td>
				</tr>
			</thead>


			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.empId }</td>
					<td>${employee.empName }</td>
					<td>${employee.empSalary }</td>
					<td>${employee.empAddress }</td>
					<td><a href="updateForm?empId=${employee.empId}">Edit</a>
						<a href="deleteStudent?empId=${employee.empId}"
						onclick="if (!(confirm('Do you really want to delete this employee record?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
		
		<br>
		<form:form action="batchProcess" method="POST">
			<input type="submit" value="save all"/>
		</form:form>
		
	</div>
</body>
</html>