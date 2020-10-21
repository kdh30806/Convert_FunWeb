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
<link href='<c:url value="/resources/css/front.css" />' rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="inc/top.jsp"/>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src='<c:url value="/resources/images/요리비책.jpg" />' width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">

	<div id="security">
<table id="imageBoard" style="margin-left: 70px;">
	  <tr><td><a href="#">
	          <img src="../upload/" width="150" height="130"></a></td></tr>
</table>
	</div>

</div>
<div class="clear"></div>

<div id="news_notice">
<h3 style="color: #827b00">최근 핫 레시피</h3>
<table>
<tr><td id="contxt"><a href="#">제목</a></td>
    <td>날짜</td><td>조회수</td></tr>

</table>
</div>

<div id="news_notice">
<h3 class="brown">공지사항</h3>
<table>

<tr><td id="contxt"><a href="#">제목</a></td>
    <td>날짜</td></tr>

</table>
</div>
</article>
<!-- 메인 콘텐츠 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<jsp:include page="inc/bottom.jsp"  />
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>