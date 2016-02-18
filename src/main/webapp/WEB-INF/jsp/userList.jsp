<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table style="border: 5px solid red;">
		<thead>
			<tr>
				<td>id</td>
				<td>姓名</td>
				<td>账号</td>
				<td>密码</td>
			</tr>
			<c:forEach items="${list}" var="m">
				<tr>
					<td>${m.id }</td>
					<td>${m.name }</td>
					<td>${m.username }</td>
					<td>${m.password }</td>
				</tr>
			</c:forEach>
	</table>