<%@page import="java.text.SimpleDateFormat"%>
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
BoardDAO bd = new BoardDAO();
String id = (String)session.getAttribute("id");
// ================================================
int count = bd.getBoardCount();
int pageSize = 10;
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
SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
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
<h1>Notice</h1>
<table id="notice">
<tr><th class="tno">No.</th>
    <th class="ttitle">Title</th>
    <th class="twrite">Writer</th>
    <th class="tdate">Date</th>
    <th class="tread">Read</th></tr>
<%for(int i = 0 ; i < boardList.size() ; i++){
	BoardBean bb = boardList.get(i);
	%><tr><td class="center"><%=bb.getNum()%></td>
	      <td class="left"><a href="content.jsp?num=<%=bb.getNum()%>"><%=  bb.getSubject()%></a></td>
	      <td class="left"><%=bb.getName()%></td>
	      <td class="left"><%=sdf.format(bb.getDate())%></td>
	      <td class="center"><%=bb.getReadcount()%></td></tr>
	<%
}
%>
</table>
<div id="table_search">
<form action="noticeSearch.jsp" method="post">
<input type="text" name="search" class="input_box">
<input type="submit" value="검색" class="btn"> 
<%if (id != null){
	%><a href="writeForm.jsp"><input type="button" value="글쓰기" class="btn"></a><%
}
%>
</form>
</div>
<div class="clear"></div>
<div id="page_control">
<%if(startPage > pageBlock){%>
<a href="notice.jsp?pageNum=<%=startPage-pageBlock%>">Prev</a>
	<%
}
%>
<%for (int i = startPage ; i <= endPage ; i++){ %>
	<a href="notice.jsp?pageNum=<%=i%>"><%=i%></a>
	<%
}
if(endPage < pageCount){%>
<a href="notice.jsp?pageNum=<%=startPage+pageBlock%>">Next</a>
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