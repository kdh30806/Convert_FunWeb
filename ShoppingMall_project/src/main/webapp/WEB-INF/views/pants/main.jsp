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
<link href='<c:url value="/resources/css/default.css"/>'
	rel="stylesheet">
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<link
	href='<c:url value="https://fonts.googleapis.com/css2?family=Oswald:wght@200&family=Single+Day&display=swap"/>'
	rel="stylesheet">
</head>
<body>

	<jsp:include page="../inc/top.jsp" />

	<div id="main">
		<div id="catrgory_subject">
			<h2>PANTS</h2>
			<p>
				<a href='<c:url value="/pants/category?category=슬렉스"/>'>#슬렉스</a>
				<a href='<c:url value="/pants/category?category=밴딩팬츠"/>'>#밴딩팬츠</a>
				<a href='<c:url value="/pants/category?category=면바지"/>'>#면바지</a> 
				<a href='<c:url value="/pants/category?category=청바지"/>'>#청바지</a>
				<a href='<c:url value="/pants/category?category=반바지"/>'>#반바지</a>
			</p>
		</div>

		<div id="best_item">
			<div id="subject">
				<h2>BEST ITEM</h2>
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

		<div>
			<div id="subject">
				<div class="total_prd">
					<h5>TOTAL123PRODUCT</h5>
				</div>
				<div class="total_btns">
					<button type="button" class="btn btn-outline-dark">신상품</button>
					<button type="button" class="btn btn-outline-dark">인기순</button>
					<button type="button" class="btn btn-outline-dark">낮은가격</button>
					<button type="button" class="btn btn-outline-dark">높은가격</button>
				</div>
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
