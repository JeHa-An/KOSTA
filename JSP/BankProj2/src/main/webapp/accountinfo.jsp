<%@page import="dto.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
 
<%
	Account acc = (Account)request.getAttribute("acc");
%>
<!DOCTYPE html>
<html>
    <style>
        body {
            margin: 0 auto;
            
        }

        .container {
        	margin: 0 auto;
            padding: 10px;
            border: 1px solid;
            width: 280px;
            text-align: center;
        }

        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            width: 70px;
            float: left;
            font-weight: bold;
        }

        .input {
            float: left;
        }

        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgrey;
        }
    </style>
<body>
	<%@ include file="header.jsp" %>
   <div style="text-align: center;">
        <div class="header">
            <h3>계좌조회</h3>
        </div>

        <div class="container" id='result'>
            <div class="row">
                <div class="title">계좌번호</div>
                <div class="input"><input type="text" name="id" id='id' value="<%=acc.getId()%>" disabled></div>
            </div>
            <div class="row">
                <div class="title">이름</div>
                <div class="input"><input type="text" name="name" id='name' value="<%=acc.getName()%>" disabled></div>
            </div>
            <div class="row">
                <div class="title">입금액</div>
                <div class="input"><input type="text" name="money" id='money' value=<%=acc.getBalance()%> disabled></div>
            </div>
            <div class="row">
                <div class="title">종류</div>
                <div class="input"><input type="text" name="type" id='type' value=<%=acc.getType()%> disabled></div>
            </div>
            <div class="row">
                <div class="title">등급</div>
                <div class="input"><input type="text" name="grade" id='grade' value=<%=acc.getGrade()%> disabled></div>
            </div>
        </div>
    </div>
</body>
</html>