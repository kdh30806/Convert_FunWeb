<%@page import="java.sql.Timestamp"%>
<%@page import="board.CommentBean"%>
<%@page import="board.NoticeCommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int num = 0;
int ref = Integer.parseInt(request.getParameter("ref"));
String name = request.getParameter("name");
String content = request.getParameter("content");
Timestamp date = new Timestamp(System.currentTimeMillis());

NoticeCommentDAO ncd = new NoticeCommentDAO();
CommentBean cb = new CommentBean();

cb.setNum(num);
cb.setName(name);
cb.setContent(content);
cb.setDate(date);
cb.setRef(ref);

ncd.insertComment(cb);
response.sendRedirect("content.jsp?num="+ ref);
%>
</body>
</html>