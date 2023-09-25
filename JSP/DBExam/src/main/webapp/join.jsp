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
<center>
        <div class="header">
            <h3>회원가입</h3>
        </div>
        <div class="container" id='query'>
            <form action="join" method="post" id='form'>
                <div class="row">
                    <div class="title">아이디</div>
                    <div class="input"><input type="text" name="id"></div>
                </div>
                <div class="row">
                    <div class="title">이름</div>
                    <div class="input"><input type="text" name="name"></div>
                </div>
                <div class="row">
                    <div class="title">비밀번호</div>
                    <div class="input"><input type="password" name="password"></div>
                </div>
                <div class="row">
                    <div class="title">이메일</div>
                    <div class="input"><input type="text" name="email"></div>
                </div>
                <div class="row">
                    <div class="title">주소</div>
                    <div class="input"><input type="text" name="address"></div>
                </div>
                <div class="button">
                    <input type="submit" value="회원가입">
                </div>
            </form>
        </div>	
</center>
</body>
</html>