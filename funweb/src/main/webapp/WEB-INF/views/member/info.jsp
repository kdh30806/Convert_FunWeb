
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css" />' rel="stylesheet" type="text/css">
</head>
<body>

<div id="wrap">
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 본문메인이미지 -->
<div id="sub_img_member"></div>
<!-- 본문메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Join us</a></li>
<li><a href="#">Privacy policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
<article>
<h1>Join Us</h1>
<form id="join" method="post" name="fr">
<fieldset>
<legend>Basic Info</legend>
<label>아이디</label>
<input type="text" name="id" class="id" value="${mb.id}" readonly><br>
<label>이름</label>
<input type="text" name="name" value="${mb.name}" readonly><br>
<label>나이</label>
<input type="text" name="age" value="${mb.age}" readonly><br>
<label>성별</label>
<input type="text" name="gender" value="${mb.gender}" readonly><br>
<label>이메일</label>
<input type="email" name="email" value="${mb.email}" readonly><br>
</fieldset>

<fieldset>
<legend>Optional</legend>
<table>
			<colgroup>
				<col style="width:20%"><col>
			</colgroup>
			<tbody>
				<tr>
					<td>우편번호</td>
					<td>
					    <input type="hidden" id="confmKey" name="confmKey" value=""  >
						<input type="text" id="zipNo" name="zipNo" readonly style="width:100px" value="${mb.zipNo}">
					</td>
				</tr>
				<tr>
					<td>도로명주소</td>
					<td><input type="text" id="roadAddrPart1" style="width:85%" name="address" value="${mb.address}" readonly></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<input type="text" id="addrDetail" style="width:40%" name="address2" value="${mb.address2}" readonly>
						<input type="text" id="roadAddrPart2"  style="width:40%" name="address3" value="${mb.address3}" readonly>
					</td>
				</tr>
			</tbody>
		</table>
<label>전화번호</label>
<input type="text" name="phone" value="${mb.phone}" readonly><br>
<label>휴대폰 번호</label>
<input type="text" name="mobile" value="${mb.mobile}" readonly><br>
</fieldset>
<div class="clear"></div>
<div id="table_search">
<a href='<c:url value="main" />'><input type="button" value="홈으로" class="btn"></a>
</div>
</form>
</article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->

<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>