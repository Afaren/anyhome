<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


		<%
				String contextPath = request.getContextPath();
				String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + contextPath;
				//String path_2 =ServletContext.getRealPath();
				String path_2 = this.getClass().getClassLoader().getResource("/").getPath();
				String path_3 = request.getSession().getServletContext().getRealPath("/"); 
		%>
		<%=path_2 +"\n"%>
	
		<%=path_3 %>
		
		
		
		<img src="<%=path%>/upload/1.jpg" alt="house"/>
		<img src="<%=path%>/upload/1441589310890.jpg" alt="anotherPicture"/>
		
		
		
</body>
</html>