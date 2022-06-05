<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="${pageContext.request.contextPath}/css/all.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/form.js"></script>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
	font-size: 18px;
}

h4 {
	width: 180px;
	height: 38px;
	margin: 30px auto;
	text-align: center;
	line-height: 38px;
	background: deepskyblue;
	border-radius: 4px;
}
</style>
</head>
<body align="center">
	<h3>员工信息管理系统登录</h3>
	<form action="${pageContext.request.contextPath}/login" method="post"
		onsubmit="return checkLogin();">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username"
					value="${login.username}" onkeyup="checkLoginUsername();"></td>
				<td align="left"><span id="usernameMsg"></span> <font
					color="#999999">请填写用户名</font></td>
			</tr>
			<tr>
				<td>登陆密码：</td>
				<td><input type="password" name="password" id="password"
					value="${login.password}" onkeyup="checkLoginPassword();"></td>
				<td align="left"><span id="passwordMsg"></span> <font
					color="#999999">请填写登录密码</font></td>
			</tr>
			<tr>
				<div style="color: red";>${msg}</div>
			</tr>
		</table>
		<input type="submit" value="登陆">
		<h4>
			<a href="${pageContext.request.contextPath}/toRegister">注册</a>
		</h4>
		<h4>
			<a href="${pageContext.request.contextPath}/reset">忘记密码</a>
		</h4>
	</form>
</body>
</html>