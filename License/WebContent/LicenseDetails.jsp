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
<script src="UpdateAjax.js"></script>
<script src="AddDetails.js"></script>
<script src="ModifyDetails.js"></script>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		welcome to license management system :
		<%=request.getAttribute("username")%>

	</h1>
	
	
	<a href="PasswordServlet"><button>change password</button></a>
	<button id = "add" <%= request.getAttribute("addButton") %>>add details</button>
	<button id = "Update" <%= request.getAttribute("modifyButton") %>>modify details</button>
	<button>renew license</button>
	<a href="ViewDetails"><button>view details</button></a>
	<a href="LogOut"><button>Log Out</button></a>
	

	<%--<%!String details = null;%>
	<%
		details = (String) request.getAttribute("details");
		if (details != null) {
	--%>
	<form method="POST" action="LicenseId"  id = "addDetails" style = "display:none">
		<h1>add details</h1>
		<p>License Type</p>
		<select name="item"  id="item">
			<option value="two-wheeler-with-gear">two-wheeler with gear</option>
			<option value="two-wheeler-without-gear">two-wheeler without gear</option>
			<option value="four-wheeler-with-gear">four-wheeler with gear</option>
			<option value="four-wheeler-without-gear">four-wheeler without gear</option>
		</select>

		<p>Address</p>
		<input type="text" name="address">

		<p>Contact number</p>
		<input type="text" name="contact" maxlength="10">

		<p>Date of Birth</p>
		<input type="date" name="dob" placeholder="yyyy-mm-dd">

		<p>Blood Group</p>
		<input type="text" name="bloodGroup" required="required">

		<p>Place</p>
		<input type="text" name="place">

		<p>Father's Name</p>
		<input type="text" name="fatherName"  id = "fatherName">

		<p>Issue Date</p>
		<input type="date" name="idate" placeholder="yyyy-mm-dd"  id = "issueDate">

		<p>Expiry Date</p>
		<input type="date" name="edate" placeholder="yyyy-mm-dd" id = "expiryDate"> <input
			type="submit" value="submit">

	</form>


	<%--<%
		}
	--%>





	<form method="POST" id = "modify" action = " UpdateDetails " style = "display:none">
	
			<h1>modify details</h1>
	
	
		<p>License Type</p>
		<select name="item" disabled id = "licenseType_disable">
			<option value="two-wheeler-with-gear">two-wheeler with gear</option>
			<option value="two-wheeler-without-gear">two-wheeler without gear</option>
			<option value="four-wheeler-with-gear">four-wheeler with gear</option>
			<option value="four-wheeler-without-gear">four-wheeler without gear</option>
		</select>

		<p>Address</p>
		<input type="text" name="address" id = "address_show">

		<p>Contact number</p>
		<input type="text" name="contact" maxlength="10" id = "contactNo_show">

		<p>Date of Birth</p>
		<input type="date" name="dob" placeholder="yyyy-mm-dd" id = "dob_show">

		<p>Blood Group</p>
		<input type="text" name="boodGroup" id = "bloodGroup_show">

		<p>Place</p>
		<input type="text" name="place" id = "place_show">

		<p>Father's Name</p>
		<input type="text" name="fatherName" disabled id = "fatherName_disable">

		<p>Issue Date</p>
		<input type="date" name="idate" placeholder="yyyy-mm-dd" disabled id = "issueDtae_disable">

		<p>Expiry Date</p>
		<input type="date" name="edate" placeholder="yyyy-mm-dd" disabled disabled id = "expiryDtae_disable">
		<input type="submit" value="submit">

	</form>

















	<%!String password = null;%>
	
	<%
		password = (String) request.getAttribute("password");
		if (password != null) {
			
			System.out.println("change password : "+password);
			
	%>
	
	
	<form action="UpdatePassword" method="POST">
	
			<h1>change password</h1>
	
	
		<p>email :</p>
		<input type="text" name="email">
		<p>old password :</p>
		<input type="password" name="password">
		<p>new password :</p>
		<input type="password" name="NewPassword"> <input
			type="submit" value="submit">
	</form>

	<%
		}
	%>
	
	<%!String message = null;%>
	<%
		message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div style="display: block; color: red" id = "message"><%=request.getAttribute("message")%></div>
	<%
		}
	%>
	
	<%!String licenseId = null;%>
	<%
	licenseId = (String) request.getAttribute("licenseId");
		if (licenseId != null) {
	%>

	<div style="display: block; color: red"><%=request.getAttribute("licenseId")%></div>
	<%
		}
	%>

</html>