<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Manage Product Detail</title>
</head>
<body>
	<div class="container mt-4">
		
		<c:import url="../template/header.jsp"></c:import>
		
		<input type="hidden" name="num" value="${vo.productNum}">
		<h1>Manage Product Detail Page</h1>
		<h3>productNum : ${vo.productNum}</h3>
		<h3>name : ${vo.productName}</h3>
		<h3>price : ${vo.productPrice}</h3>
		<h3>count: ${vo.productCount}</h3>
		<h3>detail : ${vo.productDetail}</h3>
		<c:forEach items="${vo.productFilesVOs}" var="d">
			<c:if test="${d.fileName ne null}">
				<input type="hidden" name="fileNum" value="${d.fileNum}">
				<img alt="" src="../resources/upload/product/${d.fileName}" name="files">
			</c:if>
		</c:forEach>
		<div>
			<a href="./update?num=${vo.productNum}" type="button" class="col-1 btn btn-outline-primary">Update</a>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>