<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异步demo</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript">
	function getUserList() {
		var url = $("#path").val() + "/user/getUserList";
		var params = {};
		loadContentSync(url, params, 'userList');
	}

	$(function() {
		getUserList()
	});
</script>
</head>
<body>
	用户表
	<div id="userList"></div>
</body>
</html>