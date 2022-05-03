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
		<c:choose>
			<c:when test="${not empty find}">
				<h2><spring:message code="member.findIdResult.info" arguments="${find.id}"></spring:message></h2>
			</c:when>
			<c:otherwise>
				<h2><spring:message code="member.findFault.info"></spring:message></h2>
			</c:otherwise>
		</c:choose>
		<a href="./login"><button type="submit">로그인 페이지</button></a>
		
	</div>

</body>
</html>