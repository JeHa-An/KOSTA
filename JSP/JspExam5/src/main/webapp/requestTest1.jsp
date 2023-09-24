<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Request 예제입니다.</h1>
<table border="1" style="width:400px">
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<%
				String gender = request.getParameter("gender");
				if(gender.equals("male")) {
			%>
					남
			<%
				} else {
			%>
					여
			<%
				}
			%>
		</td>
	</tr>
	<tr>
		<td>취미</td>
		<td>
			<% 
				String[] hobbys = request.getParameterValues("hobby");
				for(String h : hobbys) {
			%>
				<%=h+"," %>
			<%
				}
			%>
		</td>
	</tr>
</table>
</body>
</html>