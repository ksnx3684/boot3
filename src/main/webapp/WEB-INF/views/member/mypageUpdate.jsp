<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Mypage Update</title>
</head>
<body>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
			 <h4 style="text-transform: capitalize;">
			 	<a href="../board/list">Board List</a>
			 	<a href="../">index</a>
			 </h4>
			</div>
		</div>
		<form action="./mypageUpdate" method="post">
			<div class="main">
				<div>
					<label>아이디</label>
					<input type="id" name="id" placeholder="id" value="${auth.id}" readonly>
				</div>
				<div>
					<label>이름</label>
					<input type="text" name="name" placeholder="이름" value="${auth.name}">
				</div>
				<div>
					<label>이메일</label>
					<input type="text" name="email" placeholder="이메일" value="${auth.email}">
				</div>
				<div>
					<label>전화번호</label>
					<input type="text" name="phone" placeholder="전화번호" value="${auth.phone}">
				</div>
				<div>
					<button type="submit" class="btn btn-outline-success">수정</button>
				</div>
			</div>
		</form>
	</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>