<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
	<j:if test="${sessionScope.user != null and sessionScope.user == 'admin' }">
	<form action="AddEmployee">
		Employee Code <input type="text" name="empcode"><br>
		Employee Name <input type="text" name="empname"><br>
		Employee Job <input type="text" name="job"><br>
		Employee Salary <input type="text" name="salary"><br>
		Employee Date Of Birth <input type="date" name="dateofbirth"><br>
		<input type="submit">
	</form>
	</j:if>
	<j:if test="${sessionScope.user == null}">
	<j:out value="not authorised"></j:out>
	</j:if>
</body>
</html>