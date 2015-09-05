<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
<title>anyhome login page</title>

<style type="text/css">
#bg
{
  background-color: #000066;
}
#information
{
  width:315px; 
  height:auto; 
  border:1px dotted; 
  margin:130px 500px;
  background-color:#FFFFFF;
}
.input
{
  border:0; 
  width:250px;
}
#phoneNumber
{
  width:auto; 
  height:40px; 
  margin:10px 20px 10px 20px; 
  border:1px dotted;
}
#phoneNumber2
{
  margin:9px; 
  font-size:18px;
}
#password
{
  width:auto; height:40px; 
  margin:10px 20px 10px 20px;
  border:1px dotted;
}
#password2
{
  margin:9px; 
  font-size:18px;
}
a
{
  text-decoration:none;
}
#submit
{
  width:auto; 
  height:40px; 
  margin:10px 20px 10px 20px; 
  border:1px dotted;
}
#submit2
{

}
#submit3
{
  border:0; 
  font-size:24px; 
  width:273px; 
  height:40px; 
  background-color:red; 
  color:#FFFFFF;
}
#enter
{ 
  width:275px; 
  height:30px; 
  margin:20px 20px 20px 20px; 
  border:1px solid  #FFFFFF;
} 
#enter2
{
  font-size:14px; 
  margin:4px auto auto 10px;
}
</style>
</head>

<body id="bg" onLoad = "checkCookie()">
<div id="information">
 <form action="LoginServlet" method="post">
 	 <div id="phoneNumber">
    <div id="phoneNumber2">
	  <input class="input" id="pNumber" type="text" name="phone" placeholder="手机号码">
    </div>
  </div>
  <div id="password">
    <div id="password2">
	  <input class="input" id="pword1" type="password" name="password" placeholder="密码" onKeyUp="checkPhoneNumber()">
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

<script>
function checkPhoneNumber()
{
  var PNumber = document.getElementById('pNumber').value;
  var show = document.getElementById('phoneNumber');
  var pattern = /^1[0-9]{10}/g;
  if(pattern.test(PNumber))
  {
    show.style.borderColor = 'green';
    show.style.borderStyle = 'solid';
    show.style.borderWidth = 2;
  }
   else
  {
    alert("手机号码输入格式不正确，请重新输入！");
    show.style.borderColor = 'red';
    show.style.borderStyle = 'solid';
    show.style.borderWidth = 2;
  }
}


  function getCookies()
  {
    var c_name = document.getElementById("PNumber").value;
    if(document.cookie.length > 0)
    {
      c_start = document.cookie.indexOf(c_name + "=");
      if(c_start != -1)
      {
        c_start = c_start + c_name.length + 1;
        c_end = document.cookie.indexOf(";", c_start);
        if(c_end == -1)
          c_end = document.cookie.length;
        return unescape(document.cookie.substring(c_start, c_end));
      }
    }
    return "";
  }

  function checkCookie()
  {
    username = getCookies();
    if (username != null && username != "")
    {
      alert('Welcome again ' + username + '!');
    }
    else
    {
      username = prompt('Please enter your name', "");
      if (username != null && username != "")
      {
        setCookies('username', username, 365);
      } 
    }
  }
</script>
</body>
</html>