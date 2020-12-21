<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>글 작성</h1>
		<form action="BoardWritePro.bo" method="post" enctype="multipart/form-data">
		<div class="board-form">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">제목</label> 
				<input type="text" class="form-control" name="subject">
			</div>
			
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">작성자</label> 
				<input type="text" class="form-control name" name="name">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea class="form-control" rows="7" name="content"></textarea>
			</div>
				<div class="mb-3">
 					 <label for="formFile" class="form-label">파일</label>
 					 <input class="form-control" type="file" id="formFile" name="file">
				</div>
			</div>
		<div class="btngroup">
			<button type="submit" class="btn btn-secondary btn-lg">작성하기</button>
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href=document.referrer">취소</button>
		</div>
		</form>	
	</div>
</body>
</html>6