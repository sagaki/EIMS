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
		<h2>${emp.name}员工信息</h2>
	</div>
	<table align="center">
		<tr>
			<th>编号</th>
			<th>员工姓名</th>
			<th>员工电话</th>
			<th>员工邮箱</th>
			<th>员工权限</th>
			<th>用户名</th>
			<th>操作</th>
		</tr>
		<c:if test="${emp!=null}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.phone}</td>
				<td>${emp.email}</td>
				<td>${emp.purview}</td>
				<td>${emp.username}</td>
				<td>
					<form
						action="${pageContext.request.contextPath}/main/admin/deleteEmp?id=${emp.id}"
						method="post" onsubmit="return checkAction();">
						<button>
							<a
								href="${pageContext.request.contextPath}/main/admin/toUpdateEmp?id=${emp.id}">
								更新 </a>
						</button>
						<input type="submit" value="删除">
					</form>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="7">
				<button>
					<a href="${pageContext.request.contextPath}/main/admin/allEmp">返回
					</a>
				</button>
			</td>
		</tr>
	</table>
</body>
</html>