<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<form modelAttribute="employee" action="./addNewEmployee" method="Post">
		<br> <label>User Name:</label> <input type="text" name="userName" id="userName"><br>
		<br> <label>Password:</label> <input type="text" name="password" id="password"><br>
		<br> <label>First Name:</label> <input type="text" name="firstName" id="firstName"><br>
		<br> <label>Last Name:</label> <input type="text" name="lastName" id="lastName"><br>
		<br> <label>Email Id:</label> <input type="text" name="emailId" id="emailId"><br>
		<br> <label>Address:</label> <input type="text" name="address" id="address"><br>
		<br> <label>Mobile Number:</label> <input type="text" name="mobileNumber" id="mobileNumber"><br>
		
		<input type="submit"  value="Register" >
		
		
	</form>
	
</body>
</html>