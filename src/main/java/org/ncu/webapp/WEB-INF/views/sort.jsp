<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="sorta" method="post" modelAttribute="employee">
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
				</tr>
			</thead>


			<c:forEach var="employee" items="${employee}">
				<tr>
					<td>${employee.empId }</td>
					<td>${employee.empName }</td>
					<td>${employee.empSalary }</td>
					<td>${employee.empAddress }</td>
					
				</tr>
			</c:forEach>

		</table>
		
		<br>
		
		
	</div></form:form>
</body>
</html>