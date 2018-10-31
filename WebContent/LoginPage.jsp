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
   <form action="HomePage">
   <br><a><b>Enter ID and Password to Login</b></a><br><br>
    <a style="padding-left:17px">User ID:<input type="text" name="user" required="required"></a><br>
    Password:<input type="password" name="pass" required="required"><br>
    <a style="padding-left:90px"><input type="submit" value="login"/></a>
   </form>

</body>
</html>