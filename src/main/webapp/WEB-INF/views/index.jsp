<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>index</title>
</head>
<body>
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
	
	<div class="container">
		<input type="text" id="d1">
		<button id="btn">Click</button>
		<button id="btn2">Click2</button>
		<input type="checkbox" name="ch" class="ch" value="1">
		<input type="checkbox" name="ch" class="ch" value="2">
		<input type="checkbox" name="ch" class="ch" value="3">
		<input type="checkbox" name="ch" class="ch" value="4">
		<button id="btn3">Click3</button>
		<div id="result">
			
		</div>
	</div>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$("#btn2").click(function(){
		alert("click");
		$(".ch").each(function(idx, item){
			console.log("Index : ", idx);
			console.log("Item : ", item);
			console.log("Value : ", $(item).val());
		});
	});

	$("#btn").on("click", function(){
		alert("jquery");
		console.log($("#d1").val());
	});
	/* $(".ch").click(function(){
		console.log(this.value);
	});
	 */
	/* $(".ch").on({
		click:function(){
			console.log("click");
		},
		change:function(){
			console.log("change");
		}
	}); */
	$(".ch").click(function(e){
		if($(this).prop("checked")){
			console.log("check");
		} else{
			console.log("uncheck");
		}
		/* let v = $(this).val();
		console.log("click Test");
		console.log(v); */
	});
	$(".ch").change(function(){
		console.log("change Test");
	});
	
	$("#btn3").click(function(){
		$("#result").append('<input type="checkbox" name="ch" class="ch" value="1">');
	})
</script>
</html>