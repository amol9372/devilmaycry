<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Profile</title>
</head>

<body>

	<jsp:include page="index.jsp" />
	<br>

	    <h1>Employee Personal Information</h1>
   <br>	
   <form method="post" action="/Employee/spring/register">
   <div>
      <table>
         <tr>
            <td>UserID</td>
            <td><input type="text" name="userid" id="userid" name="${employee.userid}" readonly/></td>     
         </tr>
         <tr>
            <td>First Name</td>
            <td><input type="text" name="fname" id="fname" name="${employee.fname}" readonly/></td>
         </tr>
         <tr>
            <td>Last Name</td>
            <td><input type="text" name="lname" id="lname" name="${employee.lname}" readonly/></td>
         </tr>
         <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email" name="${employee.email}" readonly/></td>
         </tr>
         <tr>
            <td>Secondary Email</td>
            <td><input type="text" name="secondaryEmail" id="secondaryEmail" name="${employee.secondaryEmail}" readonly/></td>
         </tr>
         <tr>
            <td>Mobile</td>
            <td><input type="text" name="mobile" id="mobile" name="${employee.mobile}" readonly/></td>
         </tr>
         <tr>
          <td><input type="submit" value="Login" disabled="disabled"/></td>
         </tr>                  
      </table> 
   </div>
   </form>

</body>
</html>