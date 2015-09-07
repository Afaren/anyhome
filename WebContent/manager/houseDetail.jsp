

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



<%
			Connection connection = DbTool.getConnection();
			PreparedStatement prst = null;
			ResultSet rSet = null;
			String targetAddress = "";
			String sql_queryHouse_by_address = "SELECT * FROM HOUSE WHERE address = ?";
			HouseBean houseBean = new HouseBean();
			try {
				prst = connection.prepareStatement(sql_queryHouse_by_address);
				// prst.setString(1, targetAddress);
//				prst.setString(1, request.getParameter("address"));// 模糊查询
				prst.setString(1, new String(request.getParameter("address").getBytes("iso-8859-1"), "utf-8"));// 模糊查询
				rSet = prst.executeQuery();
				if (rSet.next()) {
					houseBean.setAddress(rSet.getString("address"));
					houseBean.setDescription(rSet.getString("description"));
					houseBean.setHost_id(rSet.getInt("host_id"));
					houseBean.setHouse_id(rSet.getInt("house_id"));
					houseBean.setHouse_title(rSet.getString("house_title"));
					houseBean.setNote(rSet.getString("note"));
					houseBean.setPhoto_path(rSet.getString("photo_path"));
					houseBean.setPrice(rSet.getInt("price"));
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
			request.setAttribute("house", houseBean);
%>





	<div class = "picture">
		<img src="../images/main_picture/17.jpg">
	</div>

	<div class = "informain">
		<p>房屋名：${requestScope.house.house_title}</p>
		<p>${requestScope.house.house_title}</p>
		<p>价格：${requestScope.house.price}</p>
		<p>描述：${requestScope.house.description}</p>
		<p>xxxxx</p>
		<p>xxxx</p>
		<p>xxxx</p>
	</div>
</body>
</html>