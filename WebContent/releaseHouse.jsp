
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >

<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/releasehouseInform.css">
	<link rel="stylesheet" href="releaseHouseInform_files/bootstrap.css">
    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
	<title>release house information page</title>
</head>

<body>
	<form action="ReleaseHouseServlet" method="post">
		<div class="form-group">
			<div class="slogan">
				<p>详写信息</p>
			</div>

			<li>
				<span id="title">您的身份&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input name="type" value="个人" checked="checked" type="radio">个人&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="type" value="经纪人" type="radio">经纪人
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>

			<li>
				<span id="title">标题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input  name="house_title" data-original-title="6-30字，不能填写电话" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="" required="" style="maxlength:30" type="text">
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>

			<li>
				<span id="title">地址&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<div class="info">
					<select id="s_province" name="s_province"></select>  
					<select id="s_city" name="s_city" ></select>  
					<select id="s_county" name="s_country"></select>
					<script class="resources library" src="releaseHouseInform_files/area.js" type="text/javascript"></script>
					<script name="area" type="text/javascript">_init_area();</script>
				</div>
				<input name="s_address" data-original-title="2-30字，不能填写电话，特殊符号"  class="btn btn-default" data-toggle="tooltip" data-placement="right" title="" style="margin-left:330px;maxlength:30" required="" type="text">
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>

			<li>
				<span id="title">房屋类型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<select>
					<option selected="selected">家庭旅馆</option>
					<option>高档公寓</option>
					<option>商务酒店</option>
					<option>其他类型</option>
				</select>
			</li>

			<li>
				<span id="title">租金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input name="price" placeholder="请填入整数" style="width:100px" required="" type="number">元/天
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>

			<li>
				<span id="title">房屋描述&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<textarea name="description" data-original-title="例如房间类型，家具家电，保洁情况，周围环境，交通情况..."  rows="5" cols="50" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="" style="height:100px" required=""></textarea>
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>

			<li>
				<span id="title">上传照片&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<input type="file" name="photo" id="file" multiple />
				<button id="wl">
				文件上传</button>
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>
		</div>
	</form>

	<script src="releaseHouseInform_files/jquery.js"></script>
	<script src="releaseHouseInform_files/transition.js"></script>
	<script src="releaseHouseInform_files/tooltip.js"></script>

	<script src="../jquery-1.7.1.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function () {
	$("!!#wl"!!).click(function () {
	var f = $("!!#file"!!)[0];

	var s = "!!"!!;

	});
	});
	</script>
	<script>
	$(function () 
	{
	  $('[data-toggle="tooltip"]').tooltip()
	})
</script>
</body>
</html>