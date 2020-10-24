<%@page import="board.ImageBoardDAO"%>
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
int num = Integer.parseInt(request.getParameter("num"));
ImageBoardDAO ibd = new ImageBoardDAO();
out.println(num);
ibd.imageRecommned(num);
%>
<script type="text/javascript">
location.href="imageContent.jsp?num=<%=num%>";
</script>
</body>
</html>