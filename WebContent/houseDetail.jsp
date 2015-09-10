

<%@page import="util.CountDays"%>
<%@page import="util.DbTool" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="entity.HouseBean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset = "utf-8">
	<title>house  Details</title>
	<style type="text/css">
	.picture 
	{
		margin-top: 50px;
		margin-left: 50px;
		position: absolute;
	}
	.picture img
	{
		width: 300px;
		height: 300px;
	} 
	.informain
	{
		margin-left: 500px;
		margin-top:50px;
	}
	</style>
</head>

<body>


<!--	house_title
		description
		host.phone
		note
		price
		这里需要联结user&house查询
		直接在这里面连接数据库查询吧
  -->

<%
			Connection connection = DbTool.getConnection();
			PreparedStatement prst = null;
			ResultSet rSet = null;
			int house_id = Integer.parseInt(request.getParameter("house_id"));
			String sql_queryHouse_by_houseID  = "SELECT photo_path, address, house_title, description, note, user.phone, price, user.user_id FROM anyhome.house, anyhome.user WHERE house_id = ? AND user.user_id = house.host_id";
	//		HouseBean houseBean = new HouseBean();
			List<String > houseDetails = new ArrayList();
			try {
				prst = connection.prepareStatement(sql_queryHouse_by_houseID);
				// prst.setString(1, targetAddress);
//				prst.setString(1, request.getParameter("address"));// 模糊查询
				prst.setInt(1, house_id);// 模糊查询
				rSet = prst.executeQuery();
				if (rSet.next()) {
					houseDetails.add(rSet.getString("description"));//0
					houseDetails.add(rSet.getString("user.phone"));//1
					houseDetails.add(new Integer(rSet.getInt("price")).toString());//2
					houseDetails.add(rSet.getString("house_title"));//3
					houseDetails.add(rSet.getString("note"));//4
					houseDetails.add(new Integer(rSet.getInt("user_id")).toString());//5
					houseDetails.add(rSet.getString("address"));//6
					houseDetails.add("upload/" + rSet.getString("photo_path")  );//7
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			request.setAttribute("houseDetails", houseDetails);
			System.out.println(houseDetails+"************************************");
%>

	<%
					int days = CountDays.getDays((String)session.getAttribute("start_time"),(String)session.getAttribute("end_time"));
					List<String> houseDet = (List<String>)request.getAttribute("houseDetails"); 
					int total_price = days*Integer.parseInt(houseDet.get(2));
					System.out.println(days);
	%>


		<div class = "picture">
				<img src="<%=houseDet.get(7) %>" alt="picture">
		</div> 

	<div class = "informain">
	
	
		<!-- <div class = "picture">
		<img src="images/main_picture/s.jpg" alt="picture"></div> -->
	
	
		<% 
				System.out.println(houseDet);
				System.out.println(houseDet.get(1));
		%>
		<p>房屋名：<%=houseDet.get(3) %></p>
		<p>日价格：<%=houseDet.get(2) %></p>
		<p>房东电话：<%=houseDet.get(1) %></p>
		<p>地址: <%=houseDet.get(6)%></p>
		<p>描述：<%=houseDet.get(0) %></p>
		<p>备注：<%=houseDet.get(4)==null?"无":houseDet.get(4)%></p>
		<p>总价: <%=total_price%></p>
		
		
		<form action="OrderOrperateServlet" method="post">
		<!-- 只是为了兼容servlet的操作 -->
			<input type="hidden" name="type" value="-1"/>
			<input type="hidden" name="order_id" value="-1"/>
			<!-- 只是为了兼容servlet的操作 -->
			<input type="hidden" name="state" value="1"/>
			<input type="hidden" name="start_time" value="${sessionScope.start_time}"/>
			<input type="hidden" name="end_time" value="${sessionScope.end_time }"/>
			<input type="hidden" name="total_price" value="<%=total_price %>"/>
			<input type="hidden" name="host_id" value="<%=houseDet.get(5) %>"/>	
			<input type="hidden" name="user_id" value="${sessionScope.loginedUser.user_id }" />
			
			<input type="submit" name="确认预订" />
		</form>
	</div> 
		<!-- <a href="OrderOrperateServlet?">确认预订</a> 这里应该写个btn，submit-->
		
<%-- 		<p>房屋id：${param.house.house_id}</p>
		<p>房屋名：${param.house.house_title}</p>
		<p>价格：${param.house.price}</p>
		<p>描述：${param.house.description}</p>
		<p>xxxxx</p>
		<p>xxxx</p>
		<p>xxxx</p> --%>
	</div>
</body>
</html>