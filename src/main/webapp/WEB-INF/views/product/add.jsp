<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>ADD</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
		
	
</head>
<body>
	<div class="container mt-4">
		
		<c:import url="../template/header.jsp"></c:import>
		
		<div class="row" id="list">
		<!-- ajax로 제품리스트 받아오는 구역 -->	
		</div>
		
		<form action="./add" method="post" enctype="multipart/form-data" id="frm">
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">제품명</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productName" name="productName">
				</div>
			</div>
			<div class="mt-3 mb-3 row">
				<label class="col-sm-2 col-form-label">가격</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productPrice" name="productPrice">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">수량</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="productCount" name="productCount"></input>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">상세설명</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="productDetail" name="productDetail" rows="5"></textarea>
				</div>
			</div>
			<div class="mb-3 row">
				<div class="form-check">
				  <input class="form-check-input sale" type="radio" value="1" name="sale" id="flexCheckDefault">
				  <label class="form-check-label" for="flexCheckDefault">
				    판매
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input sale" type="radio" value="0" name="sale" id="flexCheckDefault" checked>
				  <label class="form-check-label" for="flexCheckDefault">
				    판매중지
				  </label>
				</div>
			</div>
			<div>
				<div id="fileResult">
					
				</div>
				<button id="fileAdd" type="button" class="col-2 btn btn-outline-primary">File ADD</button>
				<a href="./list" type="button" class="col-1 btn btn-outline-primary">List</a>
				<button id="add" type="button" class="col-1 btn btn-outline-primary">Add</button>
			</div>
		</form>
	</div>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript">
	summernoteInit("productDetail", "");
	fileAddInit(0);
	fileDeleteInit();

	// let pn = 1;
	
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

	$('#productDetail').summernote({
		height: 300
	});
	
	
	
	$("#add").click(function(){
		let formData = new FormData();
		let productName = $("#productName").val();
		let productPrice = $("#productPrice").val();
		let productCount = $("#productCount").val();
		let productDetail = $("#productDetail").summernote("code"); // $("#productDetail").val();
		let sale = 0;
		$(".sale").each(function(idx, item){
			if($(item).prop("checked")){
				sale = $(item).val();
			}
		})
		$("#files").each(function(idx, item) {
			if(item.files.length > 0){
				console.log(idx);
				console.log(item);
				console.log(item.files);
				console.log(item.files[0]);
				console.log("length : " + item.files[0].length);
				console.log(item.files[0].name);
				// formData.append("파라미터명", 값);
				formData.append("files", item.files[0]);
			}
		}); // each 끝
		
		formData.append("productName", productName);
		formData.append("productPrice", productPrice);
		formData.append("productCount", productCount);
		formData.append("productDetail", productDetail);
		formData.append("sale", sale);
		
		$.ajax({
			type : "post",
			url : "./add",
			processData : false,
			contentType : false,
			data : formData /* {
				productName : productName,
				productPrice : productPrice,
				productCount : productCount,
				productDetail : productDetail,
			} */,
			
			success : function(data){
				if(data.trim()=='1'){
					alert("상품 등록 완료");
					getList();
					$("#productName").val("");
					$("#productPrice").val("");
					$("#productCount").val("");
					$("#productDetail").summernote("code", "");
				} else{
					alert("상품 등록 실패");
				}
				/* console.log(data.trim()); */
			},
			
			error : function(){
				alert("error 발생");
			}
		});
	});
	
	
</script>
</body>
</html>