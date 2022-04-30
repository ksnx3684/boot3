<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
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
			<c:forEach items="${auth.roleVOs}" var="vo">
				<c:if test="${vo.roleName eq 'ROLE_ADMIN'}">
					<a href="../admin/manage" type="button" class="col-1 btn btn-outline-primary">ADMIN Manage</a>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div class="row mt-4">
		<div class="alert alert-primary" role="alert">
		 <h4 style="text-transform: capitalize;">
		 	<a href="/">index</a>
		 	<a href="/board/list">Board List</a>
		 	<a href="/product/list">Product List</a>
		 </h4>
		</div>
	</div>
</body>
</html>