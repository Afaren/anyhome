
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
<title>my house page</title>
</head>
<body>
<%
			List<HouseBean> myHouseList = new ArrayList<HouseBean>();
			Connection connection = DbTool.getConnection();
			PreparedStatement prst = null;
			ResultSet rSet = null;
			int host_id = Integer.parseInt(request.getParameter("user_id"));
			String sql_queryHouseByHost_id = "SELECT * FROM HOUSE WHERE host_id=?";
			try {
				prst = connection.prepareStatement(sql_queryHouseByHost_id);
				// prst.setString(1, targetAddress);
				prst.setInt(1, host_id);
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
					myHouseList.add(houseBean);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}			
			request.setAttribute("houseList", myHouseList);
%>
		<c:choose>
				<c:when test="${empty requestScope.houseList }">
					房屋列表为空
				</c:when>
				<c:otherwise>
					<table border="1" align="center">
						<tr>
								
							<td>房屋名称</td>
							<td>详细信息</td>
							<td>XXXX</td>
							<td>XXXX</td>
						</tr>
						<c:forEach var="house" items="${requestScope.houseList }" varStatus="s">
						 <tr>
						
								<td>${house.house_title}</td>
								<td>${house.description }</td>
			 				   <td><a href="houseDetail.jsp?house_id=${house.house_id }" target="showFrame">查看详情</a></td><!-- href=houseStateServlet?state=tongguoshenghe -->
			 			        <td>XXXX</td>		 <!-- href=houseStateServlet?state=tongguoshenghe -->
						</tr>
						</c:forEach>
					</table>
				</c:otherwise>
		</c:choose>
</body>
</html>
