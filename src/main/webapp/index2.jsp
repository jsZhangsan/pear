<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-1.12.0.js"></script>
<script type="text/javascript">

	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	function addUser() {
		console.log($("#form1").serializeObject());
		$("#form1").submit();
		/* $.ajax({
			type : "POST",
			url : $("#path").val() + "user/addUser",
			data : $("#form1").serializeObject(),
			dataType : "json",
			async : true,
			success : function(data) {

			},
			error : function() {

			}
		}); */
	}
</script>
</head>
<body>123
	<input type="text" value="<%=path%>" id="path"/> 
	<img alt="1" src='<%=path%>/resources/img/1.png' />
	<form id="form1" action="<%=path%>/user/addUser2" method="post">
	<input type="text" name="userName" value=""/>
	<input type="text" name="passWord" value=""/>
	<input type="text" name="birthday" value=""/>
	<input type="button" value="保存" onclick="addUser()"/>
	</form>
</body>
</html>