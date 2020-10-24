<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//파라미터 id 값 가져오기
String id = request.getParameter("id");
// 아이디 중복 체크 
// MemberDAO mdao 객체생성
MemberDAO mda=new MemberDAO();
// int check  = dupcheck(id)
int check = mda.dupCheck(id);
// check==1  "아이디 중복" 
// check==0  "아이디 사용가능"
if(check==1){
	out.println("아이디 중복");
}else{
	out.println("아이디 사용가능");
}
%>