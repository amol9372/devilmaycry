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
            <td><input type="text" name="userId" id="userid" value="${employee.userId}" readonly/></td>     
         </tr>
         <tr>
            <td>First Name</td>
            <td><input type="text" name="fname" id="fname" value="${employee.fname}" readonly/></td>
         </tr>
         <tr>
            <td>Last Name</td>
            <td><input type="text" name="lname" id="lname" value="${employee.lname}" readonly/></td>
         </tr>
         <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email" value="${employee.email}" readonly/></td>
         </tr>
         <tr>
            <td>Secondary Email</td>
            <td><input type="text" name="secondaryEmail" id="secondaryEmail" value="${employee.email_official}" readonly/></td>
         </tr>
         <tr>
            <td>Street</td>
            <td><input type="text" name="street" id="street" value="${address.street}" readonly/></td>
         </tr>
         <tr>
            <td>City</td>
            <td><input type="text" name="city" id="city" value="${address.city}" readonly/></td>
         </tr>
         <tr>
            <td>ZIP</td>
            <td><input type="text" name="zip" id="zip" value="${address.zip}" readonly/></td>
         </tr>
         <tr>
            <td>County</td>
            <td><input type="text" name="county" id="county" value="${address.county}" readonly/></td>
         </tr>
         <tr>
            <td>State</td>
            <td><input type="text" name="state" id="state" value="${address.state}" readonly/></td>
         </tr>
         <tr>
          <td><input type="submit" value="Edit" disabled="disabled"/></td>
         </tr>                  
      </table> 
   </div>
   </form>

</body>
</html>