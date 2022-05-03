<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Join</title>
</head>
<body>
	<div class="container mt-4">
		
		<c:import url="../template/header.jsp"></c:import>
		
		<!-- <form action="./join" method="post" enctype="multipart/form-data"> -->
		<form:form modelAttribute="memberVO" method="post" enctype="multipart/form-data">
			<div class="main">
				<div class="form-check">
					<input class="form-check-input checkAll" type="checkbox" id="checkAll" value="1">
					<label class="form-check-label" for="checkAll">
				    checkAll
					</label>
				</div>
				<div class="form-check">
					<input class="form-check-input ch" type="checkbox" id="check1" value="2">
					<label class="form-check-label" for="check1">
				   	check1
					</label>
				</div>
				<div class="form-check">
					<input class="form-check-input ch" type="checkbox" id="check2" value="3">
					<label class="form-check-label" for="check2">
				   	check2
					</label>
				</div>
				<div class="form-check">
					<input class="form-check-input ch" type="checkbox" id="check3" value="4">
					<label class="form-check-label" for="check3">
				   	check3
					</label>
				</div>
			
				<div>
					<label>아이디</label>
					<form:input path="id" cssClass="form-control" id="id" placeholder="id"/>
					<div>
						<form:errors path="id"></form:errors>
						<form:errors path="checkId"></form:errors>
					</div>
				</div>
				<div>
					<label>비밀번호</label>
					<form:password path="pw" cssClass="form-control" id="pw" placeholder="pw"/>
					<div>
						<form:errors path="pw"></form:errors>
					</div>
				</div>
				<div>
					<label>비밀번호 확인</label>
					<form:password path="checkPw" cssClass="form-control" id="checkPw" placeholder="checkPw"/>
					<div>
						<form:errors path="checkPw"></form:errors>
					</div>
				</div>
				<div>
					<label>이름</label>
					<form:input path="name" cssClass="form-control" id="name" placeholder="이름"/>
					<div>
						<form:errors path="name"></form:errors>
					</div>
				</div>
				<div>
					<label>이메일</label>
					<form:input path="email" cssClass="form-control" id="email" placeholder="이메일"/>
					<div>
						<form:errors path="email"></form:errors>
					</div>
				</div>
				<div>
					<label>전화번호</label>
					<form:input path="phone" cssClass="form-control" id="phone" placeholder="전화번호"/>
					<div>
						<form:errors path="phone"></form:errors>
					</div>
				</div>
				<div>
					<label>프로필사진</label>
					<input type="file" name="multipartFile">
				</div>
				<div>
					<button type="submit" class="btn btn-outline-success">가입</button>
				</div>
			</div>
		</form:form>
	</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	/* $(".checkAll").click(function(){
		if($(this).prop("checked")){
			$(".ch").prop("checked", true);
		} else{
			$(".ch").prop("checked", false);
		}
	}); */
	$("#checkAll").click(function(){
		$(".ch").prop("checked", $("#checkAll").prop("checked"));
	});
	
	$(".ch").on("click", function(){
		let check = true;
		$(".ch").each(function(idx, item){
			if(!$(item).prop("checked")){
				check = false;
			}
		});
		$("#checkAll").prop("checked", check);
	});
</script>


</html>