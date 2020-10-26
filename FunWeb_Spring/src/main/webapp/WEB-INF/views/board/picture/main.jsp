<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css" />' rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../../inc/top.jsp"  />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<jsp:include page="../../inc/leftMenu.jsp"  />
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<article>
<h1>Picture</h1>
<c:forEach var="pl" items="${pictureList}">
<table id="imageBoard" style="float:left;">
	  <tr><td class="center">${pl.num }</td>
	  <tr><td><a href='<c:url value="/board/picture/content?num=${pl.num }" />'>
	          <img src='<c:url value="/resources/upload/${pl.file }"/>' width="130" height="130"></a></td></tr>
	     <tr><td class="left">${pl.subject }</td></tr>
	     <tr><td class="left">${pl.name }</td></tr>
	     <tr><td class="left">${pl.date }</td></tr>	     
</table>
</c:forEach>
</article>
<article>
<div id="table_search">
<input type="text" name="search" class="input_box">
<input type="button" value="검색" class="btn"> 
<c:if test="${! empty sessionScope.id }">
	<a href='<c:url value="/board/picture/write"/>'><input type="button" value="글쓰기" class="btn"></a>
</c:if>
</div>
</article>
<div class="clear"></div>
<article>
<div id="page_control">
<c:if test="${pb.startPage > pb.pageBlock }">
	<a href='<c:url value="/board/picture/main?pageNum=${pb.startPage-pb.pageBlock}"/>'>Prev</a>
</c:if>
<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage}" step="1">
	<a href='<c:url value="/board/picture/main?pageNum=${i}"/>'>${i}</a>
</c:forEach>
<c:if test="${pb.endPage < pb.pageBlock }">
	<a href='<c:url value="/board/picture/main?pageNum=${pb.startPage+pb.pageBlock}"/>'>Next</a>
</c:if>
</div>
</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>