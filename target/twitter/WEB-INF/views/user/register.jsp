<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style type="text/css">
.error {
  background-color: red;
  color: white;
}
</style>
</head>
<body>
  <f:form action="register" method="post" modelAttribute="user">
    <div>
      Nazwa użytkownika: <f:input path="username"/><f:errors path="username" cssClass="error"/>
    </div>
    <div>
      Hasło: <f:password path="password"/><f:errors path="password" cssClass="error"/>
    </div>
    <div>
      E-mail: <f:input type="email" path="email" /><f:errors path="email" cssClass="error"/>
    </div>
    <div>
      <input type="submit" value="Zarejestruj się"/>
    </div>
  </f:form>
</body>
</html>