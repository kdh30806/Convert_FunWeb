<%@page import="board.ImageCommentDAO"%>
<%@page import="board.ImageBoardDAO"%>
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
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
ImageBoardDAO ibd = new ImageBoardDAO();
String id = (String)session.getAttribute("id");

// ================================================
int count = ibd.getBoardCount();
int pageSize = 4;
String pageNum = request.getParameter("pageNum");
if(pageNum == null){
	pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage-1)*pageSize+1;
int endRow = currentPage*pageSize;
//=================================================
int pageCount = count/pageSize+(count%pageSize==0?0:1);
int pageBlock = 10;
int startPage = (currentPage-1)/pageBlock*pageBlock+1;
int endPage = startPage+ pageBlock - 1;
if(endPage > pageCount){
	endPage = pageCount;
}
//=================================================
List<BoardBean> boardList = ibd.getBoardList(startRow,pageSize);


int Commentcount = 0;
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
<h1>Image</h1>
<%for(int i = 0 ; i < boardList.size() ; i++){
	BoardBean bb = boardList.get(i);
	ImageCommentDAO icd = new ImageCommentDAO();
	int ref = bb.getNum();
	Commentcount = icd.countComment(ref);%>
<table id="imageBoard" style="float:left;">
	  <tr><td class="center"><%=bb.getNum()%></td>
	  <tr><td><a href="imageContent.jsp?num=<%=bb.getNum()%>">
	          <img src="../upload/<%=bb.getFile()%>" width="130" height="130"></a></td></tr>
	     <tr><td class="left"><%= bb.getSubject()%> (<%=Commentcount%>)</td></tr>
	     <tr><td class="left"><%=bb.getName()%></td></tr>
	     <tr><td class="left"><%=bb.getDate()%></td></tr>	     
</table>
	<%
}
%>
</article>
<article>
<div id="table_search">
<input type="text" name="search" class="input_box">
<input type="button" value="검색" class="btn"> <a href="imageWriteForm.jsp">
<%if (id != null){
	%><input type="button" value="글쓰기" class="btn"></a><%
}
%>
</div>
</article>
<div class="clear"></div>
<article>
<div id="page_control">
<%if(startPage > pageBlock){%>
<a href="imageBoardList.jsp?pageNum=<%=startPage-pageBlock%>">Prev</a>
	<%
}
%>
<%for (int i = startPage ; i <= endPage ; i++){ %>
	<a href="imageBoardList.jsp?pageNum=<%=i%>"><%=i%></a>
	<%
}
%>
<%
if(endPage < pageCount){%>
<a href="imageBoardList.jsp?pageNum=<%=startPage+pageBlock%>">Next</a>
	<%
	}
%>
</div>
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