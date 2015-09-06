<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8"> 
	<link rel="stylesheet" type="text/css" href="css/releasehouseInform.css"></link>
	<link rel="stylesheet" href="releaseHouseInform_files/bootstrap.css"></link>
	<link rel="stylesheet" href="releaseHouseInform_files/font-awesome.css"></link>
    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"></link>

	<title>releaseHouseInform</title>
	<style type="text/css">
	#preview
	{
		width:240px;
		height:170px;
		border:1px solid #000;
		overflow:hidden;
	}
	#imghead 
	{
		filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
	}
</style>
</head>

<body>
	<a href="mainScreen2.jsp" style = "text-direction:none"><h1 style = "margin-left:100px;color:#1e90ff">@Anyhome</h1></a>
	<form action="ReleaseHouseServlet2" method="post"  enctype="multipart/form-data">
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
					<script type="text/javascript">_init_area();</script>
				</div>
				<input name="s_address"  data-original-title="2-30字，不能填写电话，特殊符号" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="" style="margin-left:330px;maxlength:30" required="" type="text">
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
				<input type="file" name="file" onchange="previewImage(this)" />  
				<br>
			    <div id="preview">
			    	<img id="imghead" src='<%=request.getContextPath()%>/images/defaul.jpg'>
				</div>   
				<button id="wl" style = "margin-top:5px">提交</button>
				<i class="fa fa-times-circle"></i>
        		<i class="fa fa-check-circle"></i>
			</li>
		</div>
	</form>

	<script src="releaseHouseInform_files/jquery.js"></script>
	<script src="releaseHouseInform_files/transition.js"></script>
	<script src="releaseHouseInform_files/tooltip.js"></script>
	
	<script type="text/javascript">
	 function previewImage(file)
        {
          var MAXWIDTH  = 260; 
          var MAXHEIGHT = 180;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
				//img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                 
                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
             
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }

        $(function () {
        	$('[data-toggle="tooltip"]').tooltip()
        })
	</script>
</body>
</html>