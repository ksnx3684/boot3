<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>ADD</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
		
	
</head>
<body>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<a href="./list"><h4 style="text-transform: capitalize;">Product List</h4></a>
			</div>
		</div>
		<form action="./add" method="post" enctype="multipart/form-data">
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">제품명</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="productName">
				</div>
			</div>
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">가격</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="productPrice">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">수량</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="productCount"></input>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">상세설명</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="summernote" name="productDetail" rows="5"></textarea>
				</div>
			</div>
			<div>
				<div id="fileResult">
					
				</div>
				<button id="fileAdd" type="button" class="col-2 btn btn-outline-primary">File ADD</button>
				<a href="./list" type="button" class="col-1 btn btn-outline-primary">List</a>
				<button class="col-1 btn btn-outline-primary">Add</button>
			</div>
		</form>
	</div>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script type="text/javascript">
	$('#summernote').summernote({
		height: 300
	});

	let count = 1;
	
	$("#fileAdd").click(function(){
		if(count < 6){
			$("#fileResult").append('<div class="files"><input type="file" name="files"><button type="button" class="del">X</button></div>')
			count++;
		} else{
			alert("5개 초과");
		}
	});
	
	$("#fileResult").on("click", ".del", function(){
		$(this).parent().remove();
		count--;
	});
	
</script>
</body>
</html>