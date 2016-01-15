var CaptchFB = function () {
	var sendRequestCaptch = function(){
		var href = $(this).attr('src');
		$(this).attr('src',href + "&tm=" + Math.random());
	}
     $(document).on("click","img[data-captch]",sendRequestCaptch);
    return {
        init: function () {
        	sendRequestCaptch();
        }

    };

}();