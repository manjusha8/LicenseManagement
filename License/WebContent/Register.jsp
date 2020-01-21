<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
   
<!DOCTYPE html>
<html>
<head>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"
	type="text/javascript">
	
</script>
<script src="RegisterAjax.js"></script>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to registration form</h1>
<form action = "Register" method = "POST">
<p>FirstName : </p>
<input type = "text" name = "fname">
<p>LirstName : </p>
<input type = "text" name = "lname">
<p>email :</p>
<input type = "email" name = "email" id = "email">
<span id = "msg" style = "color:red"></span>
	
<p>password</p>
<input type = "password" name = "password">
<input type ="submit" value = "register">

<%--<%! String msg = null; %>
<% msg = (String) request.getAttribute("msg");
			 if(msg != null){
		--%>

<%--<%} --%>

</form>
</body>
</html>