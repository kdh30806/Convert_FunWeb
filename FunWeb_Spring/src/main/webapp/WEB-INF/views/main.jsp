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
<link href='<c:url value="/resources/css/front.css" />' rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {	

	$.ajax({		
		url: "AJAX_recipeList",
		type: "POST",
		contentType: "application/json; charset=utf-8;",
		dataType: "json",
		success: function(data){
			for(var i = 0 ; i < data.length ; i++){
				$('.hot_recipe').append("<tr><td id='contxt'><a href='#'>"+data[i].subject+"</a></td><td>"+data[i].date+"</td><td>"+data[i].readcount+"</td></tr>");
			}
		},
		error: function(data){
			console.log();
		}
	});
	
	$.ajax({
		url: "AJAX_notice",
		type: "POST",
		contentType: "application/json; charset=utf-8;",
		dataType: "json",
		success: function(data){
			for(var i = 0 ; i < data.length ; i++){
				$('.notice').append("<tr><td id='contxt'><a href='#'>"+data[i].subject+"</a></td><td>"+data[i].date+"</td><td>"+data[i].readcount+"</td></tr>");
			}
		},
		error: function(data){
			console.log();
		}	
	});
	
	$.ajax({
		url: "AJAX_picture",
		type: "POST",
		contentType: "application/json; charset=utf-8;",
		dataType: "json",
		success: function(data){
			for(var i = 0 ; i < data.length ; i++){
				$('#imageBoard').append('<td id="mainPicture"><a href="#"><img src="<c:url value="/resources/upload/'+data[i].file+'" />" width="150" height="130"></a></td>');
			}
		},
		error: function(data){
			console.log();
		}	
	});
	
});
</script>
</head>
<body>
<div id="wrap">
<!-- 헤더파일들어가는 곳 -->
<jsp:include page="inc/top.jsp"/>
<!-- 헤더파일들어가는 곳 -->
<!-- 메인이미지 들어가는곳 -->
<div class="clear"></div>
<div id="main_img"><img src='<c:url value="/resources/images/요리비책.jpg" />' width="971" height="282"></div>
<!-- 메인이미지 들어가는곳 -->
<!-- 메인 콘텐츠 들어가는 곳 -->
<article id="front">
<div id="solution">
		<table id="imageBoard" style="margin-right: 40px; width: 925px; text-align: center;">
		</table>
</div>
<div class="clear"></div>

<div id="news_notice">
<h3 style="color: #827b00">최근 핫 레시피</h3>
<table class="hot_recipe">
	<tr><th id="contxt">제목</th><th>날짜</th><th>조회수</th></tr>
</table>
</div>

<div id="news_notice" style="margin-left: 60px;">
<h3 class="brown">공지사항</h3>
<table class="notice">
	<tr><th id="contxt">제목</th><th>날짜</th><th>조회수</th></tr>
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