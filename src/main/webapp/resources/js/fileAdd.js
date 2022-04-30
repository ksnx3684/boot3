/**
 * 
 */
 let count = 0;
 
 	function fileDeleteInit(){
	
		$(".del").click(function(){
			let check = window.confirm("삭제 하시겠습니까?")
			let fileNum = $(this).attr("data-num");
			let selector = $(this);
			if(check){
				$.ajax({
					type: "post",
					url: "./fileDelete",
					data: {
						fileNum : fileNum
					},
					
					success: function(data){
						if(data.trim()=='1'){
							$(selector).parent().remove();
							count--;
						} else{
							alert("파일 삭제 실패");
						}	
					},
					error: function(){
						alert("파일 삭제 실패");
					}
				});
			}	
		});
	
	}
 
 
	function fileAddInit(c){
		
		count = c;
	
		$("#fileAdd").click(function(){
			if(count < 5){
				$("#fileResult").append('<div class="files"><input type="file" id="files" name="files"><button type="button" class="del">X</button></div>');
				count++;
			} else{
				alert("5개 초과");
			}
		});
		
		$("#fileResult").on("click", ".del", function(){
			$(this).parent().remove();
			count--;
		});
		
	}
 
 	