var CaptchFB = function () {
	var clickFlag = 0;
	var time = 2000;
	var timeClick = 4000;
	var count = 0;
	var sendRequestCaptch = function(){
		count++;
		var href = $(this).attr('src');
		if(clickFlag === 0){
			$(this).attr('src',href + "&tm=" + Math.random());
			clickFlag = 1;
			window.setTimeout(function(){
				clickFlag = 0;
				count = 0;
			},time);
			window.setTimeout(function(){
				if(count >= 5){
					$('.alert-error').find('span[data-close=alert_value]').html("不要点的这么频繁喵!");
	                $('.alert-error', $('.login-form')).show();
	                clickFlag = 1;
	                time++;
				}
			},timeClick);
		}
		
	}
     $(document).on("click","img[data-captch]",sendRequestCaptch);
    return {
        init: function () {
        	sendRequestCaptch();
        }

    };

}();