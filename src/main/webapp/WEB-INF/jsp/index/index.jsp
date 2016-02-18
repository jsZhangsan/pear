<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style>
	body{margin:0;padding:0}
	#s1{height:800px;background:#66C280}
	#s2{height:800px;background:#3B86D8}
	#s3{height:800px;background:#9931B9}
</style>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
	<div>
		<div id="s1" class="pager">1</div>
		<div id="s2" class="pager">2</div>
		<div id="s3" class="pager">333333</div>
	</div>
</body>
</html>