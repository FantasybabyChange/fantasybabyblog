#macro(initTaboolaData )
    #set ($is_infinite = false)
    #set ($is_responsive = false)
    #set ($taboolaDeskScript = false)
    #set ($taboolaMobileScript = false)
    #set ($taboolaTabletScript = false)
    #set ($taboolaDataScript = false)
    #set ($moduleDesignHtml = false)
    #set ($parentDivId = false)
    #if($design_div_id && $design_div_id.data.length() > 0)
      #set ($parentDivId = $design_div_id.data)
      #set ($moduleDesignHtml = $design_html.data)
    #end
    #if ($isInfinite && $isInfinite.data == 'true')
        #set ($is_infinite = true)
    #else
        #set ($is_infinite = false)
    #end

    #if ($isResponsive && $isResponsive.data == 'non_responsive')
        #if(!$taboolaDataScript)
          #set ($taboolaDataScript = $isResponsive.non_responsive.taboolaData.tablooa_script.data)
        #end
        #set ($is_responsive = false)
    #else
        #set($taboolaDataList = $isResponsive.responsive.taboolaData.getSiblings())
        #foreach($taboolaDataObj in $taboolaDataList)
            #if($taboolaDataObj.renderOn.data == 'Desktop')
              #if(!$taboolaDeskScript)
                #set ($taboolaDeskScript = $taboolaDataObj.tablooa_responsive_script.data)
              #end
            #elseif($taboolaDataObj.renderOn.data == 'Mobile')
              #if(!$taboolaMobileScript)
                #set ($taboolaMobileScript = $taboolaDataObj.tablooa_responsive_script.data)
              #end
            #elseif($taboolaDataObj.renderOn.data == 'Tablet')
              #if(!$taboolaTabletScript)
                #set ($taboolaTabletScript = $taboolaDataObj.tablooa_responsive_script.data)
              #end
            #end
        #end
      #set ($is_responsive = true)
    #end
    
    ##init taboola ad
    #if($is_display_ad && $is_display_ad.data==true)
		#set($adModules = $articleUtil.getArticlesFromJson($getterUtil.getLong($groupId), $ad_instance.data))
		#set($adArticleId = "$!adModules[0].data.articleId")
		#set($adPortletId = $request.portlet-namespace + $adArticleId)
		#getRequestAttribute("THEME_DISPLAY")
		#set($objThemeDisplay = $requestAttributeValue)
		#set($adObject = $journalContentUtil.getDisplay($getterUtil.getLong($groupId), $adArticleId, "", "view", $request.theme-display.language-id, $objThemeDisplay, 0, $xmlRequest))
	#end
#end

#macro(rednerTaboolaScript)
	<script>
		(function($, A){
			$(document).ready(function() {
				window.taboolaFn["showTaboola_$parentDivId"].apply(this);
				var countWithDebounce = fox.utils.debounce(function() {
					if (Math.ceil($(document).scrollTop()) >= $(document).height() - $(window).height()) {
						window.taboolaFn["showTaboola_$parentDivId"].apply(this);
					}
				}, 500);
				
				#if($is_infinite)
					window.addEventListener('scroll', function() {
						countWithDebounce();
					});
				#end
			});
		})( jQuery, AUI() );
    </script>
    #if($parentDivId) 
       $moduleDesignHtml
    #else
       <div id="taboolaContainerDiv"></div>
    #end
    ##hidden place
    #if($taboolaDataScript && $adObject.content)
        #set($taboolaDataScript = $taboolaDataScript.replace("Serve Local Ad Unit Here","$adObject.content"))
	#else
		#set($taboolaDataScript = $taboolaDataScript.replace("Serve Local Ad Unit Here",""))
    #end
  <div style="display:none;"id="common_${parentDivId}">$!taboolaDataScript</div>
  <div style="display:none;"id="mobile_common_${parentDivId}">$!taboolaMobileScript</div>
  <div style="display:none;"id="desktop_common_${parentDivId}">$!taboolaDeskScript</div>
  <div style="display:none;"id="tablet_common_${parentDivId}">$!taboolaTabletScript</div>
#end

#macro(initTaboolaScript)
    <script type="text/javascript">
		(function($, A){
				window.taboolaFn = window.taboolaFn || [];
				//window.scopeContainerIds = window.scopeContainerIds || [];
				window.scopeCounter = window.scopeCounter || [];
				window._taboola = window._taboola || [];
				window.scopeCounter['$parentDivId'] = 0;
				//window.scopeContainerIds['$parentDivId'] = [];
				var commonDiv;
				
				window.taboolaFn["showTaboola_$parentDivId"] = function() {
					/* Add to Google Tag Manager command chain to ensure commands happen in order */
					googletag.cmd.push(function() {
						window.scopeCounter['$parentDivId']++;
						if (window.scopeCounter['$parentDivId'] === 1) {
							#if($is_responsive)
								if (EP.Clients.FOX.Utils.Fn.isMobile(document.body.clientWidth)) {
									commonDiv = $("#mobile_common_${parentDivId}");
								} else if (EP.Clients.FOX.Utils.Fn.isTablet(document.body.clientWidth)) {
									commonDiv = $("#tablet_common_${parentDivId}");
								} else {
									commonDiv = $("#desktop_common_${parentDivId}");
								}
							#else
								commonDiv = $("#common_${parentDivId}");
							#end
						}
						var cloneCommon = commonDiv.clone();
						var childDivs = cloneCommon.children('div');
						var newChildDivs = [];
						###No Velocity Parse START
						#[[
						$.each(childDivs, function(idx1, childObj) {
							var $childObj = $(childObj);
							if ($childObj.attr('class') == 'grid-items') {
								var firstChildDivs = $childObj.children('div');
								$.each(firstChildDivs, function(idx2, firstChildObj) {
									var $firstChildObj = $(firstChildObj);
									if ($firstChildObj.attr('class') == 'grid-item' && !$firstChildObj.attr('id')) {
										var childChildDiv = $firstChildObj.children('div');
										if (childChildDiv) {
											$.each(childChildDiv, function(idx3, childChildObj) {
												newChildDivs.push(childChildObj);
											});
										}
									} else {
										newChildDivs.push(firstChildObj);
									}
								})
							} else {
								newChildDivs.push(childObj);
							}
						});
						]]# ###No Velocity Parse END

						if (newChildDivs.length > 0) {
							var count = 0;
							$.each(newChildDivs, function(index, childObj) {
								var divId = childObj.getAttribute("id");
								if (divId && divId != null && divId != 'null') {
									if(window.scopeCounter['$parentDivId'] >= 1){
										childObj.setAttribute("id", divId + "_" + window.scopeCounter['$parentDivId']);
										#if($adPortletId)
											var adsDiv = childObj.innerHTML;
											adsDiv = adsDiv.replace(/$!{adPortletId}/g, "$!{adPortletId}_" + window.scopeCounter['$parentDivId']);
											var posIndex = (window.scopeCounter['$parentDivId'] - 1) % 4 + 1;
											adsDiv = adsDiv.replace(/taboola1/g, "taboola" + posIndex);
											childObj.innerHTML = adsDiv;
										#end
									}
								} else {
									//window.scopeContainerIds['$parentDivId'][count] = "${parentDivId}child" + count + "_" + window.scopeCounter['$parentDivId'];
									childObj.setAttribute("id", '${parentDivId}_'+count+'_'+scopeCounter['${parentDivId}']);
									count++;
								}
							});
							cloneCommon.attr("id", "common_${parentDivId}" + window.scopeCounter['$parentDivId']);
							$("#$parentDivId").append(cloneCommon.html());
							if(window.scopeCounter['$parentDivId'] >= 1){
								#if(!$enableInitialLoad)
									var adContainerId = "$!{adPortletId}_" + window.scopeCounter['$parentDivId'];
									var adSlot = (window.GPTAds && window.GPTAds[adContainerId]) ? window.GPTAds[adContainerId] : false;
									if (adSlot) {
										fox.ads.refreshAds([adSlot], 'Rendering Taboola Ad Slot');
									} else {
										fox.utils.log('No Taboola ad slot found for container '+ adContainerId);
									}
								#end
							}
						}
						/*if( !window.scopeContainerIds['$parentDivId'].length ){
							window.scopeContainerIds['$parentDivId'][0] = '$parentDivId';
						}*/
					});
					
					/* Help sticky plugin now, new content has rendered to recalc height */
					$(window).trigger('reset_sticky_elements');
				}
		})( jQuery, AUI() );
    </script>
#end
#macro(renderTaboola )
  <div class="delay-bg-load">
	  #initTaboolaData()
	  #initTaboolaScript()
	  #rednerTaboolaScript()
  </div>
#end
#if($isNotRenderTaboola)

#else 
  #renderTaboola()
#end