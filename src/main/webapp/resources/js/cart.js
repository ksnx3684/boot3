/**
 * cart
 */
 
 $("#cart").click(function(){
	let productNum = $(this).attr("data-pn");
	let count = 2;
	$.ajax({
		type: "post",
		url: "../cart/" + productNum + "/" + count,
		success:function(data){
			console.log("Data : " + data);
			if(data > 0){
				let check = confirm("장바구니에 상품이 담겼습니다. 장바구니로 이동하시겠습니까?");	
			} else {
				alert("실패");
			}
		}
	});
});
 
 $("#delBtn").click(function(){
	$.ajax({
		type: "DELETE",
		url: "../cart/1",
		success:function(data){
			console.log(data.trim());
		}
	});
})
 
 function cartlist(){
	$.ajax({
		type: "get",
		url: "../cart/2",
		success: function(data){
			console.log(data);
			let r = "<table>"
			console.log(data[0].cartNum);
		}
	})
};