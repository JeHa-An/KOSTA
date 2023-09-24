<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<style>
a {
	text-decoration:none;
	padding:5px;
}
.outerDiv {
	width:100%;
	height:100px;
	background-color: orange;
}
body {
	margin:0;
}
h1 {
	margin-top:0;
}
</style>
<div class="outerDiv">
	<i><h1 style="text-align:center;">KOSTA BANK</h1></i>
	<div style="float:left; margin-left:10px">
		<a href="makeaccount">계좌개설</a>
		<a href="deposit">입금</a>
		<a href="withdraw">출금</a>
		<a href="accountinfoform">계좌조회</a>
		<a href="allaccountinfo">전체계좌조회</a>
	</div>
	<div style="float:right; margin-right:10px;">
		<%if(id==null) { %>
			<a href="login">login</a>
			<a href="join">join</a>
		<%} else {%>
			<%=id %>님 환영합니다.&nbsp;&nbsp;<a href="logout">logout</a>
		<%} %>
	</div>
</div>