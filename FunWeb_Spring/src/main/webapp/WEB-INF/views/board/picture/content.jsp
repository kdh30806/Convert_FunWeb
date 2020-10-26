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
<script type="text/javascript">
</script>
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
<h1>Image</h1>
<form method="post" enctype="multipart/form-data">
<table border="1" id="notice">
<tr><th></th><th></th><th></th><th></th><th></th><th></th></tr>
	<tr><td>글번호</td><td><%=bb.getNum()%></td><td>조회수</td><td><%=bb.getReadcount()%></td><td>추천수</td><td><%=bb.getRecommend()%></td></tr>
	<tr><td>글쓴이</td><td><%=bb.getName()%></td><td>작성일</td><td colspan="3"><%=bb.getDate()%></td></tr>
	<tr><td>글제목</td><td colspan ="5"><%=bb.getSubject() %></td></tr>
	<tr><td>글내용</td><td colspan="5"><%=bb.getContent()%></td></tr>
	<tr><td>파일</td><td colspan="5"> <img src="../upload/<%=bb.getFile()%>" width="300" height="300"></td></tr>
	</table>
	<button type="button" class="rbtn" onclick="location.href='imageRecommendPro.jsp?num=<%=bb.getNum()%>'"><img src="../images/따봉2.jpg" width="80px" height="80px" ></button>
<div id="table_search">
<input type="button" value="글목록" onclick="location.href='imageBoardList.jsp'" class="btn">
<%if(id.equals(bb.getName())){%>
<input type="button" value="글수정" onclick="location.href='imageUpdateForm.jsp?num=<%=bb.getNum()%>'" class="btn">
<input type="button" value="글삭제" onclick="location.href='imageDeletePro.jsp?num=<%=bb.getNum()%>'" class="btn">
<%
}
%>
</div>
</form>
<div class="clear"></div>
<hr>
<h2>Comment</h2>
<form action="CommentPro.jsp" method="get">
<input type= "hidden"  name="name" value="<%=id%>">
<input type= "hidden"  name="ref" value="<%=bb.getNum()%>">
<textarea rows="3" cols="50" name="content" ></textarea><input type="submit" value="댓글등록" class="btn">
</form>
<%
for(int i = 0 ; i < commentList.size() ; i++){
	CommentBean cb = commentList.get(i);
%>
<hr>
<table>
<tr><td><b><%=cb.getName()%></b></td></tr>
<tr><td colspan="3"><%=cb.getContent()%></td></tr>
<tr><td><%=cb.getDate()%></td></tr>
</table>

<%
	}
%>
</article>

<div class="clear"></div>
<article>
<div id="page_control">
<a href="#">Prev</a>
<%for (int i = startPage ; i <= endPage ; i++){ %>
	<a href="imageContent.jsp?num=<%=ref%>&pageNum=<%=i%>"><%=i%></a>
	<%
}
%>
<a href="#">Next</a>
</div>
</article>

<div class="clear"></div>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>