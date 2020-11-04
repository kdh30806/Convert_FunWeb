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
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<link
	href='<c:url value="https://fonts.googleapis.com/css2?family=Oswald:wght@200&family=Single+Day&display=swap"/>'
	rel="stylesheet">
</head>
<body>

<jsp:include page="inc/top.jsp"/>

	<div id="main">

		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<div class="carousel-item active"
					style="background-image: url('<c:url value="/resources/images/메인사진1.jpg"/>')">
<!-- 					<div class="carousel-caption d-none d-md-block"> -->
<!-- 					</div> -->
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('<c:url value="/resources/images/메인사진2.jpg"/>')">
				</div>
				<!-- Slide Three - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('<c:url value="/resources/images/메인사진3.jpg"/>')">
				</div>
			</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> 
					<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
					<span class="sr-only">Previous</span>
				</a> 
				<a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> 
					<span class="carousel-control-next-icon" aria-hidden="true"></span> 
					<span class="sr-only">Next</span>
				</a>
		</div>

		<div id="main_prd">

			<div id="subject">
				<h2>WEEKLY BEST</h2>
				<p>한주간 실시간 판매 베스트 상품입니다.</p>
			</div>

			<ul id="prd_grid4">
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>

				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>

			</ul>
		</div>

		<div class="clear"></div>


		<div id="main_prd">
			<div id="subject">
				<h2>ARRIVAL</h2>
				<p>새 상품을 10% 할인된 가격으로</p>
			</div>

			<ul id="prd_grid4">
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>

				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid4_box">
					<div class="prd_grid4_img">
						<img src='<c:url value="http://placehold.it/350x450"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
		
		<div class="clear"></div>
		
		<div id="main_prd">
			<div id="subject">
				<h2>ACC</h2>
			</div>
			
			<ul id="prd_grid5">

				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>
				
				<li id="prd_grid5_box">
					<div class="prd_grid5_img">
						<img src='<c:url value="http://placehold.it/250x350"/>'>
					</div>
					<div>
						<ul id="information">
							<li>상품명</li>
							<li>가격</li>
							<li>색상</li>
						</ul>
					</div>
				</li>

			</ul>
		</div>
		
		
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
