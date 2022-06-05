<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新员工信息</title>
<link href="${pageContext.request.contextPath}/css/all.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/form.js"></script>
</head>
<body align="center">
	<h3>更新员工${emp.name}的信息</h3>
	<form action="${pageContext.request.contextPath}/main/admin/updateEmp"
		method="post" onsubmit="return checkForm();">
		<table align="center">
			<tr>
				<td>员工编号：</td>
				<td><input type="text" value="${emp.id}" disabled="disabled"></td>
				<td align="left"><font color="#999999">不可修改</font></td>
			</tr>
			<tr>
				<td>员工姓名：</td>
				<td><input type="text" name="name" id="name"
					value="${emp.name}" onkeyup="checkName();"></td>
				<td align="left"><span id="nameMsg"></span> <font
					color="#999999">请填写中文，10个字以内</font></td>
			</tr>
			<tr>
				<td>员工电话：</td>
				<td><input type="text" name="phone" id="phone"
					value="${emp.phone}" onkeyup="checkPhone();"></td>
				<td align="left"><span id="phoneMsg"></span> <font
					color="#999999">请填写电话号码</font></td>
			</tr>
			<tr>
				<td>员工邮箱：</td>
				<td><input type="text" name="email" id="email"
					value="${emp.email}" onkeyup="checkEmail()"></td>
				<td align="left"><span id="emailMsg"></span> <font
					color="#999999">请填写邮箱</font></td>
			</tr>
			<tr>
				<td>员工权限：</td>
				<td><input type="text" name="purview" id="purview"
					list="typelist" value="${emp.purview}" onkeyup="checkPurview();">
					<datalist id="typelist">
					<option>管理员</option>
					<option>普通员工</option>
					</datalist></td>
				<td align="left"><span id="purviewMsg"></span> <font
					color="#999999">请填写下拉栏的选项</font></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username"
					value="${emp.username}" onkeyup="checkUsername();"></td>
				<td align="left"><span id="usernameMsg"></span> <font
					color="#999999">用于登陆，字母数字下划线1到10位，不能是数字开头</font></td>
			</tr>
			<tr>
				<div style="color: red";>${msg}</div>
			</tr>
		</table>
		<input type="hidden" name="id" value="${emp.id}"> <input
			type="submit" value="提交">
		<button>
			<a href="${pageContext.request.contextPath}/main/admin/allEmp">取消</a>
		</button>
	</form>
</body>
</html>