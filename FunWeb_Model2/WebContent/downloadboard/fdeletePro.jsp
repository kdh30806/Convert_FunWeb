<%@page import="board.FileBoardDAO"%>
<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp5/deletePro.jsp</h1>
<%
request.setCharacterEncoding("utf-8");
int num = Integer.parseInt(request.getParameter("num"));
String pass = request.getParameter("pass");

FileBoardDAO bd = new FileBoardDAO();
BoardBean bb = bd.getBoard(num);
	
bd.deleteBoard(num);
%>
			
<script type="text/javascript">
	alert("삭제 성공");
	location.href='driverDownloadList.jsp';
</script>

</body>
</html>