<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>insertForm.jsp</h1>
<form action='<c:url value="/member/insert"/>' method="post">
아이디 : <input type="text" name="id">
비밀번호 : <input type="password" name="pass">
이름 : <input type="text" name="name">
<input type="submit" value="등록">
</form>
</body>
</html>