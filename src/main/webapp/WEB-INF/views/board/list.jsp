<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>List</title>
</head>
<body>

	<div class="container mt-4">
		
		<c:import url="../template/header.jsp"></c:import>
		
		<div class="row mt-4">
			<table class="table">
				<thead>
					<tr>
			          <th>번호</th>
			          <th>제목</th>
			          <th>작성자</th>
			          <th>조회수</th>
			          <th>작성일</th>
			        </tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<th>${vo.num}</th>
						<th><a href="./detail?num=${vo.num}">${vo.title}</a></th>
						<th>${vo.writer}</th>
						<th>${vo.hit}</th>
						<th>${vo.regDate}</th>
					</tr>	
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="d-flex justify-content-between">
				<form action="./list" method="get" class="search-form" style="display: inline">
					<select name="kind">
						<option value="title">제목</option>
						<option value="contents">내용</option>
						<option value="writer">작성자</option>
					</select>
			    	<input type="search" name="search" value="${pager.search}" placeholder="Search">
			    	<button type="submit" class="btn btn-outline-success">Search</button>
		   		</form>
			<a href="./add" type="button" class="col-1 btn btn-outline-primary">Write</a>
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
	</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>