<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Detail</title>
</head>
<body>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<a href="./list"><h4 style="text-transform: capitalize;">${board} List</h4></a>
			</div>
		</div>
		<input type="hidden" name="num" value="${detail.num}">
		<h1>Detail Page</h1>
		<h3>num : ${detail.num}</h3>
		<h3>title : ${detail.title}</h3>
		<h3>writer : ${detail.writer}</h3>
		<h3>contents: ${detail.contents}</h3>
		<h3>date : ${detail.regDate}</h3>
		<c:forEach items="${detail.boardFilesVOs}" var="d">
			<c:if test="${d.fileName ne null}">
				<img alt="" src="../resources/upload/board/${d.fileName}" name="files">
			</c:if>
		</c:forEach>
		<div>
			<a href="./update?num=${detail.num}" type="button" class="col-1 btn btn-outline-primary">Update</a>
			<a href="./delete?num=${detail.num}" type="button" class="col-1 btn btn-outline-danger">Delete</a>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>