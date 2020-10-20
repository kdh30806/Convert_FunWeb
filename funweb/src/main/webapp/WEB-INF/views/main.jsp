<%@page import="board.ImageBoardDAO"%>
<%@page import="board.recipeBoardDAO"%>
<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/front.css" rel="stylesheet" type="text/css">
</head>
<%
//======================글 게시판 페이징 목록==============================================================
BoardDAO bd = new BoardDAO();
recipeBoardDAO rbd = new recipeBoardDAO();
//================================================
int count = bd.getBoardCount();
int pageSize = 5;
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
List<BoardBean> boardList = bd.getBoardList(startRow,pageSize);
List<BoardBean> recipeBoardList = rbd.getBoardReadCountList(startRow, pageSize);
//==========================================================================================================

ImageBoardDAO ibd = new ImageBoardDAO();
String id = (String)session.getAttribute("id");

// ================================================
int count2 = ibd.getBoardCount();
int pageSize2 = 3;
String pageNum2 = request.getParameter("pageNum");
if(pageNum2 == null){
	pageNum2 = "1";
}
int currentPage2 = Integer.parseInt(pageNum);
int startRow2 = (currentPage2-1)*pageSize2+1;
int endRow2 = currentPage2*pageSize2;
//=================================================
int pageCount2 = count2/pageSize2+(count2%pageSize2==0?0:1);
int pageBlock2 = 10;
int startPage2 = (currentPage2-1)/pageBlock2*pageBlock2+1;
int endPage2 = startPage2+ pageBlock2 - 1;
if(endPage2 > pageCount2){
	endPage2 = pageCount2;
}
//=================================================
List<BoardBean> imageBoardList = ibd.getBoardList(startRow2,pageSize2);
%>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="inc/top.jsp"/>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src="../images/요리비책.jpg"
 width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
<%for(int i = 0 ; i < imageBoardList.size() ; i++){
	BoardBean bb = imageBoardList.get(i);%>
	<div id="security">
<table id="imageBoard" style="margin-left: 70px;">
	  <tr><td><a href="../imageBoard/imageContent.jsp?num=<%=bb.getNum()%>">
	          <img src="../upload/<%=bb.getFile()%>" width="150" height="130"></a></td></tr>
</table>
	</div>
	<%
}
%>
</div>
<div class="clear"></div>

<div id="news_notice">
<h3 style="color: #827b00">최근 핫 레시피</h3>
<table>
<%for(int i = 0; i < recipeBoardList.size() ; i++){
	BoardBean bb = recipeBoardList.get(i);
	%>
<tr><td id="contxt"><a href="../recipeBoard/content.jsp?num=<%=bb.getNum()%>"><%=bb.getSubject()%></a></td>
    <td><%=bb.getDate()%></td><td>조회수 <%=bb.getReadcount()%></td></tr>
    <%
}
%>
</table>
</div>

<div id="news_notice">
<h3 class="brown">공지사항</h3>
<table>
<%for(int i = 0; i < boardList.size() ; i++){
	BoardBean bb = boardList.get(i);
	%>
<tr><td id="contxt"><a href="../notice/content.jsp?num=<%=bb.getNum()%>"><%=bb.getSubject()%></a></td>
    <td><%=bb.getDate()%></td></tr>
    <%
}
%>
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