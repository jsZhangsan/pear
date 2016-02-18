<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(function() {
		getInfo();
	});
	
	function getInfo(){
		$.ajax({
			type : "post",
			url : $WEB_ROOT_PATH + '/index.htm?BLHMI=getUserInfo',
			data : {},
			async : false,
			dataType : "json",
			success : function(results) {
				if(results.vs != null){
					$("#nologin").css("display","none");
					$("#userInfo").css("display","");
// 					$("#userName").html(results.vs.loginName);
					JO("userName").innerHTML = results.vs.loginName;
				}
			}
		});
	}
	
	function logout(){
		$.ajax({
			dataType:'json',
			type : 'post',
			url : $WEB_ROOT_PATH + '/index.htm?BLHMI=logout',
			success : function(dto){
				window.location.href =$WEB_ROOT_PATH;
			},
			error : function(){
				$CommonUI.alert("退出失败！","error");
			}
		});
	}
</script>
 
<!--top区-->
<div>
	<div>
		<div id="nologin">
			<a href='<c:url value="/index.htm?BLHMI=toLogin"/>'>用户登录</a>
			<a href='<c:url value="/pe/peCtrl.htm?BLHMI=registe"/>'>注册</a>
		</div>
		<div id="userInfo" style="display:none">
			<span class="top_icon user display_i vm"></span>
			<a  href='<c:url value="/"/>' id="userName"></a>
			<a  href='javascript:void(0)' >[退出]</a>
		</div>
					
		<div >
			<a href='<c:url value="/"/>'>
				首页
			</a>
		</div>
	</div>
</div>
