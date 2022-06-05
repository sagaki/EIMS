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
	<form action="${pageContext.request.contextPath}/setPassword"
		method="post" onsubmit="return checkPassword() && checkConfirm();">
		<table align="center">
			<tr>
				<td>登录密码：</td>
				<td><input type="password" name="password" id="password"
					onkeyup="checkPassword();"></td>
				<td align="left"><span id="passwordMsg"></span> <font
					color="#999999">任意字符，6到20位</font></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" id="confirm"
					onkeyup="checkConfirm();"></td>
				<td align="left"><span id="confirmMsg"></span> <font
					color="#999999">重新填写一次密码</font></td>
			</tr>
		</table>
		<input type="hidden" name="username" value="${username}"> <input
			type="submit" value="确认重置">
	</form>
</body>
</html>