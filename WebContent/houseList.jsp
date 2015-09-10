<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="entity.HouseBean" %>
<%@page import="entity.OrderStates" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>house list jsp</title>


<style type="text/css">
body
{
	background:#f0f8ff;
}
#header 
{
	width: 100%;
	height: 100px;
	background-color: #000066;
	font-size: 40px;
	padding-top: 13px;
}
.main
{
	width: 250px;
	height: 300px;
	margin-top: 3%;
	margin-left: 5%;
	float: left;
	position: relative;
}

.main p:hover
{
	color: red;
}	
a
{
	text-decoration: none;
}

</style>
</head>


<body>
	<div id="header">
  		<a href="mainScreen2.jsp" style = "text-decoration:none;margin-left:30px;color:white">@Anyhome</a>
  	</div>
		<c:choose>
				<c:when test="${empty sessionScope.houseList }">
					houseList 没有满足的数据
				</c:when>
				<c:otherwise>
						<c:forEach var="house" items="${sessionScope.houseList }" varStatus="s">
						  	<div class="main" onClick="window.location.href='houseDetail.jsp?house_id=${house.house_id}'">
						  		<a href="houseDetail.jsp?house_id=${house.house_id}"><img  id="img_left" src="images/main_picture/s.jpg" alt="picture" width = "250" height = "250"/></a>
						  		<a href="houseDetail.jsp?house_id=${house.house_id}"><p>名称: ${house.house_title}</p>价格: ${house.price}
						  		</a>
						  	</div>
						</c:forEach>
				</c:otherwise>
		</c:choose>
	</body>
</html>
</html>