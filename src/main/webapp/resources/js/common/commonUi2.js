function Dialog(){
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
	
	appendAlert : function (msg, title, okText, okFun, flag, cancleText, cancleFun, showCloseBut) {
		
		if (showCloseBut == undefined) {
			showCloseBut = true;
		}
		
		var div = '<div id="_alert_div_" class="_outer_alert w350 bg_color_gray2 border_r2">';
		
		if(showCloseBut){
			div += '<p class="pl15 pr15 pt10 clearfix"><a class="index_image close cp fr"></a></p>';
		}
		else{
			div += '<p class="pl15 pr15 pt10 clearfix">&nbsp;</p>';
		}
		
		if (title) {
			div += '<p class="tc f16 font_black2 mt10 fb">' + title + '</p>';
		}
		
		div += '<div class="clearfix mt20 tc pl10 pr10 f16">';
		div += msg;
		div += '</div><div class="pt20 pb20 tc">';
		
		if (okText) {
			div += '<a class="_alert_ok btn btn_blue1 display_i w80 border_r2 f14" href="javascript:void(0)">' + okText + '</a>';
		}
		else {
			div += '<a class="_alert_ok btn btn_blue1 display_i w80 border_r2 f14" href="javascript:void(0)">确定</a>';
		}
		
		if (flag == '1') {
			if (cancleText) {
				div += '<a class="_alert_cancle btn btn_gray display_i w80 border_r2 f14 ml20" href="javascript:void(0)">' + cancleText + '</a>';
			}
			else {
				div += '<a class="_alert_cancle btn btn_gray display_i w80 border_r2 f14 ml20" href="javascript:void(0)">取消</a>';
			}
		}
		
		div += '</div></div>';
		//$("body").append(div);
		
		//var o = $("#_alert_div");
		var o = $(div).appendTo($("body"));
		
		$("._outer_alert .close,._outer_alert ._alert_ok,._outer_alert ._alert_cancle").click(function() {
			console.log($(o).html());
			$(o).remove();
			
			var flag = 0;
			$("._outer_alert").each(function() {
				if (!$(this).is(":hidden")) {
					flag = 1;
					return false;
				}
			});
			
			if (flag == 0) {
				$("#alert_background_layer").hide();
			}
		});
		
		if (typeof okFun === 'function') {
			o.find("._alert_ok").click(function() {
				okFun.call();
			});
		}
		
		if (typeof cancleFun === 'function') {
			o.find("._alert_cancle").click(function() {
				cancleFun.call();
			});
		}
		
		var modal_height=o.outerHeight();
		var modal_width=o.outerWidth();
		
		$("#alert_background_layer").css({"display":"block",opacity:0});
		$("#alert_background_layer").fadeTo(200, 0.5);
		o.css({"display":"block","position":"fixed","opacity":0,"z-index":1000001,"left":50+"%","top":50+"%","margin-left":-(modal_width/2)+"px","margin-top":-(modal_height/2)+"px"});o.fadeTo(200,1);													
	},
	
	alert : function(msg, title, okFun, showCloseBut) {
		this.addbackground();
		this.appendAlert(msg, title, null, okFun, null, null, null,showCloseBut); 
	},
	
	confirm : function(msg, title, okFun, okText, cancleFun, cancleText) {
		this.addbackground();
		this.appendAlert(msg, title, okText, okFun, '1', cancleText, cancleFun); 
	},
	
	openWindow : function(id, title, showCloseBut) {
		
		if (showCloseBut == undefined) {
			showCloseBut = true;
		}
		
		this.addbackground();
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