<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Update</title>
</head>
<body>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<a href="./list"><h4 style="text-transform: capitalize;">${board} List</h4></a>
			</div>
		</div>
		<form action="./update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num}">
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">작성자</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="writer" value="${dto.writer}" readonly>
				</div>
			</div>
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">제목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title" value="${dto.title}">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">내용</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="contents" rows="5">${dto.contents}</textarea>
				</div>
			</div>
	
			<div>
				<div id="fileResult">
					
				</div>
				<button id="fileAdd" type="button" class="col-2 btn btn-outline-primary">File ADD</button>
				<a href="./list" type="button" class="col-1 btn btn-outline-primary">List</a>
				<button class="col-1 btn btn-outline-primary">Write</button>
			</div>
		</form>
	</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$("#fileAdd").click(function(){
		$("#fileResult").append('<input type="file" name="files">')
	})
</script>
</html>