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
<title>框架demo</title>
<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.12.0.js"></script>
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
		$.ajax({
			type : "POST",
			url : $("#path").val() + "/user/adu",
			data : $("#form1").serializeObject(),
			dataType : "json",
			async : true,
			success : function(data) {
				if(data.success = true){
					getUserList();
				}
			},
			error : function() {
				alert();
			}
		});
	}

	function getUserList() {
		$.ajax({
			type : "get",
			url : $("#path").val() + "/user/getUserList",
			data : {"map.nowPage":1},
			dataType : "json",
			async : true,
			success : function(data) {
//console.log(JSON.stringify(data));
				if(data.success = true){
					showUserList(data.rows);
				}
			},
			error : function() {

			}
		});
	}
	
	function showUserList(rows) {
		var htmlStr = "";
		for(var i = 0; i < rows.length; i++){
			htmlStr = htmlStr 
			+ "<tr><td>"+rows[i].id+"</td><td>"+rows[i].user_name+"</td><td>"
			+rows[i].pass_word+"</td><td>"+rows[i].birthday+"</td></tr>";
		}
		
		$("#tbody").html(htmlStr);
	}

	$(function() {
		getUserList()
	});
</script>
</head>
<body>
	<input id="path" type="text" value="<%=path%>">

	<img alt="1" src='<%=path%>/resources/img/1.png' />
	<form id="form1">
		账号:<input type="text" name="userName" value="" /> <br /> 
		密码:<input type="text" name="passWord" value="" /> <br /> 
		年龄:<input type="text" name="birthday" value="" /> <br /> 
		余额:<input type="text" name="money" value="" /> <br /> 
		<input type="button" value="保存" onclick="addUser()" />
	</form>

	<table style="border: 5px solid red;">
		<thead>
			<tr>
				<td>id</td>
				<td>账号</td>
				<td>密码</td>
				<td>年龄</td>
				<td>余额</td>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
</body>
</html>