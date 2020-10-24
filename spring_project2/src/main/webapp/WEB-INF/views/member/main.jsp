<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
<%
String id = (String)session.getAttribute("id");
%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
${sessionScope.id} 님 로그인 하셨습니다.

<c:if test="${empty sessionScope.id}">
	<c:redirect url="./login"/>
</c:if>

<c:if test="${! empty sessionScope.id}">
	<c:if test="${sessionScope.id eq 'admin'}">
		<a href="./list">회원 목록</a>
	</c:if>
</c:if>

<a href="<c:url value='/member/info'/>">회원정보조회</a>
<a href="<c:url value='/member/update'/>">회원정보수정</a>
<a href="<c:url value='/member/delete'/>">회원정보삭제</a>
<a href="<c:url value='/member/logout'/>">로그아웃</a>


<%-- <c:forEach var="mb" items="${memberList}"> --%>
<%-- 	${mb.id },${mb.pass },${mb.name } --%>
<%-- </c:forEach> --%>
<%-- <%-- <img src='<c:url value="/resource/..."/>'> 이미지 넣는 방법 --%>

</body>
</html>




