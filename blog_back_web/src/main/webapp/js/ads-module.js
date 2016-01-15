(function ($) {   

    /**
     * @namespace
     */
    fox.ads = {
        responsiveRefresh : [],
		disableInitialLoadRefresh : [],
		lazyLoad : false
    };
	
	window.googletag = window['googletag'] || {};
	googletag.cmd = googletag['cmd'] || [];

	/**
     * refreshAds
     *
     * @description
     * Takes in array of ad slots and pushes it to Google Tag Manager to refresh those slots.
	 * Refresh is wrapped in googletag.cmd to ensure googletag API is ready when called.
	 * Log message is optional.
     */
    fox.ads.refreshAds = function (adSlotArray, log) {
		googletag.cmd.push(function() { 
			if (adSlotArray && adSlotArray.length) {
				if(log){
					var suffix = '';
					$.each(adSlotArray, function(idx, slot){
						var id = (slot && slot['getSlotElementId']) ? slot.getSlotElementId() : 'INVALID SLOT';
						suffix += ('\n\t['+id+']');
					});
					suffix += ('\n\t\t['+adSlotArray.length+' ad slots]');
					fox.utils.log( log + suffix );
				}
				googletag.pubads().refresh( adSlotArray );
			}
		});
    };

    /**
     * refreshOnResize
     *
     * @description
     * Detects device rotation support and either registers an 'orientationChange' or 'resize' event listener
     * fox.utils.debounce is used to prevent multiple calls from being triggered
     */
    fox.ads.refreshOnResize = function () {
        var detectRotation = typeof window.orientation === 'number',
            eventName = detectRotation ? 'orientationchange' : 'resize',
            logPrefix = detectRotation ? 'Orientation changed, ' : 'Window resized, ',
            LOG_SUFFIX = 'refreshing ads',
            INTERVAL = 500;

        var doRefresh = fox.utils.debounce(function() {
            fox.ads.refreshAds( fox.ads.responsiveRefresh, logPrefix + LOG_SUFFIX );
        }, INTERVAL);

        window.addEventListener(eventName, function () {
           doRefresh(); 
        });
    };
	
	/* Size the ad container only when returned not empty, so page does jump when refreshing ads - FOX-899 */
	var sizeContainer = function( $container, size ){
		var width = '', height = '';
		if( size ){
			width = size[0] + 'px';
			height = size[1] + 'px';
		}
		return $container.css({
			width: width,
			height: height
		});
	};
	
	googletag.cmd.push(function(){
		googletag.pubads().addEventListener('slotRenderEnded', function(e) {
			if( e.slot ){
				window.setTimeout(function(){
					var getVal = function(methodName, args){
						var val;
						try {
							var func = e.slot[methodName];
							val = func.apply(e.slot, args);
						}catch(er){}
						return val;
					};
					var id = e.slot.getSlotElementId(), size = e.size;
					var log = 'AD SLOT RENDERED {';
						log += ('\n\tcontainerId: '+id);
						log += ('\n\tisEmpty: '+e.isEmpty);
						/*log += ('\n\tserviceName: '+e.serviceName);*/
						log += ('\n\tsize: '+size);
						log += ('\n\tadUnitPath: '+ getVal('getAdUnitPath') );
						log += ('\n\tposition: '+ getVal('getTargeting', ['pos']) );
					log += '\n}';
					fox.utils.log( log );
					
					var $container = $('#'+id);
					if( !e.isEmpty && size && $.isArray(size) && size.length===2){
						/* Only size or resize if not empty. If previously sized, and returns empty on refresh, will not collapse. - FOX-899 */
						sizeContainer( $container, size );
					}
					$container.attr('ad-returned-empty', e.isEmpty+'');
				}, 10);
			}
		});
	});

    /* Init on DOM ready */
    $(document).ready(function () {
		fox.ads.refreshOnResize();
	});

})(jQuery);