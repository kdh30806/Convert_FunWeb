<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
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
<h1>Recipe</h1>
<table border="1" id="notice">
<tr><th></th><th></th><th></th><th></th></tr>
	<tr><td>num</td><td>${bb.num }</td><td>readcount</td><td>${bb.readcount }</td></tr>
	<tr><td>name</td><td>${bb.name }</td><td>date</td><td>${bb.date }</td></tr>
	<tr><td>subject</td><td colspan ="3">${bb.subject }</td></tr>
	<tr><td>content</td><td colspan="3">${bb.content }</td></tr>
</table>
<div id="table_search">
	<input type="button" value="글목록" onclick='location.href="<c:url value="/board/recipe/main"/>"' class="btn">
<c:if test="${sessionScope.id eq 'admin'}">
	<input type="button" value="글수정" onclick='location.href="<c:url value="/board/recipe/update?num=${bb.num }"/>"' class="btn">
	<input type="button" value="글삭제" onclick='location.href="<c:url value="/board/recipe/delete?num=${bb.num }"/>"'  class="btn">
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