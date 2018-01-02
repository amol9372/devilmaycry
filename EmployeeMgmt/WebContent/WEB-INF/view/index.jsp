<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #343;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<ul>
		<li><a href="#home">Home</a></li>
		<li><a href="/Employee/spring/latestnews">Latest News</a></li>
		<li><a href="/Employee/spring/help">Help</a></li>
		<li><a href="/Employee/spring/contactus">Contact Us</a></li>
		<li><a href="/Employee/spring/profile">Hi, ${loginModel.userid}</a></li>
		<li><a href="/Employee/spring/logout">Logout</a></li>
	</ul>
</body>
</html>