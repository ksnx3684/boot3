<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Manage</title>
</head>
<body>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<c:choose>
					<c:when test="${not empty auth}">
						<a href="../member/mypage" type="button" class="col-1 btn btn-outline-primary">mypage</a>
						<a href="../member/logout" type="button" class="col-1 btn btn-outline-primary">logout</a>
					</c:when>
					<c:otherwise>
						<a href="../member/login" type="button" class="col-1 btn btn-outline-primary">login</a>
						<a href="../member/join" type="button" class="col-1 btn btn-outline-primary">join</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
			 <h4 style="text-transform: capitalize;">
			 	<a href="../">index</a>
			 	<a href="../board/list">Board List</a>
			 	<a href="./list">Product List</a>
			 </h4>
			</div>
		</div>
		
		<h1>Product manage</h1>
		<a href="./add" type="button" class="col-1 btn btn-outline-primary">Product Add</a>
		
		<c:import url="../common/productList.jsp"></c:import>
		<form action="./manage" id="frm">
			<input type="hidden" name="pn" id="pn" value="${pager.pn}">
		</form>
		
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(".pager").click(function(){
		let pn = $(this).attr("pn");
		$("#pn").val(pn);
		$("#frm").submit();
	})
</script>
</body>
</html>