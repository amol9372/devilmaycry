<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
	function userValidator() {
		var regex=/^[0-9]+$/;
		
		var userid = document.getElementById("userid").value;
		// alert(userid);
		if(!userid.match(regex)){
			document.getElementById("userError").innerHTML = "Please enter Numeric value !!!!";
			alert("dosent match pattern");
			return false;
		}
		return true;	
	}
</script>
</head>
<body>
   <h1>Login Page</h1>
   <br>
   <form method="post" action="/Employee/spring/login">
   <div>
      <table>
         <tr>
            <td>UserID</td>
            <td><input type="text" name="userid" id="userid"></td>
            <td><label class="userError"></label></td>     
         </tr>
         <tr>
            <td>Password</td>
            <td><input type="password" name="password_hash" id="password"></td>
         </tr>
         <tr>
          <td><input type="submit" value="Login" onclick="return userValidator();"></td>
         </tr>
         
      </table> 
   </div>
   <br>
     ${invalid}
   </form>
</body>
</html>