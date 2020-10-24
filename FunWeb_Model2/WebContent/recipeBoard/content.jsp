<%@page import="board.recipeBoardDAO"%>
<%@page import="board.NoticeCommentDAO"%>
<%@page import="board.CommentBean"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<%

String id = (String)session.getAttribute("id");
if(id == null){
	id = "guest";
}
int num = Integer.parseInt(request.getParameter("num"));
int ref = num;
recipeBoardDAO rbd = new recipeBoardDAO();

rbd.updateReadcount(num);
BoardBean bb = rbd.getBoard(num);
NoticeCommentDAO ncd = new NoticeCommentDAO();

List<CommentBean> commentList = ncd.getBoardList(ref);
%>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp"  />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<jsp:include page="../inc/leftMenu.jsp"  />
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<article>
<h1>Recipe</h1>
<table border="1" id="notice">
<tr><th></th><th></th><th></th><th></th></tr>
	<tr><td>글번호</td><td><%=bb.getNum()%></td><td>조회수</td><td><%=bb.getReadcount()%></td></tr>
	<tr><td>글쓴이</td><td><%=bb.getName()%></td><td>작성일</td><td><%=bb.getDate()%></td></tr>
	<tr><td>글제목</td><td colspan ="3"><%=bb.getSubject() %></td></tr>
	<tr><td>글내용</td><td colspan="3"><%=bb.getContent()%></td></tr>
</table>
<div id="table_search">
	<input type="button" value="글목록" onclick="location.href='recipeBoardList.jsp'" class="btn">
<%if(id.equals(bb.getName())){%>
	<input type="button" value="글수정" onclick="location.href='updateForm.jsp?num=<%=bb.getNum()%>'" class="btn">
	<input type="button" value="글삭제" onclick="location.href='deletePro.jsp?num=<%=bb.getNum()%>'" class="btn">
<%	
}
%>
</div>
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
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>