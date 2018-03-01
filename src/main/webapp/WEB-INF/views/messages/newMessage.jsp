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
		You are logged as <a href='<c:url value="/user/userPage/${user.id}"/>'>${user.username}</a>
	</div>

	<f:form action="" method="post" modelAttribute="newMessage">
		<div>
			Send message to: ${sendTo.username}. <br />
			<f:textarea path="text" rows="3" cols="30" />
		</div>
		<div>
			<input type="submit" value="Send" />
		</div>
	</f:form>
</body>
</html>