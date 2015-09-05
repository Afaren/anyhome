<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>sign up page</title>
<title>注册</title>
<style type="text/css">
   #bg{background-color: #000066;}
  #information{width:315px; height:auto; border:1px dotted; margin:60px 500px; background-color:#FFFFFF;}
  .input{border:0; width:250px;}
  #name{width:auto; height:40px; margin:20px 20px 10px 20px; border:1px dotted;}
  #name2{margin:9px; font-size:18px;}
  #phoneNumber{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #phoneNumber2{margin:9px; font-size:18px;}
  #password{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #password3{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #password2{margin:9px; font-size:18px;}
  a{text-decoration:none;}
  #agree{ width:auto; height:40px; margin:10px 20px 10px 20px; border:0px dotted;}
  #agree2{ font-size:11px; margin:3px;}
  #button{width:auto; height:40px; margin:10px 20px 10px 20px; border:1px dotted;}
  #button2{}
  #button3{border:0; font-size:24px; width:273px; height:40px; background-color:red ; color:#FFFFFF;}
  #enter{ width:275px; height:30px; margin:20px 20px 20px 20px; border:1px solid  #FFFFFF;}
  #enter2{font-size:14px; margin:4px auto auto 10px;}
</style>

<script>
/* refact Fri Aug 28 */
	var passwordFlag = false;
	var phoneNumberFlag = false;
	
/* add two parameters for check informations  */
  function checkPhoneNumber(){
    var PNumber = document.getElementById('pNumber').value;
	var show = document.getElementById('phoneNumber');
    var pattern = /^1[0-9]{10}$/g;
	if(pattern.test(PNumber)){
	  show.style.borderColor = 'green';
	  show.style.borderStyle = 'solid';
	  show.style.borderWidth = 2;
	  phoneNumberFlag = true;//assert phoneNumber
	}
	else{
	  show.style.borderColor = 'red';
	  show.style.borderStyle = 'solid';
	  show.style.borderWidth = 2;
	  phoneNumberFlag = false;// assert phoneNumber
	}
  }
  
  function checkPassword(){
    var pword2 = document.getElementById('pword2').value;
	var pword1 = document.getElementById('pword1').value;
	var show = document.getElementById('password3');
	var show2 = document.getElementById('password');
  
	if(pword1 == pword2){
	  show.style.borderColor = 'green';
	  show.style.borderStyle = 'solid';
	  show.style.borderWidth = 2;
	  show2.style.borderColor = 'green';
	  show2.style.borderStyle = 'solid';
	  show2.style.borderWidth = 2;
	  passwordFlag = true; // assert password
	}
	else{
	  show.style.borderColor = 'red';
	  show.style.borderStyle = 'solid';
	  show.style.borderWidth = 2;
	  passwordFlag = false;  // assert password
	}
  }
  function checkInfo(){
	    if(passwordFlag == true && phoneNumberFlag == true){
			  alert('注册成功');
			  return true;
	    }
		else{
		      alert('信息填写有误');
		      return false;
		}
	  }
</script>
</head>

<body id="bg">
		${unlogin_message }
		<%
		request.getSession(false).removeAttribute("unlogin_message");
		%>
			${unlogin_message }
<div id="information">
  <form action="SignUpServlet" method="post" onsubmit="var result = checkInfo(); return result;">
	  <div id="name">
	    <div id="name2">
		  <input class="input" type="text" name="username" placeholder="用户名"> 
	    </div>
	  </div>
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
	  <div id="password3">
	    <div id="password2">
		  <input class="input" id="pword2" type="password" placeholder="确认密码" onKeyUp="checkPassword()">
	    </div>
	  </div>
	 
	  <div id="agree">
		<div id="agree2">	    
	      注册即代表我同意<a href="#">服务条款</a>、<a href="#">隐私政策</a>、 <a href="#">房客退款政策</a>及<a href="#">房东保障计划条款</a>。        
		</div>
	  </div>
	  
	  <div id="button">
	    <div id="button2">
		  <input id="button3" type="submit" name="submit" value="注册">
		</div>
	  </div>
	  
  </form>
  <div id="enter">
	<div id="enter2">
	  已经是Anyhome会员？&nbsp;&nbsp;<a href="login.jsp">登录</a>
	</div>	
  </div>
  
</div>
</body>
</html>