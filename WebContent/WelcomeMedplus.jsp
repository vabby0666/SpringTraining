<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<j:if test="${sessionScope.user != null}">
	<h1>Welcome To Your HomePage Medplus</h1>
	<button><a href="ViewEmpls?user=medplus">View Employees</a></button><br>
	<button><a href="GetEmpl">View Your Personal Details</a></button><br></hr>
	<button><a href="LogOut">LogOut</a></button>
	</j:if>
	<j:if test="${sessionScope.user == null }">
	<j:out value="not authorised"></j:out>
	</j:if>
</body>
</html>