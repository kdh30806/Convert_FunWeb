<%@page import="board.ImageBoardDAO"%>
<%@page import="board.FileBoardDAO"%>
<%@page import="board.BoardBean"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("utf-8");
String uploadPath = request.getRealPath("/upload");
int maxSize = 10*1024*1000;
MultipartRequest multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
int num = 0;
String name = multi.getParameter("name");
String pass = multi.getParameter("pass");
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");
int readcount = 0;
Timestamp date = new Timestamp(System.currentTimeMillis());
String file = multi.getFilesystemName("file");

BoardBean bb = new BoardBean();
ImageBoardDAO fbd = new ImageBoardDAO();

bb.setNum(num);
bb.setName(name);
bb.setPass(pass);
bb.setSubject(subject);
bb.setContent(content);
bb.setReadcount(readcount);
bb.setDate(date);
bb.setFile(file);

fbd.insertBoard(bb);
response.sendRedirect("imageBoardList.jsp");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>