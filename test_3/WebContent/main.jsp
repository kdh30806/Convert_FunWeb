<%@page import="bean.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/reset.css" rel="stylesheet"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link href="css/base.css" rel="stylesheet"/>
<link href="css/main.css" rel="stylesheet"/>
<title>board</title>
</head>
<body>
<div class="main">
	<h1>게시판</h1>
		<div class="table-group">
			<table class="table">
				<thead class="table-light">
					<tr><th>글번호</th><th class="subject">제목</th><th>작성자</th><th>시간</th><th>조회수</th></tr>
				</thead>
				<tbody>
				<c:forEach var="bb" items="${boardList }">
					<tr><th>${bb.num }</th>
					<td class="subject2">
						<a href="detail.bo?num=${bb.num }">
							<c:if test="${bb.re_lev > 0}">
								<c:forEach var="i" begin="1" end="${bb.re_lev}" step="1">
									&nbsp;
								</c:forEach>
								<img src="right-arrow.png" alt="">
							</c:if>${bb.subject }	
						</a>
					</td>
					<td>${bb.name }</td>
					<td>${bb.date }</td>
					<td>0</td></tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="btngroup">
			<form action="search.bo" class="search-form">
				<input type="text" name="search"><button type="submit" class="btn btn-secondary"><img src="search.png"></button>
			</form>
			<button class="btn btn-secondary btn-lg" onclick="location.href='BoardWriteForm.bo'">작성하기</button>
		</div>
		<div class="page-group">
			<ul class="page">
				<c:if test="${page.startPage > page.pageBlock }">
					<li class="prev"><a href="main.bo?pageNum=${page.startPage-page.pageBlock}">&lt;&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }" step="1">
					<li><a href="main.bo?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${page.endPage > page.pageBlock }">
					<li class="next"><a href="main.bo?pageNum=${page.startPage+page.pageBlock}">&gt;&gt;</a></li>
				</c:if>
			</ul>

		</div>
	</div>
</body>
</html>