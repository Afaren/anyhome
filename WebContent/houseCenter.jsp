<%@page import="entity.HouseBean"   %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>House Center Page</title>
</head>
<body>
	<h1>house center page</h1>
	<c:choose>
			<c:when test="${empty houseList }">
					<h3>未发布房屋</h3>
			</c:when>
				<c:otherwise>
			<table border="1" align="center">
				<tr>
						<th>序号</th>
						<th>标题</th>
						<th>价格</th>
						<th>地址</th>
						<th>房屋描述</th>
				</tr>
						<c:forEach var="house" items="${houseList }" varStatus="s">
				 <tr>
				 					<td>s</td>
									<td>${house.house_title }</td>
									<td>${house.price }</td>
									<td>${house.address }</td>
									<td>${house.description }</td>
				</tr>
						</c:forEach>
				</table>
			</c:otherwise>
	</c:choose>
</body>
</html>