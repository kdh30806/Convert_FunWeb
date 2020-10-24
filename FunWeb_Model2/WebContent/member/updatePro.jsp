<%@page import="java.sql.Timestamp"%>
<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member/updatePro.jsp</h1>
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String gender = request.getParameter("gender");
String email = request.getParameter("email");
String zipNo = request.getParameter("zipNo");
String address = request.getParameter("address");
String address2 = request.getParameter("address2");
String address3 = request.getParameter("address3");
String phone = request.getParameter("phone");
String mobile = request.getParameter("mobile");

MemberDAO md = new MemberDAO();
MemberBean mb = md.getMember(id);

mb.setAge(age);
mb.setGender(gender);
mb.setEmail(email);
mb.setZipNo(zipNo);
mb.setAddress(address);
mb.setAddress2(address2);
mb.setAddress3(address3);
mb.setPhone(phone);
mb.setMobile(mobile);

int check = md.checkMember(id,pass);
%>
<%
if(check == 1){
	md.updateMember(mb);%>
<script type="text/javascript">
	alert("수정 완료");
	location.href="../main/main.jsp";
</script>
}
else if(check == -1){%>
<script type="text/javascript">
	alert("아이디 틀림");
	location.href="updateForm.jsp";
</script>
<%
}
else if(check == 0){%>

<script type="text/javascript">
	alert("비밀번호 틀림");
	location.href="updateForm.jsp";
</script><%
}
%>
</body>
</html>