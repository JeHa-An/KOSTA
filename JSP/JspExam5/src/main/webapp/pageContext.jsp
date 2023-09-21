<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나는 pageContextTest1.jsp 입니다.</h1>
<%pageContext.forward("pageContext2.jsp");%>
</body>
</html>