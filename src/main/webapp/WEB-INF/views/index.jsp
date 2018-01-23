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
	<a href='<c:url value="/user/login"/>'>Zaloguj się</a>
	<a href='<c:url value="/user/register"/>'>Zarejestruj się</a>
	
	<h2>Strona główna</h2>
	<div>
		Jesteś zalogowany jako <a
			href='<c:url value="/user/userPage/${user.id}"/>'>${user.username}</a>
	</div>
	<a href='<c:url value="/user/logout"/>'>Wyloguj się</a>

	<f:form action="" method="post" modelAttribute="newTweet">

		<div>
			New tweet: <br />
			<f:textarea path="text" rows="3" cols="30" />
			<f:errors path="text" cssClass="error" />
		</div>

		<div>
			<input type="submit" value="Dodaj tweet" />
		</div>
	</f:form>

	<table>
		<tr>
			<th>Id</th>
			<th>Created</th>
			<th>User</th>
			<th>Text</th>
		</tr>
		<c:forEach items="${tweets}" var="tweet">
			<tr>
				<td>${tweet.id}</td>
				<td>${tweet.created}</td>
				<td>${tweet.user.username}</td>
				<td>${tweet.text}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>