<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
<c:choose>
	<c:when test="${empty sessionScope.id}">
		<div id="login">
		<a href='<c:url value="/member/login"/>' >login</a>   <a href='<c:url value="/member/join"/>'>join</a>
		</div>
	</c:when>
	
	<c:otherwise>
		<div id="login"> ${sessionScope.id} 님 환영합니다.
		<a href='<c:url value="/member/info" />'>  회원정보조회</a> <a href='<c:url value="/member/update" />'>  회원정보수정</a>   <a href='<c:url value="/member/logout" />'>로그아웃</a>
		</div>
	</c:otherwise>
</c:choose>	
<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src='<c:url value="/resources/images/더본.png" />' width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li style="margin: 0px 20px;"><a href='<c:url value="/main"/>'>HOME</a></li>
	<li style="margin: 0px 20px;"><a href='<c:url value="/company"/>'>COMPANY</a></li>
	<li style="margin: 0px 20px;"><a href='<c:url value="/board/notice/main"/>'>BOARD</a></li>
	<li style="margin: 0px 20px;"><a href='<c:url value="/mail"/>'>CONTACT US</a></li>
</ul>
</nav>
</header>