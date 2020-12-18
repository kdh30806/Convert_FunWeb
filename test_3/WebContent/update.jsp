<%@page import="bean.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/reset.css" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link href="css/base.css" rel="stylesheet" />
<link href="css/sub.css" rel="stylesheet" />
</head>
<body>
	<div class="main">
		<h1>수정</h1>
		<form action="updatePro.bo">
		<div class="board-form">
				<input type="hidden" name="num" value="${bb.num }">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">제목</label> 
				<input type="text" class="form-control" name="subject" value="${bb.subject }">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">작성자</label> 
				<input type="text" class="form-control name" name="name" value="${bb.name }" readonly="readonly">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea class="form-control" rows="7" name="content">${bb.content }></textarea>
			</div>
				<div class="mb-3">
 					 <label for="formFile" class="form-label">파일</label>
 					 <input class="form-control" type="file" id="formFile" name="file" value="${bb.file }">
				</div>
			</div>
		<div class="btngroup">
			<button type="submit" class="btn btn-secondary btn-lg">수정</button>
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='detail.bo?num=${bb.num}'">취소하기</button>
		</div>
		</form>	
	</div>
</body>
</html>