
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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
아이디 : ${mb.id}  <br>
비밀번호 : ${mb.pass } <br>
이름 :${mb.name }<br>
가입날짜 : ${mb.reg_date }<br>
<a href="./main"><input type="button" value="메인으로" ></a>
</body>
</html>