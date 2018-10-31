<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All Employees</title>
</head>
<body>
<j:if test="${sessionScope.user != null }">
<j:set var="user" value="${user}"/>
	<table border="2" align="center">
	<tr>
		<th>EMPLCODE</th>
		<th>EMPLNAME</th>
		<th>JOB</th>
		<th>SALARY</th>
		<th>DATE OF BIRTH</th>
	</tr>
	
	<j:forEach var="emp" items="${empls}">
		<tr>
			<td><j:out value="${emp.empcode}"></j:out></td>
			<td><j:out value="${emp.empname}"></j:out></td>
			<td><j:out value="${emp.job}"></j:out></td>
			<td><j:out value="${emp.salary}"></j:out></td>
			<td><j:out value="${emp.dateOfBirth}"></j:out></td>
			<j:if test= "${user eq 'admin'}">      
			<td><a href="UpdateEmpl?code=${emp.empcode}&user=${user}">Update</a></td>
			<td><a href="DelEmpl?code=${emp.empcode}&user=${user}">Delete</a></td></j:if>	
		</tr>
	</j:forEach>
	</table>
	<p align="center">
	<j:if test= "${user eq 'admin'}">
	<button><a href="WelcomeAdmin.jsp">back</a></button></j:if>
	<j:if test= "${user eq 'medplus'}">
	<button><a href="WelcomeMedplus.jsp">back</a></button></j:if>
	</p>
	</j:if>
	<j:if test="${sessionScope.user == null }">
	<j:out value="not authorised"></j:out>
	</j:if>
</body>
</html>