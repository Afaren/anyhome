

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
			String sql_queryHouse_by_houseID  = "SELECT house_title, description, note, user.phone, price  FROM anyhome.house, anyhome.user WHERE house_id = ?";
	//		HouseBean houseBean = new HouseBean();
			List<String > houseDetails = new ArrayList();
			try {
				prst = connection.prepareStatement(sql_queryHouse_by_houseID);
				// prst.setString(1, targetAddress);
//				prst.setString(1, request.getParameter("address"));// 模糊查询
				prst.setInt(1, house_id);// 模糊查询
				rSet = prst.executeQuery();
				if (rSet.next()) {
					houseDetails.add(rSet.getString("description"));
					houseDetails.add(rSet.getString("user.phone"));
					houseDetails.add(new Integer(rSet.getInt("price")).toString());
					houseDetails.add(rSet.getString("house_title"));
					houseDetails.add(rSet.getString("note"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			request.setAttribute("houseDetails", houseDetails);
			System.out.println(houseDetails+"************************************");
%>




	<div class = "picture">
		<img src="../images/main_picture/s.jpg" alt="picture">
	</div>

	<div class = "informain">
		
		<%List<String> houseDet = (List<String>)request.getAttribute("houseDetails"); %>
		
		<% System.out.println(houseDet);
		System.out.println(houseDet.get(1));
		%>
		<p>房屋名：<%=houseDet.get(3) %></p>
		<p>价格：<%=houseDet.get(2) %></p>
		<p>房东电话：<%=houseDet.get(1) %></p>
		<p>描述：<%=houseDet.get(0) %></p>
		<p>备注：<%=houseDet.get(4)==null?"无":houseDet.get(4)%></p>

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