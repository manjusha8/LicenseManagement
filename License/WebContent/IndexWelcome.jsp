<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome to license management system</h1>
	<form action="Register.jsp">
		<input type="submit" value="register">
	</form>
	<form method="POST" action="LicenseCookieServlet">
		<input type="submit" value="login">
	</form>
</body>
</html>