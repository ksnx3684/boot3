<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>ID 찾기</title>
</head>
<body>
	<div class="container mt-4">
	
		<c:import url="../template/header.jsp"></c:import>
		
		<h2><spring:message code="member.findId.info"></spring:message></h2>
		<form action="./findId" method="post">
			<input type="text" placeholder="email" name="email">
			<button type="submit">Confirm</button>
		</form>
		
	</div>
	

</body>
</html>