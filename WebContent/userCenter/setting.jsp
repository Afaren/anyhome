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

} 

</script>
</head>
<body>
		<!-- 		${sessionScope.loginedUser }这里出不了详细的内容 -->

<%
			
			UserBean userBean = (UserBean)request.getSession().getAttribute("loginedUser");
			System.out
				.println("****************************************************"
						+ this.getClass().getName());
			if(userBean!=null){
			System.out.println(userBean);
			
			}
			System.out
				.println("****************************************************"
						+ this.getClass().getName());
%>



<!--点击submit提交数据时，应该顺便刷新页面  -->


<form action="../ResetUserInfoServlet" method="post">

	<div id="userInfo" align = "center">
	<h1>用户信息</h1>
    <div class="format">
    用户名：<input id="userName" class="input" type="text" value="${sessionScope.loginedUser.username } " disabled />
     
	<div id="tip"></div>
    </div>
    
	<div class="format">
	电&nbsp;&nbsp;&nbsp;话：&nbsp;<input id="phoneNumber" class="input" type="text" value="${sessionScope.loginedUser.phone }" disabled />

	<div id="tip4"></div>
    </div>
	
	<div class="format">性&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;
    <input type="radio"  name="gender" class="input"  value="male"  (${sessionScope.loginedUser.gender}) == "male" ? "checked=\"checked\"" : "" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio"  name="gender" value="female"  ${(sessionScope.loginedUser.gender == "female" )? "checked=\"checked\"" : ""} />女
	<div id="tip3"></div>
    </div>

    <div class="format">
    邮&nbsp;&nbsp;&nbsp;箱：
    <input name="mail" id="Email" class="input" type="text" value="${sessionScope.loginedUser.mail }"  onblur="checkEmail()"/>
	<div id="tip3"></div>
    </div>

	<div class="but">
    <input class="input" type="submit" value="更新" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="input" type="reset" value="取消" />
    </div>

  </div>
  </form>
</body>
</html>