<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
 <form  modelAttribute="employee" action="/demoSpring/modify" method="GET">
		<br> <label>First Name:</label> <input type="text" name="firstName" id="firstName" value="${employee.getFirstName()}"><br>
		<br> <label>Last Name:</label> <input type="text" name="lastName" id="lastName" value="${employee.getLastName()}"><br>
		<br> <label>Email Id:</label> <input type="text" name="emailId" id="emailId" value="${employee.getEmailId()}"><br>
		<br> <label>Address:</label> <input type="text" name="Address" id="address" value="${employee.getAddress()}"><br>
		<br> <label>Mobile Number:</label> <input type="text" name="mobileNumber" id="mobileNumber" value="${employee.getMobileNumber()}"><br>
		<input type="hidden" name="userName" id="userName" value="${employee.getUserName()}"><br>
		<input type="hidden" name="Password" id="Password" value="${employee.getPassword()}"><br>
		
		<input type="submit"  value="Modify" > 
</form>
<!-- <input type="button"  onclick="location.href='./modify.htm'" value="Show EmployeesButton" > -->
 </body>
</html>