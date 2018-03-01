<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='<c:url value="/"/>'>STRONA GŁÓWNA</a>
<h2>User ${user.username} </h2>
<h4><a href='<c:url value="/messages/send/${user.id}"/>'>Send message</a></h4>
<h4>User tweets</h4>
	<table>
		<tr>
			<th>Id</th>
			<th>Date</th>
			<th>Text</th>
			<th>Details</th>
		</tr>
		<c:forEach items="${tweets}" var="tweet">
			<tr>
				<td>${tweet.id}</td>
				<td>${tweet.created}</td>
				<td>${tweet.text}</td>
				<td><a href='<c:url value="/tweet/${tweet.id}"/>'>Tweet details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>