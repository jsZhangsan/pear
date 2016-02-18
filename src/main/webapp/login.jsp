<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
	<a href="<c:url value='/user/showUser'/>">异步demo</a>
	<a href="<c:url value='/user/register'/>">注册</a>
	<a href="<c:url value='/index.html'/>">进入官网</a>
	<ul>
		<li><label>用户名</label><input name="username" type="text"/></li>
		<li><label>密 码</label><input name="password" type="password"/></li>
		<li><input type="submit" value="登录" /></li>
	</ul>
</body>
</html>