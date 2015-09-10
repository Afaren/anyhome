<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main screen</title>
<link href="./bootstrap-3.3.5-dist/css/bootstrap.css" type="text/css" rel="stylesheet"/>
<link href="./bootstrap-datetimepicker-master/sample in bootstrap v2/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="./bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href="css/mainScreen2.css">
</head>

<body onload = "image()">
	<div class = "top">
		<div class="bg">
			<img src="images/main_picture/3.jpg" id = "main" width = "100%" style = "height: 619px">
		</div>	
		<div class = "topNav">
			<li>${sessionScope.loginedUser.username }
				<ul>
					<li><a href="userCenter/frame.html">个人中心</a></li>
					<li><a href="releaseHouse.jsp">发布房屋</a></li>
				</ul>
			</li>
		</div>

		<div class = "left" style = "padding-top:15px">
			<a href="exit.jsp"  target="_top" style = "font-size:32px;color:white;margin-left:20px;padding-top:100px;list-style-type: none;text-decoration: none">退出</a>
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

		<form action = "SearchHouseServlet" method = "post" class = "formOne">
			<!-- <input name="where" id = "location" placeholder = "您想去哪里" type = "text"
				style = "height:46px;width:320px"> -->			 
			<select name = "where" id = "location">
				<option>你想去哪里</option>
				<option>莲湖区</option>
			    <option>新城区</option>
			    <option>碑林区</option>
		   		<option>灞桥区</option>
			   	<option>未央区</option>
			    <option>雁塔区</option>
			    <option>阎良区</option>
			    <option>临潼区</option>				    
			    <option>长安区</option>
			    <option>蓝田县</option>
			    <option>蓝关镇</option>
			    <option>周至县</option>
			    <option>二曲镇</option>				    
			    <option>户县</option>
			    <option>甘亭镇</option>
			    <option>高陵县</option>
			    <option>鹿苑镇</option>
			</select>
			<input  name="start_time" id = "stay" size="16" type="text" value="入住日期" readonly class="form_datetime"
				 style = "height:46px;width:145px">
				 
			<input   name="end_time" id = "stay" size="16" type="text" value="退房日期" readonly class="form_datetime"
				 style = "height:46px;width:145px">
			 
			<script type="text/javascript">
			    $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
			</script>  

		    <select name="numbers"  id = "guestnum" style = "height:46px;width:120px">
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
				<img alt="纽约" src="images/main_picture/NewYork.jpg" id = "one">
				<img alt="joke的家" src="images/main_picture/jokeHouse.jpg" id = "one">
			</div>
			<div id = "three">
				<img alt="夏威夷" src="images/main_picture/Hawaii.jpg" id = "one">
				<img alt="Paris" src="images/main_picture/Paris.jpg" id = "one">
				<img alt="Barcelona" src="images/main_picture/Barcelona.jpg" id = "one">
			</div>
			<div id = "two">
				<img alt="brigHouse" src="images/main_picture/brigHouse.jpg" id = "one">
				<img alt="London" src="images/main_picture/London.jpg" id = "one">
			</div>
			<div id = "three">
				<img alt="SanFranciso" src="images/main_picture/SanFrancisco.jpg" id = "one">
				<img alt="Berlin" src="images/main_picture/Berlin.jpg" id = "one">
				<img alt="Budapest" src="images/main_picture/Budapest.jpg" id = "one">
			</div>
		</div>
	</div>
	<div class = "bottom">
		<img alt="15" src="images/main_picture/15.jpg" id = "changePicture">

		<div class = "slogan-h2">
			<h2>旅游的魅力</h2>
			<p>在世界各地缔造一种有归属感的家</p>
		</div>

		<div class = "star">
			<span class="glyphicon glyphicon-star" aria-hidden="true" onclick = "dowith1()"></span>
			<span class="glyphicon glyphicon-star" aria-hidden="true" onclick = "dowith2()"></span>
			<span class="glyphicon glyphicon-star" aria-hidden="true" onclick = "dowith3()"></span>
			<span class="glyphicon glyphicon-star" aria-hidden="true" onclick = "dowith4()"></span>
		<div>
	</div>
	<script type="text/javascript">
	var arr = new Array();
	arr[0] = "images/main_picture/3.jpg ";/*试着修改图片路径，看能否载入*/ 
	arr[1] = "images/main_picture/4.jpg";
	arr[2] = "images/main_picture/5.jpg";
	arr[3] = "images/main_picture/6.jpg";
	arr[4] = "images/main_picture/7.jpg";
	arr[5] = "images/main_picture/8.jpg";

	var i = 0;
	function image()
	{
		var ima = document.getElementById("main");
		ima.src = arr[i];
		i++;
		if(i == 6)
			i = 0;
		setTimeout("image()", 2000);
	}
	</script>

	<script type="text/javascript">
	function dowith1()
	{
		var img = document.getElementById("changePicture");
		img.src = "images/main_picture/14.jpg";
	}

	function dowith2()
	{
		var img = document.getElementById("changePicture");
		img.src = "images/main_picture/15.jpg";
	}

	function dowith3()
	{
		var img = document.getElementById("changePicture");
		img.src = "images/main_picture/16.jpg";
	}
	function dowith4()
	{
		var img = document.getElementById("changePicture");
		img.src = "images/main_picture/17.jpg";
	}
	</script>

	<script type="text/javascript">
	var myVideo = document.getElementById("paly");

	function playPause()
	{
		alert("&&&&&&&&&&&&&&&&&&&&");
		if (myVideo.paused)
			myVideo.play();
		else 
			myVideo.pause(); 
	}
	</script>

	<script type="text/javascript">
	function address()
	{
		var add = document.getElementById("search_picture");

		if (add.) {};
	}
	</script>

			<script type="text/javascript" src="./bootstrap-datetimepicker-master/sample in bootstrap v2/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
            <script type="text/javascript" src="./bootstrap-datetimepicker-master/sample in bootstrap v2/bootstrap/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="./bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
            <script type="text/javascript" src="./bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>

			<script type="text/javascript">
		    $('.form_datetime').datetimepicker({
		        //language:  'fr',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				forceParse: 0,
		        showMeridian: 1
		    });
			$('.form_date').datetimepicker({
		        language:  'fr',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
		    });
			$('.form_time').datetimepicker({
		        language:  'fr',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 1,
				minView: 0,
				maxView: 1,
				forceParse: 0
		    });
</script>
</body>
</html>