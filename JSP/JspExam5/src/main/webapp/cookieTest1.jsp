<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie1 = new Cookie("name", "anjeha");
	cookie1.setMaxAge(600); // 단위 초	
	response.addCookie(cookie1);
	Cookie cookie2 = new Cookie("age", "30");
	cookie2.setMaxAge(600); // 단위 초	
	response.addCookie(cookie2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=cookie1.getName() %></h2>
	<h2><%=cookie1.getValue() %></h2>
	<h2><%=cookie1.getMaxAge() %></h2>
	<h2><%=cookie2.getName() %></h2>
	<h2><%=cookie2.getValue() %></h2>
	<h2><%=cookie2.getMaxAge() %></h2>
	<a href="cookieTest2.jsp">쿠키 값 불러오기</a>
</body>
</html>