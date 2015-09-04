<%@page import="entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<style type="text/css">
body
{
	background-color: #f6ffff;   
}
#userInfo h1
{
	font-family: 宋体;
	text-align: center;
}
.format
{
	font-size:16px;  
	height:auto; 
	line-height:46px; 
	text-align: center;
}
.but
{
	text-align: center;
}
</style>
<script>
function checkUserName()
{
    var userName = document.getElementById('userName').value;
	var show = document.getElementById('tip');
    var pattern = /^[0-9,a-z]+$/gi;
	if(!pattern.test(userName))
	{
	  show.innerHTML = '用户名只能是字母或数字';
	  show.style.color = 'red';
	}
	else{
	  show.innerHTML = '';
	}
} 

function checkPassword()
{
    var password = document.getElementById('password').value;
	var show = document.getElementById('tip2');
    var pattern = /^[0-9,a-z]+$/gi;
	if(!pattern.test(password))
	{
	  show.innerHTML = '密码只能是字母或数字';
	  show.style.color = 'red';
	}
	else{
	  show.innerHTML = '';
	}
} 

function checkEmail()
{
    var Email = document.getElementById('Email').value;
	var show = document.getElementById('tip3');
    var pattern = /^\w+[@]\w+[.]\w+$/g;
	if(!pattern.test(Email))
	{
	  show.innerHTML = '邮箱格式有问题';
	  show.style.color = 'red';
	}
	else{
	  show.innerHTML = '';
	}
} 

function checkAccountNumber()
{
    var accountNumber = document.getElementById('accountNumber').value;
	var show = document.getElementById('tip5');
    var pattern = /^[0-9, a-z, _]+$/g;
	if(!pattern.test(accountNumber))
	{
	  show.innerHTML = '账号只能含数字，字母，下划线';
	  show.style.color = 'red';
	}
	else
	{
	  show.innerHTML = '';
	}
} 

function checkPhoneNumber()
{
    var phoneNumber = document.getElementById('phoneNumber').value;
	var show = document.getElementById('tip4');
    var pattern = /^(13[0-9][0-9]{8}|14[57][0-9]{8}|15[012356789][0-9]{8}|17[0678][0-9]{8}|18[0-9][0-9]{8})$/g;
	if(!pattern.test(phoneNumber))
	{
	  show.innerHTML = '请输入正确的手机号码';
	  show.style.color = 'red';
	}
	else
	{
	  show.innerHTML = '';
	}
} 

</script>
</head>
<body>
				${sessionScope.loginedUser }<!-- 这里出不了详细的内容 -->

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



<!--点击submit提交数据时，应该顺便刷新页面  -->


<form action="ResetUserInfoServlet" method="post">

	<div id="userInfo" align = "center">
	<h1>用户信息</h1>
    <div class="format">
    用户名： ${sessionScope.loginedUser.username } 
	<div id="tip"></div>
    </div>
    
	<div class="format">
    电&nbsp;&nbsp;&nbsp;话：${sessionScope.loginedUser.phone }
	<div id="tip4"></div>
    </div>
	
	<div class="format">性&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;
    <input type="radio"  name="gender" class="input"  value="male"  (${sessionScope.loginedUser.gender}) == "male" ? "checked" : "" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio"  name="gender" value="female"  ${(sessionScope.loginedUser.gender == "female" )? "checked" : "" } />女
	<div id="tip3"></div>
    </div>

    <div class="format">
    邮&nbsp;&nbsp;&nbsp;箱：
    <input name="mail" id="Email" class="input" type="text" value="${sessionScope.loginedUser.mail }"  onblur="checkEmail()"/>
	<div id="tip3"></div>
    </div>
	
	

    <div class="format">
    账&nbsp;&nbsp;&nbsp;号：
    <input name="account_num"  id="accountNumber" class="input" type="text" value="${sessionScope.account_num }" onblur="checkAccountNumber()" />
	<div id="tip5"></div>
    </div>
	
	<div class="but">
    <input class="input" type="submit" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="input" type="reset" value="取消" />
    </div>

  </div>
  </form>
</body>
</html>