<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css"/>' rel="stylesheet" type="text/css">
<script src='<c:url value="/resources/script/jquery-3.5.1.js"/>'></script>
<script src='<c:url value="/resources/js/join.js"/>'></script>
<script src='<c:url value="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"/>'></script>
<span id="guide" style="color:#999;display:none"></span>
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
<form action=<c:url value="/member/join"/> id="join" method="post" name="fr" onsubmit="return submitCheck()">
<fieldset>
<legend>Basic Info</legend>
<label>아이디</label>
<input type="text" name="id" class="id">
<input type="button" value="중복확인" class="dup"><br>
<div id="divid"></div>
<label>비밀번호</label>
<input type="password" name="pass" id="pass"><br>
<label>비밀번호 확인</label>
<input type="password" name="pass2" id="pass2"><br>
<label>이름</label>
<input type="text" name="name" id="name"><br>
<label>나이</label>
<input type="text" name="age" id="age"><br>
<label>성별</label>
<input type="radio" name="gender" value="남">남자
<input type="radio" name="gender" value="여">여자<br><br>
<label>이메일</label>
<input type="email" name="email" id="email"><br>
<label>이메일 확인</label>
<input type="email" name="email2" id="email2"><br>
</fieldset>

<fieldset>
<legend>Optional</legend>
<!-- 주소  -->

<table>
			<colgroup>
				<col style="width:20%"><col>
			</colgroup>
			<tbody>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" id="sample4_postcode" placeholder="우편번호" name="zipNo" readonly style="width:100px">
						<input type="button"  value="주소검색" onclick="sample4_execDaumPostcode();">
					</td>
				</tr>
				<tr>
					<td>도로명주소</td>
					<td><input type="text" id="sample4_roadAddress" style="width:85%" name="address" placeholder="도로명주소"></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<input type="text" id="sample4_jibunAddress" style="width:40%" name="address2" placeholder="상세주소1">
						<input type="text" id="sample4_extraAddress"  style="width:40%" name="address3" placeholder="상세주소2">
					</td>
				</tr>
			</tbody>
		</table>
<label>전화번호</label>
<input type="text" name="phone"><br>
<label>휴대폰 번호</label>
<input type="text" name="mobile"><br>
</fieldset>
<div class="clear"></div>
<div id="buttons">
<input type="submit" value="회원가입" class="submit">
<input type="reset" value="취소" class="cancel">
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