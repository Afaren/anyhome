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
<title>Insert title here</title>
<style>
body
	{
		background-color: #f6ffff;
	}
.all
{
margin-top:50px;
margin-left:100px;
}
</style>
</head>
<body>
<%
				//int state = Integer.parseInt(request.getParameter("state"));
				//String type = request.getParameter("type");
				int id = Integer.parseInt(request.getParameter("id"));
				List<OrderManageBean> ordersList = new ArrayList<OrderManageBean>();
				Connection connection = DbTool.getConnection();
				PreparedStatement prst = null;
				String sql_query_orders_by_id = null;
				ResultSet rSet = null;
				sql_query_orders_by_id = "select distinct user.phone, house.house_title, order.start_time, order.end_time, order.total_price, order.states FROM user, house, anyhome.order WHERE anyhome.order.host_id = user.user_id AND house.host_id = user.user_id AND	anyhome.order.user_id = ?;";
				try {
							prst = connection.prepareStatement(sql_query_orders_by_id);
							prst.setInt(1, id);
							rSet = prst.executeQuery();
							while (rSet.next()) {
										OrderManageBean orderManageBean = new OrderManageBean();
										orderManageBean.setEnd_time(rSet.getString("end_time"));
										orderManageBean.setHouse_title(rSet.getString("house_title"));
										orderManageBean.setPhone(rSet.getString("phone"));
										orderManageBean.setStart_time(rSet.getString("start_time"));
										orderManageBean.setTotal_price(rSet.getInt("total_price"));
										orderManageBean.setState(rSet.getInt("order.states"));
										ordersList.add(orderManageBean);
					}
				} catch (SQLException e) {
					e.printStackTrace();//3 h
				}finally{
					DbTool.close(rSet, prst, connection);
				}
				request.setAttribute("orderList", ordersList);
	%> 


<c:choose>
					<c:when test="${empty requestScope.orderList }">
						没有订单	
					</c:when>
					<c:otherwise>
						<div class = "all">
							<table width="715" height = "20px" bordercolor="#000000" cellpadding="0" border="1" >
								<tr>
									<td align = "center" width = "45">序号</td>
									<td align = "center">房屋名字</td>
									<td align = "center">起止日期</td>
									<td align = "center">房东手机</td>
									<td align = "center" width = "60">总价</td>
									<td align = "center" >人数</td>
								</tr>
							<c:forEach var="order" items="${requestScope.orderList }" varStatus="s">
								<tr align = "center"  height = "20">
									<td>${s.count }</td>
									<td>${order.house_title }</td>
									<td>${order.start_time} - ${order.end_time}</td>
									<td>${order.phone}</td>
									<td>${order.total_price }</td>
									<td>${order.state }</td>
								</tr>
							</c:forEach>
							</table>
					</div>
					</c:otherwise>
		</c:choose>
</body>
</html>