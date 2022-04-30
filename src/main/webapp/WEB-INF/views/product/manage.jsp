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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="container mt-4">
		
		<c:import url="../template/header.jsp"></c:import>
		
		<h1>Product manage</h1>
		<a href="./add" type="button" class="col-1 btn btn-outline-primary">Product Add</a>
		
		<div class="row" id="list">
		<!-- ajax로 제품리스트 받아오는 구역 -->
		</div>
		
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
	});
	
	$(".detail").click(function(){
		let num = $(this).attr("data-num");
		location.href="./managerDetail?productNum="+num;
	})
	
	$("#list").on("click", ".pager", function(){
		let checkPn = $(this).attr("data-pn");
		if(checkPn > 0){
			//pn=checkPn;
			getList(checkPn)
		} else {
			// 이전 또는 다음 Block이 X
			alert("마지막 페이지");
		}
	});
	
	getList(1);
	
	function getList(pn){
		$.ajax({
			type : "GET",
			url : "./ajaxList",
			data : {
				pn : pn,
				perPage : 5
			},
			success : function(data){
				$("#list").html(data.trim());
			}
			
		});	
	}

</script>
</body>
</html>