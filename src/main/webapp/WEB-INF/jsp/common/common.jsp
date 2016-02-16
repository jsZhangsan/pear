<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript" src="<%=path%>/resources/js/jquery-1.12.0.js"></script>
<link href="<c:url value='/css/base.css'/>" rel="stylesheet" type="text/css" media="screen" />
