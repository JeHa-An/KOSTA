<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        body {
            margin: 0 auto;
            
        }

        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            font-weight: bold;
            background-color: lightgrey;
        }
        .colume {
            padding:5px;
            width: 100px;
            float: left;
        }

        .container {
            /* padding:10px; */
            border: 1px solid;
            width: 660px;
        }

        .input {
            float: left;
        }

        input[type='submit'] {
            font-weight: bold;
            width:120px;
            background-color: lightgrey;
        }
    </style>
</head>
<body>
<% pageContext.include("header.jsp");%>
    <center>
        <form>
            <div class="header">
                <h3>전체 계좌 조회</h3>
            </div>
            <div class="container" id="container">
                <div class="row">
                    <div class="title colume">순서</div>
                    <div class="title colume">계좌번호</div>
                    <div class="title colume">이름</div>
                    <div class="title colume">잔액</div>
                    <div class="title colume">계좌종류</div>
                    <div class="title colume">등급</div>
                </div>
                <c:set var="i" value="1"/>
                <c:forEach var="acc" items="${accs }">
               	<div class="row">
                    <div class="colume">${i }</div>
                    <div class="colume">${acc.id }</div>
                    <div class="colume">${acc.name }</div>
                    <div class="colume">${acc.balance }</div>
                    <div class="colume">${acc.type }</div>
                    <div class="colume">${acc.grade }&nbsp;</div>
                    <c:set var="i" value="${i+1 }"/>
                </div>
                </c:forEach>
            </div>
        </form>
    </center>
</body>
</html>