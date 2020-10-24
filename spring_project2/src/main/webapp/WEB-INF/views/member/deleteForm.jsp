<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보삭제 페이지</title>
</head>
<body>
<form action="./delete" method="post">
아이디 : <input type="text" name="id" value="${sessionScope.id }">
비밀번호:<input type="password" name="pass"><br>
<input type="submit" value="회원삭제">
</form>
</body>
</html>






