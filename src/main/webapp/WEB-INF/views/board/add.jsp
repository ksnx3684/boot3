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
		
		<c:import url="../template/header.jsp"></c:import>
		
		<form action="./add" method="post" enctype="multipart/form-data">
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">작성자</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="writer" value="${auth.id}" readonly>
				</div>
			</div>
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">제목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">내용</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="summernote" name="contents" rows="5"></textarea>
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

<script type="text/javascript">
	$('#summernote').summernote({
		height: 300,
		placeholder: '내용을 입력하세요',
		callbacks: {
			onImageUpload: function(files){
				// files upload한 이미지 파일 객체
				let formData = new FormData();
				formData.append("files", files[0]);
				
				// /board/summerFileUpload
				$.ajax({
					type: "post",
					url: "./summerFileUpload",
					data: formData,
					contentType:false,
					processData:false,
					
					success: function(data){
						$('#summernote').summernote('editor.insertImage', data.trim());
						alert("파일 업로드 성공");
					}
					
				});
			}, // onImageUpload 끝
			onMediaDelete:function(files){
				let fileName = $(files[0]).attr("src");
				console.log(fileName);
				$.ajax({
					type: "get",
					url: "./summerFileDelete",
					data: {
						fileName : fileName
					},
					
					success: function(data){
						let v = data.trim();
						console.log(v);
					}
				});
			}
		}
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
</html>