<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

div {
    width: 300px;
    height: 300px;
    position: absolute;
    top:0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
	function userValidator() {
		
		return true;	
	}
</script>
</head>
<body>
   
   <br>
   <form method="post" action="${pageContext.request.contextPath}/webapi/powerbi/login">
   <div>
   <h1>Login Page</h1>
      <table>
         <tr>
            <td>UserID</td>
            <td><input type="text" name="userid" placeholder="Enter Username" id="userid"></td>
            <td><label id="userError"></label></td>     
         </tr>
         <tr>
            <td>Password</td>
            <td><input type="password" name="passw" placeholder="Enter password" id="password"></td>
         </tr>
         <tr>
          <td><button type="submit">Login</button></td>
         </tr>
         
      </table> 
      <br>
     ${invalid}
   </div>
   
   </form>
</body>
</html>