<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
	<j:if test="${sessionScope.user != null and sessionScope.user == 'admin'}">
	<h1>Welcome To Your HomePage Admin</h1>
	<button><a href="ViewEmpls?user=admin">View Employees</a></button><br>
	<button><a href="AddEmployee.jsp">Add Employee</a></button><br></hr>
	<button><a href="LogOut" >LogOut</a></button>
	</j:if>
	<j:if test="${sessionScope.user == null or sessionScope.user != 'admin'}">
	<j:out value="not authorised"></j:out>
	</j:if>
</body>
</html>