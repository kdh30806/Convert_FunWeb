
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="mb" items="${memberList}">
<table border="1">
	<tr>
	<td> 아이디 : ${mb.id }</td>
	<td> 비밀번호 : ${mb.pass }</td>
	<td> 이름  :${mb.name } </td>
	<td> 가입날짜 : ${mb.reg_date } </td>
	</tr>
</table>
</c:forEach>


</body>
</html>