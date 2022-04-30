/**
 * 
 */
 

	function summernoteInit(selector, code){
		$('#'+selector).summernote({
			height: 300
		});
			
		$('#productDetail').summernote('code', code);
	}