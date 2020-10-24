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
<c:if test="${empty sessionScope.id}">
	<c:redirect url="member/login"></c:redirect>
</c:if>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp"  />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<article>
<h1>Mail</h1>

<form action="mail" method="post">
<table border="1" id="notice">
<tr><th></th><th></th></tr>
<tr><td>보내는 사람 메일</td><td><input type= "text"  name="sender" value="${sessionScope.id}" readonly></td></tr>
<tr><td>받는 사람 메일</td><td><input type= "text"  name="receiver"></td></tr>
<tr><td >제목</td><td><input type= "text"  name="subject"></td></tr>
<tr><td>내용</td><td><textarea rows="10" cols="50" name="content" ></textarea></td></tr>
</table>
<div id="table_search">
<input type="submit" value="메일 보내기" class="btn"><input type="reset" value="취소" class="btn">
</div>
</form>
</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>