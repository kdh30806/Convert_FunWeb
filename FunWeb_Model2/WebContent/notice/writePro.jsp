<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp5/writePro.jsp</h1>
<%
request.setCharacterEncoding("utf-8");

int num = 0;
String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
int readcount = 0;
Timestamp date = new Timestamp(System.currentTimeMillis());

BoardBean bb = new BoardBean();
BoardDAO bd = new  BoardDAO();

bb.setNum(num);
bb.setName(name);
bb.setSubject(subject);
bb.setContent(content);
bb.setReadcount(readcount);
bb.setDate(date);

bd.insertBoard(bb);
response.sendRedirect("notice.jsp");
%>
</body>
</html>