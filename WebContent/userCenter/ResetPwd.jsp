<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ResetPwd page</title>
	<style type="text/css">
	body
	{
		background-color: #f6ffff;
	}
	li
	{
		font-size: 16px;
		line-height: 34px;
	}
	form
	{
		margin-top: 30px;
		text-align: center;
	}
	</style>
</head>
	
	<body>
		<form action = "../ResetPasswordServlet" method= "post" onsubmit="var result = check(); return result;">
			<li>
				用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名： <input type = "accNum" name = "accNum" value = "${sessionScope.loginedUser.username }" disabled /></li>
			<li>请输入原来密码：<input type="password" name="oldpwd"/></li>
			<li>请输入新的密码：<input type="password" name="newpwd" id = "input1"/></li>
			<li>请再次输入密码：<input type="password" name="confirmpwd" id = "input2"/></li>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type = "submit" name = "submit" value = "提交" onClick = "check()">提交</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type = "reset" name = "reset" value = "重置">重置</button>
		</form>

		<script type="text/javascript">
		function check()
		{ 
			with(document.all)
			{
				if(input1.value!=input2.value)
				{
				alert("两次输入密码不一样，请重新输入！");
				input1.value = "";
				input2.value = "";
				return false;
				}
			else
				document.forms[0].submit();
				return true;
			}
		}
		</script>
	</body>
</html>