<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<j:set var = "row" value="${success}"/>

	<j:if test= "${row > 0}">
	<h3>Inserted Sucessfully</h3></j:if>
	<j:if test="rows < 1"><h3>Not Inserted</h3></j:if>
	<button><a href="WelcomeAdmin.jsp">back</a></button>

</body>
</html>