<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset = "utf-8">
		<title>user zone</title>
		<style type="text/css">
		body
		{
			background-color: red;
		}
		li
		{
			display: block;
			padding-left: 10px;
		}
		li a
		{
			color: white;
			font-size: 18px;
			line-height: 34px;
			text-decoration: none;
		}
		</style>

	</head>
	
	<body>
		<li><a href="setting.jsp" target="showFrame" id = "inform" onclick = "changeColor1()">个人信息</a></li>
		<li><a href="myOrder.jsp?id=${sessionScope.loginedUser.user_id }" target="showFrame" id = "order" onclick = "changeColor2()">我的订单</a></li>
		<li><a href="ResetPwd.jsp" target="showFrame" id = "screte" onclick = "changeColor3()">修改密码</a></li>

		<script type="text/javascript">
		function changeColor1()
		{
			document.getElementById('inform').style.color = "#000066";
			document.getElementById('order').style.color = "white";
			document.getElementById('screte').style.color = "white";
		}
		function changeColor2()
		{
			document.getElementById('inform').style.color = "white";
			document.getElementById('order').style.color = "#000066";
			document.getElementById('screte').style.color = "white";
		}
		function changeColor3()
		{
			document.getElementById('inform').style.color = "white";
			document.getElementById('order').style.color = "white";
			document.getElementById('screte').style.color = "#000066";
		}
		</script>
	</body>
</html>