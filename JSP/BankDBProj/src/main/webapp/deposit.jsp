<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        body {
            margin: 0 auto;
            
        }

        .container {
            padding: 10px;
            border: 1px solid;
            width: 280px;
            margin: 0 auto;
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
</head>
<body>
<%@ include file="header.jsp" %>
    <div style="text-align: center;">
        <div class="header">
            <h3>입금</h3>
        </div>
        <div class="container" id='deposit'>
            <form id='form' action="deposit" method="post">
                <div class="row">
                    <div class="title">계좌번호</div>
                    <div class="input"><input type="text" name="id"></div>
                </div>
                <div class="row">
                    <div class="title">입금액</div>
                    <div class="input"><input type="text" name="money"></div>
                </div>
                <div class="button">
                    <input type="submit" value="입금">
                </div>
            </form>
        </div>
    </div>
</body>
</html>