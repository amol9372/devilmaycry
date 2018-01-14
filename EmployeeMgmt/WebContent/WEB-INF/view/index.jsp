<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
<style>
ul {
	list-style-type: disc;
	margin: 0;
	padding: 0;
	overflow: auto;
	background-color: #343;
}

li {
	float: left;
}

li a {
	display: inline-table;
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
		<li><a href="/Employee/spring/contacts">Contact Us</a></li>
		<li class = "dropdown">
			
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Hi, ${loginModel.userid} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="listbox">
					<li><a href="/Employee/spring/profile.jsp?empid=${loginModel.userid}">Profile</a></li>
					<li><a href="/Employee/spring/logout">Logout</a></li>
				</ul>
			
		</li>

		<li><a href="/Employee/spring/logout">Logout</a></li>
	</ul>
</body>
</html>