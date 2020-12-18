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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#modal_open_btn").click(function(){
		$("#modal").attr("style", "display:block");
	});
	
	$("#modal_close_btn").click(function(){
		$("#modal").attr("style", "display:none");
	});
});
</script>
</head>
<body>
	<div class="main">
	<h1></h1>
		<h1>글 상세</h1>
		<form action="BoardWritePro.bo">
		<div class="board-form">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">제목</label> 
				<input type="text" class="form-control" name="subject" value="${bb.subject}" readonly="readonly">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">작성자</label> 
				<input type="text" class="form-control name" name="name" value="${bb.name }" readonly="readonly">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea class="form-control" rows="7" name="content" readonly="readonly">${bb.content } </textarea>
			</div>
				<div class="mb-3">
 					 <label for="formFile" class="form-label">파일</label>
 					 <input class="form-control" id="file" type="text" name="file" value="${bb.originFile}" readonly="readonly" onclick="location.href='download.bo?file=${bb.file}'">
				</div>
			</div>
		<div class="btngroup">
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='replyForm.bo?num=${bb.num}'">답글작성</button>
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='updateForm.bo?num=${bb.num}'">수정</button>
			<button type="button" class="btn btn-secondary btn-lg" id="modal_open_btn">삭제</button>
				<div id="modal">
					<div class="modal_content">
						<h5>삭제 하시겠습니까?</h5>
						<button type="button"  class="btn btn-secondary btn-lg" onclick="location.href='delete.bo?num=${bb.num}'">예</button>
						<button type="button"  class="btn btn-secondary btn-lg" id="modal_close_btn">아니오</button>
					</div>
				</div>
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='main.bo'">뒤로가기</button>
		</div>
		</form>	
	</div>
</body>
</html>