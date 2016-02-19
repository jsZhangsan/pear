$PATH = "/pear"
/**
 * jquery动态异步加载页面(url：请求路径，params：json形式参数，container：加载页面的div id, method:post，get...)
 */
function loadContentSync(url, params, container, method, reloadFlag) {
	if (!container) {
		container = "container";
	}
	
	if (!method) {
		method = "post";
	}
	
	if (reloadFlag == undefined) {
		reloadFlag = true;
	}
	
	$.ajax({
		url: url,
		data: params,
		type: method,
		async: true,
		success: function(data){
			$("#" + container).empty();
			$("#" + container).html(data);
		},
		
		error: function (XMLHttpRequest, textStatus, errorThrown) {
			//console.error(">>>>>>>>>>>>>>>>>>>>>>>>>", XMLHttpRequest, textStatus, errorThrown);
			
			if (reloadFlag) {
				loadContentSync(url, params, container, method, false);
			}
		}
	});
}