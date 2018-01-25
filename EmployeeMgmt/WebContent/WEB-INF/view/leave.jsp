<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave page</title>
</head>
<body>
	<jsp:include page="index.jsp" />
	<br> Count of this page : <c:out value="${count}" />
	<br> session creation time : <c:out value="${sessionCreatedTime}" />
	<br> Last accessed time : <c:out value="${lastAccessedTime}" />
	
	<h1>Employee Leave</h1>
	<br>
	<form method="post" action="/Employee/spring/applyLeave">
		<div>
			<table>
				<tr>
					<td>UserID</td>
					<td><input type="text" name="userId" id="userid"
						value="${employee.userId}" /></td>
				</tr>
				<tr>
					<td>Reason for Leave</td>
					<td><input type="text" name="reason" id="reason" /></td>
				</tr>
				<tr>
					<td>From Date</td>
					<td><input type="text" name="fromDate" id="fromDate" /></td>
				</tr>
				<tr>
					<td>To Date</td>
					<td><input type="text" name="toDate" id="toDate" /></td>
				</tr>
				<tr>
					<td>Leave Type</td>
					<td><select name="leaveType" id="leaveType"></select></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>