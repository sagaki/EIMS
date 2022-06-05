// 声明变量
var usernameObj;
var usernameMsg;
var phoneObj;
var phoneMsg;
var nameObj;
var nameMsg;
var purviewObj;
var purviewMsg;
var passwordObj;
var passwordMsg;
var confirmObj;
var confirmMsg;
var emailObj;
var emailMsg;

// 页面加载之后 获取页面中的对象
window.onload = function () {
	usernameObj = document.getElementById("username");
	usernameMsg = document.getElementById("usernameMsg");
	phoneObj = document.getElementById("phone");
	phoneMsg = document.getElementById("phoneMsg");
	nameObj = document.getElementById("name");
	nameMsg = document.getElementById("nameMsg");
	purviewObj = document.getElementById("purview");
	purviewMsg = document.getElementById("purviewMsg");
	passwordObj = document.getElementById("password");
	passwordMsg = document.getElementById("passwordMsg");
	confirmObj = document.getElementById("confirm");
	confirmMsg = document.getElementById("confirmMsg");
	emailObj = document.getElementById("email");
	emailMsg = document.getElementById("emailMsg");
}

// 校验添加表单
function checkAddEmp() {
	var bUsername = checkUsername();
	var bPhone = checkPhone();
	var bName = checkName();
	var bPassword = checkPassword();
	var bPurview = checkPurview();
	var bEmail = checkEmail();
	return bUsername && bPhone && bName && bPassword && bPurview && bEmail;
}

// 校验更新表单
function checkUpdateEmp() {
	var bUsername = checkUsername();
	var bPhone = checkPhone();
	var bName = checkName();
	var bPurview = checkPurview();
	var bEmail = checkEmail();
	return bUsername && bPhone && bName && bPurview && bEmail;
}

// 校验登录表单
function checkLogin() {
	var bUsername = checkLoginUsername();
	var bPassword = checkLoginPassword();
	return bUsername && bPassword;
}

// 校验注册表单
function checkRegister() {
	var bUsername = checkUsername();
	var bPhone = checkPhone();
	var bEname = checkName();
	var bPassword = checkPassword();
	var bConfirm = checkConfirm();
	var bEmail = checkEmail();
	return bUsername && bPhone && bEname && bPassword && bConfirm && bEmail;
}

// 验证员工登陆用户名
function checkUsername() {
	var regex = /^[a-zA-Z_]\w{0,9}$/;
	var value = usernameObj.value;
	var msg = "";
	if (!value)
		msg = "用户名必须填写！";
	else if (!regex.test(value))
		msg = "用户名不合规！";
	usernameMsg.innerHTML = msg;
	usernameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证员工手机号
function checkPhone() {
	var regex = /^1[3456789]\d{9}$/;
	var value = phoneObj.value;
	var msg = "";
	if (!value)
		msg = "电话号码必须填写！";
	else if (!regex.test(value))
		msg = "电话号码不合规！";
	phoneMsg.innerHTML = msg;
	phoneObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证员工姓名
function checkName() {
	var regex = /^[\u4e00-\u9fa5]{1,10}$/;
	var value = nameObj.value;
	var msg = "";
	if (!value)
		msg = "员工姓名必须填写！";
	else if (!regex.test(value))
		msg = "姓名不合规！";
	nameMsg.innerHTML = msg;
	nameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证员工权限
function checkPurview() {
	var value = purviewObj.value;
	var msg = "";
	if (!value) {
		msg = "必须填写员工的权限！";
	} else if (value == "普通员工") {
		msg = "";
	} else if (value == "管理员") {
		msg = "";
	} else {
		msg = "权限填写不合规！";
	}
	purviewMsg.innerHTML = msg;
	purviewObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证重复密码
function checkConfirm() {
	var passwordValue = passwordObj.value;
	var confirmValue = confirmObj.value;
	var msg = "";
	if (!confirmValue) {
		msg = "确认密码必须填写！";
	} else if (passwordValue != confirmValue) {
		msg = "密码必须保持一致！";
	}
	confirmMsg.innerHTML = msg;
	confirmObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证密码
function checkPassword() {
	var regex = /^.{6,20}$/;
	var value = passwordObj.value;
	var msg = "";
	if (!value) {
		msg = "密码必须填写！";
	} else if (!regex.test(value)) {
		msg = "密码不合规！";
	}
	passwordMsg.innerHTML = msg;
	passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证登录用户名是否空
function checkLoginUsername() {
	var value = usernameObj.value;
	var msg = "";
	if (!value) {
		msg = "用户名必须填写！"
	}
	usernameMsg.innerHTML = msg;
	usernameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证密码是否空
function checkLoginPassword() {
	var value = passwordObj.value;
	var msg = "";
	if (!value) {
		msg = "登陆密码必须填写！";
	}
	passwordMsg.innerHTML = msg;
	passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

// 验证员工邮箱
function checkEmail() {
	var regex = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
	var value = emailObj.value;
	var msg = "";
	if (!value) {
		msg = "邮箱必须填写！";
	} else if (!regex.test(value)) {
		msg = "邮箱不合规！";
		if (value.length <= 30) {
			msg = "邮箱长度过长！";
		}
	}
	emailMsg.innerHTML = msg;
	emailObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}