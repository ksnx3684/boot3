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
		
		<form action="./update" method="post" enctype="multipart/form-data" id="frm">
			<input type="hidden" name="productNum" value="${vo.productNum}">
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">제품명</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productName" name="productName" value="${vo.productName}">
				</div>
			</div>
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">가격</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productPrice" name="productPrice" value="${vo.productPrice}">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">수량</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productCount" name="productCount" value="${vo.productCount}">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">상세설명</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="productDetail" name="productDetail" rows="5">${vo.productDetail}</textarea>
				</div>
			</div>
			<div class="mb-3 row">
				<div class="form-check">
				  <input class="form-check-input sale" type="radio" value="1" name="sale" id="flexCheckDefault">
				  <label class="form-check-label" for="flexCheckDefault">
				    판매
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input sale" type="radio" value="0" name="sale" id="flexCheckDefault" checked>
				  <label class="form-check-label" for="flexCheckDefault">
				    판매중지
				  </label>
				</div>
			</div>
			<div>
				<button id="fileAdd" type="button" class="col-2 btn btn-outline-primary">File ADD</button>
				<div>
					<c:forEach items="${vo.productFilesVOs}" var="fileVO">
						<h5>${fileVO.oriName}<button type="button" class="del" data-num="${fileVO.fileNum}">DEL</button></h5>
					</c:forEach>
				</div>
				<div id="fileResult">
				</div>
				<a href="./list" type="button" class="col-1 btn btn-outline-primary">List</a>
				<button id="update" type="submit" class="col-1 btn btn-outline-primary">Update</button>
			</div>
		</form>
	</div>
	
</body>
<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript">
	summernoteInit("productDetail", "${vo.productDetail}");
	fileAddInit(${vo.productFilesVOs.size()});
	fileDeleteInit();
</script>
</body>
</html>