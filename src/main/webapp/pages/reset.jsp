<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
<link href="${pageContext.request.contextPath}/css/all.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/form.js"></script>
</head>
<body align="center">
	<h3>重置账号密码</h3>
	<form action="${pageContext.request.contextPath}/toReset" method="post"
		onsubmit="return checkLoginUsername();">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username"
					onkeyup="checkLoginUsername();"></td>
				<td align="left"><span id="usernameMsg"></span> <font
					color="#999999">请填写需要重置密码的用户名</font></td>
			</tr>
			<tr>
				<div style="color: red";>${msg}</div>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>