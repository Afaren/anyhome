<%@page import="entity.UserBean" %>
<%@page import="util.DbTool" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user jsp</title>
<style type="text/css">
body{background-color:#eeeeee;}
table{margin-top:100px; margin-left:200px; }
td{border:none; width:150px;}
</style>
</head>

<body>

<%
			Connection connection = null;
			PreparedStatement prst = null;
			ResultSet rSet = null;
			List<UserBean> userList = new ArrayList<UserBean>();
			try {
				connection = DbTool.getConnection();
				String sql_query_all_users = "SELECT * FROM user;";// 这里如果只查询了username，那么password是不能得到的
				prst = connection.prepareStatement(sql_query_all_users);
				rSet = prst.executeQuery();
			
				while( rSet.next() ){
					UserBean userBean = new UserBean();
					userBean.setUser_id(rSet.getInt("user_id"));
					userBean.setAccount_id(rSet.getInt("account_id"));
					userBean.setUsername(rSet.getString("username"));
					userBean.setPassword(rSet.getString("password"));
					userBean.setPhone(rSet.getString("phone"));
					userBean.setMail(rSet.getString("mail"));
					userBean.setGender(rSet.getString("gender"));
					userBean.setUser_type(rSet.getInt("user_type"));
					userList.add(userBean);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbTool.close(rSet, prst, connection);// 关闭数据库资源
			}
			request.setAttribute("userList", userList);
%>




	<c:choose>
			<c:when test="${empty requestScope.userList}">
				<h1>尚无用户注册</h1>
			</c:when>
			<c:otherwise>
				<table border="1" align="center">
				  <tr>
					  	<th>序号</th>
						<th>帐户名</th>
					    <th>手机号</th>
					    <th></th>
					    <th></th>
				  </tr>
				  <c:forEach var="user" items="${requestScope.userList}" varStatus="sta">
				  <tr align="center">
				  		<td >${sta.count}</td>
				  		<td>${user.username}</td>	
					    <td>${user.phone}</td>
					    <td><a href="#" style = "text-decoration:none">查看详情</a></td>
					    <td><a href="#" style = "text-decoration:none">删除</a></td>
				  </tr>
				  </c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
</body>
</html>
	