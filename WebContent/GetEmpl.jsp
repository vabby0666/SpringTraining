<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<j:if test="${sessionScope.user != null}">
	<table border="2" align="center">
	<tr>
		<th>EMPLCODE</th>
		<th>EMPLNAME</th>
		<th>JOB</th>
		<th>SALARY</th>
		<th>DATE OF BIRTH</th>
	</tr>
	
	
		<tr>
			<td><j:out value="${empls.empcode}"></j:out></td>
			<td><j:out value="${empls.empname}"></j:out></td>
			<td><j:out value="${empls.job}"></j:out></td>
			<td><j:out value="${empls.salary}"></j:out></td>
			<td><j:out value="${empls.dateOfBirth}"></j:out></td>
		</tr>
	</table>
	<p align="center">
	<button><a href="WelcomeMedplus.jsp">back</a></button>
	</p>
	</j:if>
	<j:if test="${sessionScope.user == null }">
	<j:out value="not authorised"></j:out>
	</j:if>
	
</body>
</html>