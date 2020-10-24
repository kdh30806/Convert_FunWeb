<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board/updateForm.jsp</h1>
<form action='<c:url value="/board/update"/>' method="post">
<input type="hidden" name="num" value="${bb.num }">
<table border="1">
<tr><td>글쓴이</td><td><input type="text" name="name" value="${bb.name }"></td></tr>
<tr><td>비밀번호</td><td><input type="password" name="pass"></td></tr>
<tr><td>제목</td><td><input type="text" name="subject" value="${bb.subject}"></td></tr>
<tr><td>내용</td>
<td><textarea rows="10" cols="20" name="content">${bb.content}</textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="글수정"></td></tr>
</table>
</form>	

</body>
</html>