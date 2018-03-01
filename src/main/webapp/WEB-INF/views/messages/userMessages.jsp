<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.notRead {
	font-weight: bold;
}

.read {
	font-weight: normal;
}
</style>
</head>
<body>
	<a href='<c:url value="/"/>'>HOME PAGE</a>
	<div>
		You are logged as <a href='<c:url value="/user/userPage/${user.id}"/>'>${user.username}</a>
	</div>
	<h3>Received messages</h3>

	<c:forEach items="${recievedMessages}" var="recievedMessage">
		<div class="${recievedMessage.notReadYet ? 'notRead' : 'read'}">${recievedMessage.text}
		<br/>
			Message from: ${recievedMessage.sender.username} Send: ${recievedMessage.created}
			<a href='<c:url value="/messages/messageDetails/${recievedMessage.id}"/>'> Details</a>
		</div>
	</c:forEach>

	<h3>Send messages</h3>
	<table>
		<c:forEach items="${sendMessages}" var="sendMessage">
			<tr>
				<td>${sendMessage.text}</td>
			</tr>
			<tr>
				<td>Message to: ${sendMessage.receiver.username}</td>
				<td>Send: ${sendMessage.created}</td>
				<td><a
					href='<c:url value="/messages/messageDetails/${sendMessage.id}"/>'>Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>