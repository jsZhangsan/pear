<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript">
	function addUser() {
		$.ajax({
			type : "POST",
			url : $("#path").val() + "/user/addUser",
			data : $("#form1").serializeObject(),
			dataType : "json",
			async : true,
			success : function(data) {
				if(data.success = true){
					//getUserList();
					alert("注册成功!");
				}
			},
			error : function() {
				alert("请求异常!");
			}
		});
	}
	
	function isHaved() {
		$.ajax({
			type : "POST",
			url : $("#path").val() + "/user/isHaved",
			data : $("#form1").serializeObject(),
			dataType : "json",
			async : true,
			success : function(data) {
				if(data.success == true){
					$("#usernameTs").html("账号已存在!");
				} else {
					$("#usernameTs").html("账号可用!");
				}
			},
			error : function() {
				alert("请求异常!");
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
		//etUserList()
		$("input[name='username']").on("blur",isHaved);
	});
</script>
</head>
<body>
	<img alt="头像" src='<c:url value="/resources/img/1.png"/>' />
	<form id="form1">
		账号:<input type="text" name="username" value="" /><span id="usernameTs"></span> <br /> 
		密码:<input type="text" name="password" value="" /> <br /> 
		密码2:<input type="text" name="password2" value="" /> <br />
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