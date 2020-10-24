<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
// 주소부분
function goPopup(){
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    var pop = window.open("../address/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.fr.roadAddrPart1.value = roadAddrPart1;
	document.fr.roadAddrPart2.value = roadAddrPart2;
	document.fr.addrDetail.value = addrDetail;
	document.fr.zipNo.value = zipNo;
}
function submitCheck() {

	if(document.fr.pass.value ==""){
		alert("비밀번호를 입력해주세요.");
		document.fr.pass.focus();
		return false;
	}

	if(document.fr.age.value == ""){
		alert("나이를 입력해주세요.");
		document.fr.age.focus();
		return false;
	}
	if(document.fr.gender.value ==""){
		alert("성별을 선택해주세요.");
		return false;
	}
	
	if(document.fr.email.value ==""){
		alert("이메일을 입력해주세요.");
		document.fr.email.focus();
		return false;
	}
	if(document.fr.email.value != document.fr.email2.value){
		alert("이메일이 일치하지 않습니다.");
		return false;
	}
}
</script>
</head>
<body>
<%
String id = (String)session.getAttribute("id");

MemberDAO md = new MemberDAO();
MemberBean mb = md.getMember(id);
%>
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
<form action="updatePro.jsp" id="join" method="post" name="fr" onsubmit="return submitCheck()">
<fieldset>
<legend>Basic Info</legend>
<label>아이디</label>
<input type="text" name="id" class="id" value= <%=id %> readonly><br>
<label>비밀번호</label>
<input type="password" name="pass"><br>
<!-- <label>비밀번호 확인</label> -->
<!-- <input type="password" name="pass2"><br> -->
<label>이름</label>
<input type="text" name="name" value="<%=mb.getName()%>" readonly><br>
<label>나이</label>
<input type="text" name="age" value="<%=mb.getAge()%>"><br>
<label>성별</label>
<input type="radio" name="gender" value="남">남자
<input type="radio" name="gender" value="여">여자<br><br>
<label>이메일</label>
<input type="email" name="email" value="<%=mb.getEmail()%>"><br>
<label>이메일 확인</label>
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
						<input type="text" id="zipNo" name="zipNo" readonly style="width:100px" value="<%=mb.getZipNo()%>">
						<input type="button"  value="주소검색" onclick="goPopup();">
					</td>
				</tr>
				<tr>
					<td>도로명주소</td>
					<td><input type="text" id="roadAddrPart1" style="width:85%" name="address" value="<%=mb.getAddress() %>"></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<input type="text" id="addrDetail" style="width:40%" name="address2" value="<%=mb.getAddress2() %>">
						<input type="text" id="roadAddrPart2"  style="width:40%" name="address3" value="<%=mb.getAddress3() %>">
					</td>
				</tr>
			</tbody>
		</table>
<label>전화번호</label>
<input type="text" name="phone" value=<%=mb.getPhone()%>><br>
<label>휴대폰 번호</label>
<input type="text" name="mobile" value=<%=mb.getMobile()%>><br>
</fieldset>
<div class="clear"></div>
<div id="buttons">
<input type="submit" value="회원정보수정" class="submit">
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