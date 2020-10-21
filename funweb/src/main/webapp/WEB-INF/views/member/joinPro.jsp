<%@page import="member.MemberDAO"%>
<%@page import="member.MemberBean"%>
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
<%
// member/joinPro.jsp
request.setCharacterEncoding("utf-8");

MemberBean mb = new MemberBean();
MemberDAO md = new MemberDAO();

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
Timestamp reg_date = new Timestamp(System.currentTimeMillis());
int age = Integer.parseInt(request.getParameter("age"));
String gender = request.getParameter("gender");
String zipNo = request.getParameter("zipNo");
String email = request.getParameter("email");
String address = request.getParameter("address");
String address2 = request.getParameter("address2");
String address3 = request.getParameter("address3");
String phone = request.getParameter("phone");
String mobile = request.getParameter("mobile");

if(gender == null){
	gender ="남자";
}

mb.setId(id);
mb.setPass(pass);
mb.setName(name);
mb.setReg_date(reg_date);
mb.setAge(age);
mb.setGender(gender);
mb.setEmail(email);
mb.setZipNo(zipNo);
mb.setAddress(address);
mb.setAddress2(address2);
mb.setAddress3(address3);
mb.setPhone(phone);
mb.setMobile(mobile);

md.insertMember(mb);
%>
<script type="text/javascript">
alert("회원가입 완료");
location.href = "../main/main.jsp";
</script>
</body>
</html>