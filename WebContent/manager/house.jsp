
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>house.html</title>
<style>
	  body{background-color:#eeeeee;}
	  table{border:none; margin-top:100px; margin-left:200px; }
	  td{ width:150px;}
</style>
</head>

<body>

<%
			List<HouseBean> targetHouseList = new ArrayList<HouseBean>();
			Connection connection = DbTool.getConnection();
			PreparedStatement prst = null;
			ResultSet rSet = null;
			String targetAddress = "";
			String sql_queryTargetHouse = "SELECT * FROM HOUSE WHERE address LIKE ?";
			try {
				prst = connection.prepareStatement(sql_queryTargetHouse);
				// prst.setString(1, targetAddress);
				prst.setString(1, "%" + targetAddress + "%");// 模糊查询
				rSet = prst.executeQuery();
				while (rSet.next()) {
					HouseBean houseBean = new HouseBean();
					houseBean.setAddress(rSet.getString("address"));
					houseBean.setDescription(rSet.getString("description"));
					houseBean.setHost_id(rSet.getInt("host_id"));
					houseBean.setHouse_id(rSet.getInt("house_id"));
					houseBean.setHouse_title(rSet.getString("house_title"));
					houseBean.setNote(rSet.getString("note"));
					houseBean.setPhoto_path(rSet.getString("photo_path"));
					houseBean.setPrice(rSet.getInt("price"));
					targetHouseList.add(houseBean);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
			request.setAttribute("houseList", targetHouseList);
%>






		<c:choose>
				<c:when test="${empty requestScope.houseList }">
					houseList 没有满足的数据
				</c:when>
				<c:otherwise>
					<table border="1" align="center">
						<tr>
							<td>房东名</td>
							<td>房屋名称</td>
							<td>详细信息</td>
							<td>xxx</td>
							<td>xxx</td>
						</tr>
						<c:forEach var="house" items="${requestScope.houseList }" varStatus="s">
						 <tr>
								<td>房东名</td>
								<td>${house.house_title}</td>
								<td><a href="houseDetail.jsp?address=${house.address }">查看详情</a></td>
			 				    <td><a href="#">通过审核</a></td><!-- href=houseStateServlet?state=tongguoshenghe -->
			 			        <td><a href="#">拒绝发布</td>		 <!-- href=houseStateServlet?state=tongguoshenghe -->
						</tr>
						</c:forEach>
					</table>
				</c:otherwise>
		</c:choose>
</body>
</html>
