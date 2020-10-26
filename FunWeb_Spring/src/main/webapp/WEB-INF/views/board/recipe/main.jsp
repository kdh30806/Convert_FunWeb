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
<table id="notice">
<tr><th class="tno">No.</th>
    <th class="ttitle">Title</th>
    <th class="twrite">Writer</th>
    <th class="tdate">Date</th>
    <th class="tread">Read</th></tr>
<c:forEach var="rl" items="${recipeList}">
	<tr>
		<td class="center">${rl.num}</td>
		<td class="left"><a href='<c:url value="/board/recipe/content?num=${rl.num}"/>'>${rl.subject }</a></td>
		<td class="left">${rl.name }</td>
		<td class="left">${rl.date }</td>
		<td class="center">${rl.readcount}</td></tr>
</c:forEach>
</table>
<div id="table_search">
<form action="noticeSearch.jsp" method="post">
<input type="text" name="search" class="input_box">
<input type="submit" value="검색" class="btn"> 
<c:if test="${sessionScope.id eq 'admin'}">
	<a href='<c:url value="/board/recipe/write" />'><input type="button" value="글쓰기" class="btn"></a>
</c:if>
</form>
</div>
<div class="clear"></div>
<div id="page_control">
<c:if test="${pb.startPage > pb.pageBlock }">
	<a href='<c:url value="/board/recipe/main?pageNum=${pb.startPage-pb.pageBlock}"/>'>Prev</a>
</c:if>
<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage}" step="1">
	<a href='<c:url value="/board/recipe/main?pageNum=${i}"/>'>${i}</a>
</c:forEach>
<c:if test="${pb.endPage < pb.pageBlock }">
	<a href='<c:url value="/board/recipe/main?pageNum=${pb.startPage+pb.pageBlock}"/>'>Next</a>
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