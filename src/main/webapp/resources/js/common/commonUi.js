function Dialog(){
	var options = {
			id : ((new Date()).getMilliseconds()),
			title : "",
			showCloseBtn : true
	};
}

Dialog.prototype = {
	/**
	 * 加载背景色
	 */
	addbackground : function () {
		if ($("#alert_background_layer").length == 0) {
			$("body").append("<div id='alert_background_layer'></div>");
			$("#alert_background_layer").css({"position":"fixed","z-index":"1000000","top":"0px","left":"0px","width":"100%","height":"100%","background":"#000","display":"none"});
		}
	},
	
	openWindow : function() {
		var o = null;
		
		if ($("#_outer_" + id).length == 0) {
			$("#" + id).show().wrap('<div id="_outer_' + id + '" class="_outer_win bg_color_gray2 display_n border_r2"></div>');
			o = $("#_outer_" + id);
			
			if (title) {
				o.prepend('<p class="tc f26 font_black2">' + title + '</p>');
			}
			
			if (showCloseBut) {
				o.prepend('<p class="pl15 pr15 pt10 clearfix"><a class="index_image close cp fr"></a></p>');
			}
			
			o.width($("#" + id).outerWidth(true));
		}
		else {
			o = $("#_outer_" + id);
		}
		
		var ui = this;
		o.find(".close").click(function() {
			
			ui.closeWindow(id);
			/*$(o).fadeOut(200);
			$("#dialog_background_layer").fadeOut(200);*/
		});
		
		var modal_width=o.outerWidth();
		var modal_height=o.outerHeight();
		
		o.css("min-height", modal_height + 2);
		
		if (modal_height > $(window).height()) {
			modal_height = $(window).height();
		}
		
		$("#dialog_background_layer").css({"display":"block",opacity:0});
		$("#dialog_background_layer").fadeTo(200, 0.5);
		o.css({"display":"block","position":"fixed","opacity":0,"z-index":999991,"left":50+"%","top":50+"%","margin-left":-(modal_width/2)+"px","margin-top":-(modal_height/2)+"px"});o.fadeTo(200,1);
	},
	
	closeWindow : function(id, closeFun) {
		var o = $("#_outer_" + id);
		o.hide();
		var flag = 0;
		
		$("._outer_win").each(function() {
			if (!$(this).is(":hidden")) {
				flag = 1;
				return false;
			}
		});
		
		if (flag == 0) {
			$("#dialog_background_layer").hide();
		}
		
		if (closeFun != undefined && (typeof closeFun === 'function')) {
			closeFun.call();
		}
	}
};

var $UI = new Dialog();