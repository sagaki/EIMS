<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
<link href="${pageContext.request.contextPath}/css/all.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/action.js"></script>
</head>
<body align="center">
	<div>
		<h2>
			员工信息列表
			<button>
				<a href="${pageContext.request.contextPath}/main">返回 </a>
			</button>
		</h2>
	</div>
	<div>
		<h3>
			<form action="${pageContext.request.contextPath}/main/emp/empInfo"
				method="post">
				<label>员工姓名</label> <input type="text" name="username"
					placeholder="${empName}" /> <input type="submit" value="查询">
			</form>
		</h3>
	</div>
	<table align="center">
		<tr>
			<th>员工姓名</th>
			<th>员工电话</th>
			<th>员工邮箱</th>
			<th>员工权限</th>
		</tr>
		<c:forEach var="emp" items="${emps}">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.phone}</td>
				<td>${emp.email}</td>
				<td>${emp.purview}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>