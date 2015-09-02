<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>anyhome login page</title>

<style type="text/css">
  #bg{background-image:url(images/login_bg.jpg); background-repeat:no-repeat;}
  #information{width:315px; height:auto; border:1px dotted; margin:130px 500px; background-color:#FFFFFF;}
  .input{border:0; width:250px;}
  #phoneNumber{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #phoneNumber2{margin:9px; font-size:18px;}
  #password{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #password2{margin:9px; font-size:18px;}
  a{text-decoration:none;}
  #submit{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #submit2{}
  #submit3{border:0; font-size:24px; width:273px; height:40px; background-color:#ff5a5f; color:#FFFFFF;}
  #enter{ width:275px; height:30px; margin:20px 20px 20px 20px; border:1px solid  #FFFFFF;}
  #enter2{font-size:14px; margin:4px auto auto 10px;}
</style>

<script>
  function checkPhoneNumber(){
    var PNumber = document.getElementById('pNumber').value;
	var show = document.getElementById('phoneNumber');
    var pattern = /^1[0-9]{10}/g;
	if(pattern.test(PNumber)){
	  show.style.borderColor = 'green';
	  show.style.borderStyle = 'solid';
	  show.style.borderWidth = 2;
	}
	else{
	  show.style.borderColor = 'red';
	  show.style.borderStyle = 'solid';
	  show.style.borderWidth = 2;
	}
  }
</script>
</head>




<body id="bg">
<div id="information">
 <form action="LoginServletTest" method="post">
 	 <div id="phoneNumber">
    <div id="phoneNumber2">
	  <input class="input" id="pNumber" type="text" name="phone" placeholder="手机号码" onKeyUp="checkPhoneNumber()">
    </div>
  </div>
  <div id="password">
    <div id="password2">
	  <input class="input" id="pword1" type="password" name="password" placeholder="密码">
    </div>
  </div>
  
  <div id="submit">
    <div id="submit2">
	  <input id="submit3" type="submit" name="submit" value="登录">
	</div>
  </div>
 </form>
  
  <div id="enter">
	<div id="enter2">
	  还没有账号？&nbsp;&nbsp;<a href="sign_up.jsp">注册</a>
	</div>	
  </div>
  
</div>
</body>
</html>