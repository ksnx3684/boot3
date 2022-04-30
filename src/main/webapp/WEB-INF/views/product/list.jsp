<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Product List</title>
</head>
<body>

	<div class="container mt-4">
	
		<c:import url="../template/header.jsp"></c:import>
	
		<div class="d-flex justify-content-between">
				<form action="./list" method="get" class="search-form" style="display: inline">
					<select name="kind">
						<option value="productName">상품명</option>
						<option value="productDetail">내용</option>
					</select>
			    	<input type="search" name="search" value="${pager.search}" placeholder="Search">
			    	<button type="submit" class="btn btn-outline-success">Search</button>
		   		</form>
		   		<c:forEach items="${auth.roleVOs}" var="vo">
					<c:if test="${vo.roleName eq 'ROLE_SELLER'}">
						<a href="./manage" type="button" class="col-1 btn btn-outline-primary">Product Manage</a>
					</c:if>
				</c:forEach>
		</div>
		<div class="pager">
			<c:if test="${pager.pre}">
				<a href="./list?pn=${pager.pre?pager.startNum-1:1}">PREV</a>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<a href="./list?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
			</c:forEach>
			<c:if test="${pager.next}">
				<a href="./list?pn=${pager.next?pager.lastNum+1:pager.lastNum}">NEXT</a>
			</c:if>
		</div>
		
		<div class="items">
			<ul>
				<c:forEach items="${list}" var="vo">
					<li class="each" style="list-style: none; float: left; margin-right:20px; margin-bottom:20px">
						<div class="card detail" data-num="${vo.productNum}">
						 	<img src="../resources/upload/product/${vo.productFilesVOs[0].fileName}" class="card-img-top" style="width:250px; height:250px;">
						 	<div class="card-body">
								<h5 class="card-title"><a href="./detail?productNum=${vo.productNum}">${vo.productName}</a></h5>
						    	<p class="card-text">${vo.productPrice}원</p>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- <script type="text/javascript">
	$(".detail").click(function(){
		let num = $(this).attr("data-num");
		location.href="./detail?productNum=" + num
	});
</script> -->
</body>
</html>