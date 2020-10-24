<%@page import="member.MemberDAO"%>
<%@page import="member.MemberBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member/loginPro.jsp</h1>
<%
String id = request.getParameter("id");
String pass = request.getParameter("pass");
int check = -1;

MemberDAO md = new MemberDAO();
MemberBean mb = new MemberBean();
mb.setId(id);
mb.setPass(pass);

check = md.checkMember(id,pass);
%>
<%
if(check == 1){	%>
	<script type="text/javascript">
		alert("로그인 성공");
	</script>
<%
		session.setAttribute("id", id);
		response.sendRedirect("../main/main.jsp");
}
else if(check == 0){	
%>
<script type="text/javascript">
alert("비밀번호가 일치하지 않습니다.");
</script>
<%
}
else{
%>
<script type="text/javascript">
alert("아이디가 존재하지 않습니다.");
</script>
<%
}
%>
<script type="text/javascript">
location.href ="../main/main.jsp";
</script>
</body>
</html>