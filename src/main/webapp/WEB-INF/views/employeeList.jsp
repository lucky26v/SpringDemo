    
    <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>FirstName</th><th>LastName</th><th>EmailID</th><th>Address</th><th>MobileNumber</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.getFirstName()}</td>  
   <td>${emp.getLastName()}</td>  
   <td>${emp.getEmailId()}</td>
   <td>${emp.getAddress()}</td> 
   <td>${emp.getMobileNumber()}</td>  
   <td><a href="editemp/${emp.getUserName()}">Edit</a></td>  
   <td><a href="deleteemp/${emp.getUserName()}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>