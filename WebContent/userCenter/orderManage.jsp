<%@page import="util.DbTool" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="entity.HouseBean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.OrderStates" %>
<%@page import="entity.OrderManageBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>order manage</title>
<style type="text/css">
	.navigation
	{
		margin-left: 20px;
	}
	.navigation li 
	{
		width: 100px;
		border-style: solid;
		border-width: 0.5px;
		border-color: ;
		background-color: #000066;
		display: block;
		float: left;
		margin-top: 20px;
		padding-top: 5px;
		padding-bottom: 5px;
	}
	.navigation li a 
	{
		padding-left: 20px;
		text-decoration: none;
		color: white;
	}
	.all
	{
		margin-top: 0px;
		margin-left: 20px;
	}
</style>
<!-- // CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	// ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	// CANCEL_ORDER = 3; // 房客取消订单
	// REJECT_ORDER = 4; // 房东拒绝订单
	// WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	// LIVING_ORDER = 6; // 入住中
	// ACCOMPLISH_ORDER = 7; // 已完成 -->
</head>
<!-- 获取servlet传递过来的参数 -->
<body>
	<div class = "navigation">
		<li style ="background-color:#333fff"><a href="allOrder.jsp?state=<%=OrderStates.SEARCH_ALL_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">所有订单</a></li>
		<li><a href="tobeconfirm.jsp?state=<%=OrderStates.CHECKING_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待确认</a></li>
		<li><a href="tobepaid.jsp?state=<%=OrderStates.ACCEPT_WAIT_PAY_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待付款</a></li>
		<li><a href="tobeliving.jsp?state=<%=OrderStates.WAIT_CHECKIN_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待入住</a></li>
		<li><a href="accomplish.jsp?state=<%=OrderStates.ACCOMPLISH_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已完成</a></li>
		<li><a href="cancel.jsp?state=<%=OrderStates.CANCEL_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已取消</a></li>
		</div><br/><br/><br/>
<%-- <c:choose>
					<c:when test="${empty requestScope.orderList }">
						没有订单	
					</c:when>
					<c:otherwise>
						<div class = "all">
							<table width="715" height = "20px" bordercolor="#000000" cellpadding="0" border="1">
								<tr>
									<td align = "center" width = "45">序号</td>
									<td align = "center">房屋名字</td>
									<td align = "center">起止日期</td>
									<td align = "center">手机号</td>
									<td align = "center" width = "60">总价</td>
								</tr>
							<c:forEach var="order" items="${requestScope.orderList }" varStatus="s">
								<tr height = "20">
									<td>${s.count }</td>
									<td>${order.house_title }</td>
									<td>${order.start_time} - ${order.end_time}</td>
									<td>${order.phone}</td>
									<td>${order.total_price }</td>
								</tr>
							</c:forEach>
							</table>
					</div>
					</c:otherwise>
		</c:choose>
	 --%>
</body>
</html>