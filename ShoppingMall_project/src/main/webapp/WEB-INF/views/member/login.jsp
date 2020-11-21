<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">
<title>Blog Template Â· Bootstrap</title>
<link rel="canonical"
	href='<c:url value="https://getbootstrap.com/docs/4.5/examples/blog/"/>'>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href='<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"/>'
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href='<c:url value=""/>'
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script
	src='<c:url value="https://code.jquery.com/jquery-3.5.1.slim.min.js"/>'
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src='<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"/>'
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<!-- Custom styles for this template -->
<link
	href='<c:url value="https://fonts.googleapis.com/css?family=Playfair+Display:700,900"/>'
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href='<c:url value="/resources/css/default.css"/>' rel="stylesheet">
<link href='<c:url value="/resources/css/member.css"/>' rel="stylesheet">
<link
	href='<c:url value="https://fonts.googleapis.com/css2?family=Oswald:wght@200&family=Single+Day&display=swap"/>'
	rel="stylesheet">
</head>
<body>

<jsp:include page="../inc/top.jsp"/>

	<div id="main">

		<div class="login-subject">
			<h4>LOGIN</h4>
		</div>
		
		<form class="login-form" action='<c:url value="/member/login"/>'  method="post">
			<h5>회원로그인</h5>
			<fieldset class="login-form-fieldset">
					<input type="text" class="login-form-input-1" name="id">
					<input type="text" class="login-form-input-2" name="password">
					<input type="submit" value="로그인" class="login-btn">
					
					<ul class="login-find">
						<li>▶아이디 찾기</li>
						<li>▶비밀번호 찾기</li>
					</ul>
					
					<ul class="login-sns">
						<li><img src='<c:url value="/resources/images/btn_naver_login.gif"/>'></li>
						<li style="margin: 0 20px;"><img src='<c:url value="/resources/images/btn_kakao_login.gif"/>'></li>
						<li><img src='<c:url value="/resources/images/btn_apple_login.gif"/>'></li>
					</ul>
					<hr>
					
					<p>회원가입 하시면 다양하고 특별한<br>
					       혜택이 준비 되어 있습니다. <a href="#"><img src='<c:url value="/resources/images/btn_join.gif"/>'></a></p>
			</fieldset>
			
			
		</form>

		

		
		
	</div>
	<!-- 	main -->

	<div class="clear"></div>

	<footer class="blog-footer">
		<p>
			Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a>
			by <a href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>
</body>
</html>
