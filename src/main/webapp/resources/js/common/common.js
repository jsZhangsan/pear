$PATH = "/pear"
//jquery动态异步加载页面(url：action路径，params：json形式参数，container：加载页面的div id, method:post，get...)
function loadContentSync(url, params, container, method, reloadFlag) {
	var div = "<div id='o'><div class='loaddiv'></div><img class='loadimg' src='"+$PATH+"/resources/img/1.png'/></div>";
	
	if (!container) {
		container = "container";
	}
	
	if (!method) {
		method = "post";
	}
	
	if (reloadFlag == undefined) {
		reloadFlag = true;
	}
	
	// 加载动画
	$("#" + container).append(div);
	var h = $(document).height() + 85;		
	$(".loaddiv").height(h);
	
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
			$("#o").remove();
			//$CommonUI.alert("信息加载失败！");
			//console.error(">>>>>>>>>>>>>>>>>>>>>>>>>", XMLHttpRequest, textStatus, errorThrown);
			
			if (reloadFlag) {
				loadContentSync(url, params, container, method, false);
			}
		}
	});
}