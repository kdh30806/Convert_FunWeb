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
<h1>board/content.jsp</h1>
	<table border="1">
<tr><td>글번호</td><td>${bb.num }</td>
    <td>조회수</td><td>${bb.readcount }</td></tr>
<tr><td>글쓴이</td><td>${bb.name }</td>
    <td>작성일</td><td>${bb.date }</td></tr>
<tr><td>글제목</td><td colspan="3">${bb.subject }</td></tr>
<tr><td>파일</td>
    <td colspan="3"><a href="../upload/${bb.file }">${bb.file }</a>
    <img src="../upload/${bb.file }" width="100" height="100"/>
    </td></tr>
<tr><td>글내용</td><td colspan="3">${bb.content }</td></tr>
<tr><td colspan="4">
<input type="button" value="글수정" 
onclick="location.href='<c:url value="/board/update?num=${bb.num }"/>'">
<input type="button" value="글삭제" 
onclick="location.href='<c:url value="/board/delete?num=${bb.num }"/>'">
<input type="button" value="답글쓰기" 
onclick="location.href='<c:url value="/board/reWrite?num=${bb.num }&re_ref=${bb.re_ref }&re_lev=${bb.re_lev }&re_seq=${bb.re_seq }"/>'">
<input type="button" value="글목록" 
onclick="location.href='<c:url value="/board/list"/>'"></td></tr>
</table>
</body>
</html>





