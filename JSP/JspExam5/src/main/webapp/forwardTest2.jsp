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
	<h2>포워드 된 페이지(forwardTest2.jsp)</h2>
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="<%=request.getParameter("name")%>"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="<%=request.getParameter("age")%>"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" value="<%=request.getParameter("address")%>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="tel" value="<%=request.getParameter("tel")%>"/></td>
		</tr>
	</table>
</body>
</html>