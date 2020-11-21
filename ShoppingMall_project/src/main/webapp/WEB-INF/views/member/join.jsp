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
<script src='<c:url value="/resources/script/jquery-3.5.1.js"/>'></script>
<script src='<c:url value="/resources/js/join.js"/>'></script>
<script src='<c:url value="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"/>'></script>
<span id="guide" style="color:#999;display:none"></span>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#idSpan').html("아이디를 입력해 주세요. (영문소문자/숫자, 4~16자)");
	$('#passSpan').html("영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자을 입력해야 합니다.");	

	$('#id').keyup(function(){
		var id= document.getElementById('id').value;
		var checkCha= id.search(/[!@#$%^&*()]/g);	
		var checkUpper = id.search(/[A-Z]/g);
		
		if(!(checkCha == -1)){
			$('#idSpan').html("특수 문자는 사용할 수 없습니다.");
			return false;
		}
		if(!(checkUpper == -1)){
			$('#idSpan').html("영문 대문자는 사용할 수 없습니다.");
			return false;
		}
		if(!/^[a-z0-9]{4,16}$/.test(id)){
			$('#idSpan').html("아이디는 4자~16자를 입력 해야 합니다.");
			return false;
		}
		if(/^[a-z0-9]{4,16}$/.test(id)){
			$('#idSpan').html("완벽한 아이디입니다.");
			return false;
		}
		
	});
	$('#password').keyup(function(){
		var password = document.getElementById('password').value;
		var checkNumber = password.search(/[0-9]/g);
		var checkEnglish = password.search(/[a-zA-Z]/g);
		var checkCha= password.search(/[!@#$%^&*()]/g);	
		
	 		if(checkNumber+checkEnglish+checkCha < 2){
	 			$('#passSpan').html("영문 대소문자/숫자/특수문자 중 2가지 이상 조합이여야 합니다");
	 			return false;
	 		}
	 		if(!/^[a-zA-Z0-9]{8,16}$/.test(password)){
	 			$('#passSpan').html("비밀번호는 8자~16자을 입력해야 합니다.");
	 			return false;
	 		}
	 		if(/^[a-zA-Z0-9]{8,16}$/.test(password)){
	 			$('#passSpan').html("완벽한 비밀번호 입니다.");
	 			return false;
	 		}
	});
});

</script>
<body>

<jsp:include page="../inc/top.jsp"/>

	<div id="main">
		<form class="join-form" action='<c:url value="/member/join"/>' method="post">
			 <table>
			 	<tr><td class="join-form-category">아이디</td><td class="join-form-text"><input type="text" id="id" name="id" class="join-form-input"><span id="idSpan"></span></td></tr>
				<tr><td class="join-form-category">비밀번호</td><td class="join-form-text"><input type="text" id="password" name="password" class="join-form-input"><span id="passSpan"></span></td></tr>
				<tr><td class="join-form-category">비밀번호 확인</td><td class="join-form-text"><input type="text" name="password2" class="join-form-input"></td></tr>
				<tr><td class="join-form-category">이름</td><td class="join-form-text"><input type="text" name="name" class="join-form-input"></td></tr>	
				<tr><td rowspan="3" class="join-form-category">주소</td>
					<td rowspan="3" class="join-form-text">
						<input type="text" name="zipNo" id="sample4_postcode" class="join-form-input-addr-1"><a href="#" class="postNum" onclick="sample4_execDaumPostcode();">우편번호</a>
						<input type="text" name="address1" id="sample4_roadAddress" class="join-form-input-addr-2">
						<input type="text" name="address2" id="sample4_extraAddress" class="join-form-input-addr-3">
						<input type="hidden" id="sample4_jibunAddress" style="width:40%" name="address2" placeholder="상세주소1">
					</td>
				</tr>		
				<tr></tr>
				<tr></tr>
				<tr><td class="join-form-category">전화번호</td><td class="join-form-text">
					<select class="join-form-input-num" name="mobile1">
						<option selected="selected" value="010">010</option>
						<option value="02">02</option>
						<option value="051">051</option>
						<option value="031">031</option>
						<option value="032">032</option>			
					</select>  -  <input type="text" name="mobile2" class="join-form-input width60">  -  <input type="text" name="mobile3" class="join-form-input width60"></td></tr>
					<tr><td class="join-form-category">휴대폰 번호</td><td class="join-form-text">
					<select class="join-form-input-num" name="phone1">
						<option selected="selected" value="010">010</option>
						<option value="011">011</option>
						<option value="012">012</option>
						<option value="013">013</option>
						<option value="014">014</option>
					</select>  -  <input type="text" name="phone2" class="join-form-input width60">  -  <input type="text" name="phone3" class="join-form-input width60"></td></tr>	
				<tr><td class="join-form-category">이메일</td><td class="join-form-text"><input type="text" name="email" class="join-form-input"></td></tr>												 			 
			 </table>
			 <h5 style="text-align: left; margin-top: 30px;">추가정보</h5>
			 
			 <table>
			 	<tr><td class="join-form-category">생년월일</td>
			 		<td class="join-form-text"><input type="text" name="year" class="join-form-input width90"> 년 <input type="text" name="month" class="join-form-input width80">  월 <input type="text" name="day" class="join-form-input width80"> 일</td></tr>	
			 </table>
			 
			 <input type="submit" class="btn btn-dark btn-custom" value="회원가입"><input type="button" class="btn btn-light btn-custom" value="회원가입 취소">
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
