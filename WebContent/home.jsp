<%@page import="entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>AnyHome main Page</title>
	
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>

	<link href="js/bootstrap-datetimepicker-master/sample in bootstrap v2/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

	<link rel="stylesheet" type="text/css" href="css/mainScreen.css"><!-- Afar修改了文件路径 -->

	<script type="text/javascript">
		var arr = new Array();
		/*	 arr[0] = "images/3.jpg"; *//* 试着修改图片路径，看能否载入  */
	 	arr[0] = "images/main_picture/3.jpg ";/*试着修改图片路径，看能否载入*/ 
		arr[1] = "images/mainPicture/4.jpg";
		arr[2] = "images/main_picture/5.jpg";
		arr[3] = "images/main_picture/6.jpg";
		arr[4] = "images/main_picture/7.jpg";
		arr[5] = "images/main_picture/8.jpg";

	
		function image()
		{
			var i = 0;
			var ima = document.getElementById("main");
			ima.src = arr[i];
			i++;
			if(i == 6)
				i = 0;
			setTimeout("image()", 2000);
		}
		
		function dowith()
		{
			alert("*************");
			var img = document.getElementById("handan");
			var i = 0;
			
			if(i == 6)
				img.src = arr[0];
			else
				img.src = arr[i];
			i++;
		}
	</script>
</head>
<body onload = "image()">
 
	<%-- 
	<jsp:useBean id="userBean" class="entity.UserBean" scope="request"/>
	--%>
	<%-- <jsp:getProperty name="userBean" property="" --%>
	<%
			UserBean userBean = (UserBean)request.getSession().getAttribute("loginedUser");
		System.out
				.println("****************************************************"
						+ this.getClass().getName());
		if(userBean!=null){
			System.out.println("user_id: " + userBean.getUser_id());
			System.out.println(userBean.getAccount_id());
			System.out.println(userBean.getGender());
			System.out.println(userBean.getMail());
			System.out.println(userBean.getPassword());
			System.out.println(userBean.getPhone());
			System.out.println(userBean.getUser_type());
			System.out.println(userBean.getUsername());
		}
		System.out
				.println("****************************************************"
						+ this.getClass().getName());
	%>
	<div class = "top">
		<div class="bg">
			<img alt="picture3" src="images/main_picture/3.jpg" id = "main" width = "100%" style = "height: 619px">
		</div>	

		<div class = "topNav">
			<li><a href="releaseHouse.jsp">成为房东</a></li>
			<li><a href="login.jsp">登录</a></li>
			<li><a href="sign_up.jsp">注册</a></li>
		</div>

		<div class = "slogan">
			<h1>四海一家</h1>
		</div>

		<div class = "component-left">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		</div>

		<div class = "component-right">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		</div>

		<form action = " " method = " " class = "formOne">
			<input id = "location" placeholder = "您想去哪里" type = "text"
				style = "height:46px;width:320px">			 
         
			<input id = "stay" size="16" type="text" value="入住日期" readonly class="form_datetime"
			 style = "height:46px;width:145px">
			<input id = "stay" size="16" type="text" value="退房日期" readonly class="form_datetime"
			 style = "height:46px;width:145px">
			<script type="text/javascript" src="js/bootstrap-datetimepicker-master/sample in bootstrap v2/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
            <script type="text/javascript" src="js/bootstrap-datetimepicker-master/sample in bootstrap v2/bootstrap/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
            <script type="text/javascript" src="js/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
			<script type="text/javascript">
			    $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
			</script> 

		    <select id = "guestnum" style = "height:46px;width:120px">
			    <option>1位房客</option>
			    <option>2位房客</option>
			    <option>3位房客</option>
		   		<option>4位房客</option>
			   	<option>5位房客</option>
			    <option>6位房客</option>
			    <option>7位房客</option>
			    <option>8位房客</option>				    
			    <option>9位房客</option>
			    <option>10位房客</option>
			    <option>11位房客</option>
			    <option>12位房客</option>
			    <option>13位房客</option>				    
			    <option>14位房客</option>
			    <option>15位房客</option>
			    <option>16位房客</option>
			    <option>16+位客人</option>
			</select>

			<button type = "submit" value = "搜索" id = "search_picture" style = "color:white;font-weight:800;font-size:20px;">搜索</button>
		</form>
	</div>

	<div class = "middle">
		<div class = "easy-slogan">
			<h2 align = "center">探索世界</h2>
			<p align = "center">搜罗全球热门目的地</p>
		</div>

		<div class = "display">
			<div id = "two">
				<img alt="picture纽约" src="images/main_picture/NewYork.jpg" id = "one">
				<img alt="picturejoke的家" src="images/main_picture/jokeHouse.jpg" id = "one">
			</div>
			<div id = "three">
				<img alt="picture夏威夷" src="images/main_picture/Hawaii.jpg" id = "one">
				<img src="images/main_picture/Paris.jpg" id = "one">
				<img src="images/main_picture/Barcelona.jpg" id = "one">
			</div>
			<div id = "two">
				<img src="images/main_picture/brigHouse.jpg" id = "one">
				<img src="images/main_picture/London.jpg" id = "one">
			</div>
			<div id = "three">
				<img src="images/main_picture/SanFrancisco.jpg" id = "one">
				<img src="images/main_picture/Berlin.jpg" id = "one">
				<img src="images/main_picture/Budapest.jpg" id = "one">
			</div>
		</div>
	</div>

	<div class = "bottom">
		<form id = "formTwo">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true" onclick = "dowith()"></span>
			<img src="images/main_picture/12.jpg" id = "handan">
		</form>
	</div>
</body>
	
</body>
</html>