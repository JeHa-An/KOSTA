<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOSTA BANK</title>
<style>
	body {
		marign: 0;
	}
</style>
</head>
<body>
<% 
	String ipage = (String)request.getAttribute("page");
%>
<table style="width:100%;">
	<thead>
		<tr>
			<td>
				<%@ include file="header.jsp" %>
				<%-- <% pageContext.include("header.jsp"); %> --%>
			</td>
		</tr>	
	</thead>
	<tbody>
		<tr>
			<td>
				<%
					if(ipage!=null) {
						pageContext.include(ipage+".jsp");
					}
				%>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>