<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        tbody {
            
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
   <div style="text-align: center;">
        <div class="header">
            <h3>출금</h3>
        </div>
        <div class="container" id='withdraw'>
            <form id='form' action="withdraw" method="post">
                <div class="row">
                    <div class="title">계좌번호</div>
                    <div class="input"><input type="text" name="id"></div>
                </div>
                <div class="row">
                    <div class="title">출금액</div>
                    <div class="input"><input type="text" name="money"></div>
                </div>
                <div class="button">
                    <input type="submit" value="출금">
                </div>
            </form>
        </div>

    </div>
</body>
</html>