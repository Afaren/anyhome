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
<title>target house</title>
</head>
<body>
	<c:choose>
				<c:when test="${empty sessionScope.houseList }">
					houseList 没有满足的数据
				</c:when>
				<c:otherwise>
					<table border="1" align="center">
						<tr>
							<td>房屋名称</td>
							<td>详细信息</td>
							<td>预定房屋</td>
							<td>手机号码</td>
						</tr>
						<c:forEach var="house" items="${sessionScope.houseList }" varStatus="s">
						 <tr>
								<td>${house.house_title}</td>
								<td><a href="houseDetail.jsp?address=${house.address }">查看详情</a></td>
			 				    <td><a  href="OrderOrperateServlet?state=<%=OrderStates.CHECKING_ORDER %>&host_id=${house.host_id}&user_id=${sessionScope.loginedUser.user_id}&start_time=${sessionScope.start_time }&end_time=${sessionScope.end_time}">预订房屋</a></td>		 <!-- 生成订单 -->
			 			        <td>xxxx</td>		 <!-- href=houseStateServlet?state=tongguoshenghe -->
						</tr>
						</c:forEach>
					</table>
				</c:otherwise>
		</c:choose>
	
	
	
<!-- 	 CHECKING_ORDER = 1; // 订单生成，待确认，审核中
	 ACCEPT_WAIT_PAY_ORDER = 2; // host接受订单，待付款
	 CANCEL_ORDER = 3; // 房客取消订单
	 REJECT_ORDER = 4; // 房东拒绝订单
	 WAIT_CHECKIN_ORDER = 5; // 房客已付款，待入住
	 LIVING_ORDER = 6; // 入住中
	 ACCOMPLISH_ORDER = 7; // 已完成
	 -->
	
	
	
	
	
	
	
	
	
</body>
</html>