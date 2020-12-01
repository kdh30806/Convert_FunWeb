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
<link href='<c:url value="/resources/css/question_answer.css"/>' rel="stylesheet">
<link
	href='<c:url value="https://fonts.googleapis.com/css2?family=Oswald:wght@200&family=Single+Day&display=swap"/>'
	rel="stylesheet">
</head>
<body>

	<jsp:include page="../inc/top.jsp" />

	<div id="main">
		<div class="btns-group">
			<h2 style="font-size: 20px;">Hyuni's shop 고객만족 센터 1833-9940</h2>
			<h5 style="margin-bottom: 20px; font-size: 8px;">운영시간 10:00 - 05:00 / 점심시간 12:00 - 13:00 / 토, 일, 공휴일은 쉽니다.</h5>
				<button type="button" class="btn btn-secondary">Secondary</button>
				<button type="button" class="btn btn-secondary">Secondary</button>
				<button type="button" class="btn btn-secondary">Secondary</button>
				<button type="button" class="btn btn-secondary">Secondary</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
				<button type="button" class="btn btn-light">Light</button>
		</div>
		
		
		<div class="main-question-board">
			<table class="question-table">
				<thead>
					<tr>
						<th scope="col" class="no">NO</th>
						<th scope="col" class="category">CATEGORY</th>
						<th scope="col" class="subeject">SUBJECT</th>
						<th scope="col" class="writer">WRITER</th>
						<th scope="col" class="date">DATE</th>
					</tr>
				</thead>
				<tbody>
					<tr id="first-row" class="row">
						<th>1</th>
						<td>Mark</td>
						<td class="subject">Otto</td>
						<td>@mdo</td>
						<td>date</td>
					</tr>
					
					<tr class="row">
						<th>1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
						<td>date</td>
					</tr>
					
					<tr class="row">
						<th>1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
						<td>date</td>
					</tr>
					
				</tbody>
			</table>
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
