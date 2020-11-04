<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="blog-header">
		<div class="navbar fixed-top navbar-light bg-light">
			<div class="col-4 pt-1"></div>
			<div class="col-4 text-center">
				<a class="blog-header-logo text-dark" href="#">Hyuni's shop</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<a class="btn btn-sm btn-outline-secondary" href="#">JOIN</a>
				<a class="btn btn-sm btn-outline-secondary" href="#" style="margin-left: 3px;">LOGIN</a> <a class="text-muted" href="#" aria-label="Search" style="margin-left: 10px;"> <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cart-dash" fill="currentColor"
						xmlns="http://www.w3.org/2000/svg">
 				<path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z" />
 				<path fill-rule="evenodd" d="M6 7.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5z" />
				</svg>
				</a>
		</div>
			
			<nav class="navbar navbar-expand-lg navbar-light bg-light"
				id="topMenu">
				<ul class="nav justify-content-center" style="width: 100%;">
					<li class="nav-item"><a class="nav-link" href='<c:url value="#"/>'>BEST</a></li>
					<li class="nav-item"><a class="nav-link" href="#">WEEKLY</a></li>
					<li class="nav-item"><a class="nav-link" href="#">EVENT</a></li>
					<li class="nav-item" id="top_menu_space"><a class="nav-link" href="#">1+1 SET</a></li>				
					<li class="nav-item" id="prd-hover"><a class="nav-link" href='<c:url value="/outer/main"/>'>OUTER</a>
						<div class="dropdown-content">
							<a href="#">코트/트렌치코트</a>
							<a href="#">자켓</a>
							<a href="#">점퍼</a>
							<a href="#">가디건</a>
							<a href="#">집업</a>
							<a href="#">조끼</a>
							<a href="#">야상</a>
						</div>
					</li>
					<li class="nav-item" id="prd-hover"><a class="nav-link" href="#">TOP</a>
						<div class="dropdown-content">
							<a href="#">긴팔티</a>
							<a href="#">맨투맨/후드</a>
							<a href="#">반팔티</a>
							<a href="#">니트</a>
							<a href="#">셔츠</a>
						</div>
					</li>
					<li class="nav-item" id="prd-hover"><a class="nav-link" href="#">PANTS</a>
						<div class="dropdown-content">
							<a href="#">슬렉스</a>
							<a href="#">밴딩팬츠</a>
							<a href="#">면바지</a>
							<a href="#">청바지</a>
							<a href="#">반바지</a>
						</div>
					</li>
					<li class="nav-item" id="prd-hover"><a class="nav-link" href="#">SHOES</a>
						<div class="dropdown-content">
							<a href="#">스니커즈</a>
							<a href="#">로퍼</a>
							<a href="#">부츠/워커</a>
							<a href="#">샌들</a>
						</div>
					</li>
					<li class="nav-item" id="prd-hover"><a class="nav-link" href="#">BAG</a>
						<div class="dropdown-content">
							<a href="#">백팩</a>
							<a href="#">토트백</a>
							<a href="#">크로스백</a>

						</div>
					</li>
					<li class="nav-item" id="prd-hover"><a class="nav-link" href="#">ACC</a>
						<div class="dropdown-content">
							<a href="#">목걸이/팔찌/반지</a>
							<a href="#">모자</a>
							<a href="#">안경/선글라스</a>
							<a href="#">양말</a>
							<a href="#">벨트</a>
							<a href="#">기타</a>
						</div>
					</li>
					<li class="nav-item" id="top_menu_space"><a class="nav-link" href="#">BEAUTY</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Q&A</a></li>
					<li class="nav-item"><a class="nav-link" href="#">REVIEW</a></li>
				</ul>
			</nav>
		</div>
	</header>