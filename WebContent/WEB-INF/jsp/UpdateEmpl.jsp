<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="updateempl" commandName="employee" method="post">
		code <s:input path="empcode"  readonly="true"/>
		<s:errors path="empcode" cssClass="error"></s:errors><br>
		name <s:input path="empname" />
		<s:errors path="empname" cssClass="error"></s:errors><br>
		salary <s:input path="salary" />
		<s:errors path="salary" cssClass="error"></s:errors><br>
		job <s:input path="job" /><br>
		dob(dd-mm-yyyy) <s:input path="dateOfBirth" /><br>
		<input type="submit">
	</s:form>

</body>
</html>