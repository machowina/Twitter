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
	<a href='<c:url value="/"/>'>HOME PAGE</a>
	<div>
		<a href='<c:url value="/messages/${user.id}"/>'>Your messages</a>
	</div>

	<h2>Message details</h2>
	<div>
		<b>Id</b> <br /> ${message.id}
	</div>
	<div>
		<b>Created</b> <br /> ${message.created}
	</div>
	<div>
		<b>Text</b> <br /> ${message.text}
	</div>
	<div>
		<b>Message from: </b> <br /> ${message.sender.username}
	</div>
	<div>
		<b>Message to: </b> <br /> ${message.receiver.username}
	</div>
	

</body>
</html>