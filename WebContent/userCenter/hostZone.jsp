<%@page import="entity.OrderStates" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			margin-left: 10px;
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
	<body bgcolor="999900" text="green">
<%-- 	<h1>user_id = ${sessionScope.loginedUser.user_id}</h1> --%>
		<li><a href="setting.jsp" target="showFrame" id = "inform" onclick = "changeColor1()">个人信息
		</a></li>
		<li><a href="orderManage.jsp" target="showFrame" id = "order" onclick = "changeColor2()">订单管理
		</a></li>
		<li><a href="myHouses.jsp?user_id=${sessionScope.loginedUser.user_id}" target="showFrame" id = "rel" onclick = "changeColor3()">我的房屋
		</a></li>
<!-- 		<li><a href="myHouses.html" target="showFrame" id = "rel" onclick = "changeColor3()">我的房屋
		</a></li> -->
		<li><a href="ResetPwd.jsp" target="showFrame" id = "screte" onclick = "changeColor4()">修改密码
		</a></li>

		<script type="text/javascript">
		function changeColor1()
		{
			document.getElementById('inform').style.color = "#000066";
			document.getElementById('order').style.color = "white";
			document.getElementById('rel').style.color = "white";
			document.getElementById('screte').style.color = "white";
		}
		function changeColor2()
		{
			document.getElementById('inform').style.color = "white";
			document.getElementById('order').style.color = "#000066";
			document.getElementById('rel').style.color = "white";
			document.getElementById('screte').style.color = "white";
		}
		function changeColor3()
		{
			document.getElementById('inform').style.color = "white";
			document.getElementById('order').style.color = "white";
			document.getElementById('rel').style.color = "#000066";
			document.getElementById('screte').style.color = "white";
		}
		function changeColor4()
		{
			document.getElementById('inform').style.color = "white";
			document.getElementById('order').style.color = "white";
			document.getElementById('rel').style.color = "white";
			document.getElementById('screte').style.color = "#000066";
		}
		</script>
	</body>
</html>
