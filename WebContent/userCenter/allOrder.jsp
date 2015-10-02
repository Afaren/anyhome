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
		<%-- <li style ="background-color:#333fff"><a href="orderManage.jsp?state=<%=OrderStates.SEARCH_ALL_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">所有订单</a></li>
		<li><a href="orderClassedByState.jsp?state=<%=OrderStates.CHECKING_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待确认</a></li>
		<li><a href="orderClassedByState.jsp?state=<%=OrderStates.ACCEPT_WAIT_PAY_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待付款</a></li>
		<li><a href="orderClassedByState.jsp?state=<%=OrderStates.WAIT_CHECKIN_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待入住</a></li>
		<li><a href="orderClassedByState.jsp?state=<%=OrderStates.ACCOMPLISH_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已完成</a></li>
		<li><a href="orderClassedByState.jsp?state=<%=OrderStates.CANCEL_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已取消</a></li>
		<li><a href="orderClassedByState.jsp?state=<%=OrderStates.ACCOMPLISH_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已过期</a></li>
	 --%>
	 
		 <li style ="background-color:#333fff"><a href="allOrder.jsp?state=<%=OrderStates.SEARCH_ALL_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">所有订单</a></li>
		<li><a href="tobeconfirm.jsp?state=<%=OrderStates.CHECKING_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待确认</a></li>
		<li><a href="tobepaid.jsp?state=<%=OrderStates.ACCEPT_WAIT_PAY_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待付款</a></li>
		<li><a href="tobeliving.jsp?state=<%=OrderStates.WAIT_CHECKIN_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">待入住</a></li>
		<li><a href="accomplish.jsp?state=<%=OrderStates.ACCOMPLISH_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已完成</a></li>
		<li><a href="cancel.jsp?state=<%=OrderStates.CANCEL_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已取消</a></li>
		<%-- <li><a href="OrderClassedByStateServlet?state=<%=OrderStates.ACCOMPLISH_ORDER%>&type=host&id=${sessionScope.loginedUser.user_id}" target="showFrame">已过期</a></li> --%>
	
	 
	 
	 
	 </div><br/><br/><br/>
	<%
				
				
				int id = Integer.parseInt(request.getParameter("id"));
				List<OrderManageBean> ordersList = new ArrayList<OrderManageBean>();
				Connection connection = DbTool.getConnection();
				PreparedStatement prst = null;
				String sql_query_orders_by_hostID = null;
				ResultSet rSet = null;
				sql_query_orders_by_hostID = "select user.phone, house.house_title, order.start_time, order.end_time, order.total_price, order.states FROM user, house, anyhome.order WHERE anyhome.order.host_id = user.user_id AND house.host_id = user.user_id AND	anyhome.order.host_id = ? ;";
				
				try {
							prst = connection.prepareStatement(sql_query_orders_by_hostID);
							prst.setInt(1, id);
							rSet = prst.executeQuery();
					
							//设置state，以中文保存显示订单状态
								int states = 0;
				
								String stateShowByChinese = null;
							while (rSet.next()) {
										OrderManageBean orderManageBean = new OrderManageBean();
										orderManageBean.setEnd_time(rSet.getString("end_time"));
										orderManageBean.setHouse_title(rSet.getString("house_title"));
										orderManageBean.setPhone(rSet.getString("phone"));
										orderManageBean.setStart_time(rSet.getString("start_time"));
										orderManageBean.setState(rSet.getInt("states"));
										
										orderManageBean.setTotal_price(rSet.getInt("total_price"));
										if(states==1 || states==0){
											stateShowByChinese = "待确认";
										}else if ( states==2){
											stateShowByChinese = "待付款";
										}else if( states == 3){
											stateShowByChinese = "房客取消";
										}else if (states == 4){
											stateShowByChinese = "拒绝";
										}else if (states==5){
											stateShowByChinese = 	"待入住";
										}else if(states==6){
											stateShowByChinese = "入住中";
										}else if (states==7){
											stateShowByChinese = "已完成";
										}
										
										orderManageBean.setStateShowByChinese(stateShowByChinese	);
										
										ordersList.add(orderManageBean);
										
										
					}
				} catch (SQLException e) {
					e.printStackTrace();//3 h
				}finally{
					DbTool.close(rSet, prst, connection);
				}
				//设置state，以中文保存显示订单状态
				
				request.setAttribute("orderList", ordersList);
	%>
	<%
				//设置state，以中文保存显示订单状态
			
				
	
	
	%>
		<c:choose>
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
									<td align = "center" width = "70">状态</td>
									
								</tr>
							<c:forEach var="order" items="${requestScope.orderList }" varStatus="s">
								<tr height = "20">
									<td>${s.count }</td>
									<td>${order.house_title }</td>
									<td>${order.start_time} - ${order.end_time}</td>
									<td>${order.phone}</td>
									<td>${order.total_price }</td>
									<td>${order.stateShowByChinese }</td>
								</tr>
							</c:forEach>
							</table>
					</div>
					</c:otherwise>
		</c:choose>
</body>
