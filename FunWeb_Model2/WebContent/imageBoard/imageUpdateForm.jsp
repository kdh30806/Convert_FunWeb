<%@page import="board.ImageBoardDAO"%>
<%@page import="board.FileBoardDAO"%>
<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function reset() {
	location.href="fcontent.jsp";
}
</script>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<%
int num = Integer.parseInt(request.getParameter("num"));
String id = (String)session.getAttribute("id");
ImageBoardDAO ibd = new ImageBoardDAO();
BoardBean bb = ibd.getBoard(num);
%>
<body>
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
<h1>Image</h1>
<form action="imageUpdatePro.jsp" method="get" enctype="multipart/form-data">
<table border="1" id="notice">
<tr><th></th><th></th></tr>
<tr><td>작성자</td><td><input type= "text"  name="name" value="<%=id%>" readonly></td></tr>
<tr><td>제목</td><td><input type= "text"  name="subject" value="<%=bb.getSubject()%>"></td></tr>
<tr><td>내용</td><td><textarea rows="10" cols="50" name="content"><%=bb.getContent()%></textarea></td></tr>
<tr><td>파일명</td><td><input type= "file"  name="file" id="file"></td></tr>
</table>
<div id="table_search">
<input type="hidden" name="num" value="<%=bb.getNum()%>">
<input type="submit" value="글수정" class="btn"><a href="imageContent.jsp?num=<%=bb.getNum()%>"><input type="button" value="취소" class="btn"></a>
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