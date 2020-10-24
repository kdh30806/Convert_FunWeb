<%@page import="member.MemberDAO"%>
<%@page import="member.MemberBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sel() {
	window.opener.fr.id.value = document.wfr.id.value;
	window.close();
}
</script>
</head>
<body>
<%
String id = request.getParameter("id");

MemberDAO md = new MemberDAO();
int check = md.dupCheck(id);
if(check == 1){%>
<script type="text/javascript">
alert("중복 아이디 입니다.")
</script><%
} else {%>
<script type="text/javascript">
alert("가능한 아이디 입니다.")
</script>
<%
}
%>
<form action="dupCheck.jsp" method="post" name="wfr">
아이디 : <input type="text" name="id" value="<%=id%>">
<input type="submit" value="아이디 중복체크">
</form>
<input type="button" value="아이디 선택" onclick="sel()">
</body>
</html>