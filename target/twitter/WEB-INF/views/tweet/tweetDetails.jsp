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
	<h2>Tweet details</h2>
	<div>
		<b>Id</b> <br /> ${tweet.id}
	</div>
	<div>
		<b>Created</b> <br /> ${tweet.created}
	</div>
	<div>
		<b>User</b> <br /> ${tweet.user.username}
	</div>
	<div>
		<b>Text</b> <br /> ${tweet.text}
	</div>
	<h5>Comments</h5>
	<table>
		<c:forEach items="${comments}" var="comment">
			<tr>
				<td>${comment.text}</td>
			</tr>
			<tr>
				<td>${comment.user.username}</td>
			</tr>
		</c:forEach>
		
	</table>
	<f:form action="" method="post" modelAttribute="newComment">
		<div>
			New Comment: <br />
			<f:textarea path="text" rows="3" cols="30" />
		</div>
		<div>
			<input type="submit" value="Add comment" />
		</div>
	</f:form>

</body>
</html>