<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
<%
String id = (String)session.getAttribute("id");

if(id == null){ %>
	<div id="login">
	<a href='<c:url value="login"/>' >login</a>   <a href='<c:url value="/member/join"/>'>join</a>
	</div>
	<%
} else {%> 
	<div id="login"> <%=id%> 님 환영합니다.
	<a href="../member/info.jsp?">  회원정보조회</a> <a href="../member/updateForm.jsp">  회원정보수정</a>   <a href="../member/logout.jsp">로그아웃</a>
	</div>
	<%
}
%>
<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src='<c:url value="/resources/images/더본.png" />' width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li style="margin: 0px 20px;"><a href="../main/main.jsp">HOME</a></li>
	<li style="margin: 0px 20px;"><a href="../company/welcome.jsp">COMPANY</a></li>
	<li style="margin: 0px 20px;"><a href="../notice/notice.jsp">CUSTOMER CENTER</a></li>
	<li style="margin: 0px 20px;"><a href="../contact/mailForm.jsp">CONTACT US</a></li>
</ul>
</nav>
</header>