<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Mypage</title>
</head>
<body>
	<div class="container mt-4">
	
		<c:import url="../template/header.jsp"></c:import>
		
		<c:if test="${mypage.memberFilesVO.fileName ne null}">
			<img alt="" src="../resources/upload/member/${mypage.memberFilesVO.fileName}">
		</c:if>
		<h1>아이디 : ${mypage.id}</h1>
		<h1>이름 : ${mypage.name}</h1>
		<h1>이메일 : ${mypage.email}</h1>
		<h1>전화번호 : ${mypage.phone}</h1>
		<a href="../member/mypageUpdate" type="button" class="col-2 btn btn-outline-primary">개인정보 수정</a>
		<a href="../member/withdrawal" type="button" class="col-2 btn btn-outline-primary">회원탈퇴</a>
	</div>

</body>
</html>