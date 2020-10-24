<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
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
<h1>jsp5/updatePro.jsp</h1>
<%
request.setCharacterEncoding("utf-8");

String id = (String)session.getAttribute("id");
String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
int num = Integer.parseInt(request.getParameter("num"));

BoardDAO bd = new BoardDAO();
BoardBean bb = bd.getBoard(num);

bb.setName(name);
bb.setSubject(subject);
bb.setContent(content);
bb.setNum(num);
bd.updateBoard(bb);		
%>
<script type="text/javascript">
	alert("수정 성공");
	location.href='notice.jsp';
</script>
</body>
</html>