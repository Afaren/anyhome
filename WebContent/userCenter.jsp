<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Center Page</title>

<style type="text/css">
		a{text-decoration:none; color:#06A0E4; cursor: pointer;}
</style>

</head>

<!-- <iframe src="demo_iframe.htm" name="iframe_a"></iframe>
<p><a href="http://www.w3school.com.cn" target="iframe_a">W3School.com.cn</a></p> -->

<frameset rows="190px,*">
		<iframe src="userCenter/userpage.jsp" name="userpage">
				<frameset cols="200px,*">
						<iframe src="userCenter/userZone.jsp" name="userZone"></iframe>
				<!-- 		<frame src="userCenter/show.jsp" name="show"> -->
				 		<iframe width="500"  height ="500" name="show"></iframe> 
				</frameset>		
		</iframe>
</frameset>
<body>
	<h1>user center page</h1>
</body>
</html>