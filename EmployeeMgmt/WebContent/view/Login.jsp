<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>
   <h1>Login Page</h1>
   <br>
   <form method="post" action="/Employee/spring/login">
   <div>
      <table>
         <tr>
            <td>UserID</td>
            <td><input type="text" id="username"></td>     
         </tr>
         <tr>
            <td>Password</td>
            <td><input type="password" id="password"></td>
         </tr>
         <tr>
          <td><input type="submit" value="Login"></td>
         </tr>
         
      </table> 
   </div>
   </form>
</body>
</html>