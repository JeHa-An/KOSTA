<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <style>
        body {
      /*   margin: 0 auto; */
        }

        .container {
            /* padding:10px; */
            border: 1px solid;
            width: 660px;
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
            text-align: center;
            background-color: lightgrey;
        }
        .colume {
            text-align: center;
            padding:5px;
            width: 100px;
            float: left;
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
<body>
<%@ include file="header.jsp" %>
    <div style="text-align: center;">
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
                    <div class="title colume">타입</div>
                    <div class="title colume">등급</div>
                </div>
            </div>
            <c:set var="i" value="1"/>
            <c:forEach var="acc" items="${accs }">
            <div class="container" id="container">
            	<div class="row">
            		<div class="colume">${i }</div>
                	<div class="colume">${acc.id }</div>
                	<div class="colume">${acc.name }</div>
                	<div class="colume">${acc.balance }</div>
                	<div class="colume">${acc.type }</div>
               		<div class="colume">${acc.grade }</div>
               		<c:set var="i" value="${i+1 }"/>
           		</div>
           	</div>  	
            </c:forEach>
        </form>
    </div>
</body>