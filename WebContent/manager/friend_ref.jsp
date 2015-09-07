<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
				<c:when test="${empty friendList }">
					showFriend.jsp 没有满足的数据
				</c:when>
				<c:otherwise>
					<table border="1" align="center">
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>电话</th>
							<th>备注</th>
							<th>编辑</th>
						</tr>
						<c:forEach var="friend" items="${friendList }" varStatus="s">
						 <tr>
								<td>${friend.id }</td>
								<td>${friend.name }</td>
								<td>${friend.gender }</td>
								<td>${friend.telephone }</td>
								<td>${friend.remark }</td>
								<td><a href="updateFriend.jsp?friend.id=${friend.id}&opCode=u">更改好友信息</a>
										<a href="deleteFriend.jsp?friend.id=${friend.id}&opCode=d">删除好友信息</a>
								</td>
						</tr>
						</c:forEach>
					</table>
				</c:otherwise>
		</c:choose>
</body>
</html>