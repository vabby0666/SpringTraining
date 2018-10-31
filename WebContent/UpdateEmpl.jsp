<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
</head>
<body>
<j:set var="emp" value="${employee}"></j:set>
<j:set var="user" value="${user}"></j:set>

	<j:if test="${sessionScope.user != null}">
<form action="UpdateEmpl" method="post">
		<a style="padding-left:75px"><input type="hidden" style="width:41px" name="user" value="${user}" readonly="readonly"><b>Update Page</b></a><br><br>
		Employee Code <input type="text" name="empcode" value="${emp.empcode}" readonly="readonly"><br>
		Employee Name <input type="text" name="empname" value="${emp.empname}"><br>
		Employee Job <input type="text" name="job" value="${emp.job}"><br>
		Employee Salary <input type="text" name="salary" value="${emp.salary}"><br>
		Employee Date Of Birth <input type="date" name="dateofbirth" value="${emp.dateOfBirth}"><br>
		<input type="submit">
	</form>
	
	</j:if>
	<j:if test="${sessionScope.user == null }">
	<j:out value="not authorised"></j:out>
	</j:if>
</body>
</html>