<%--
  Created by IntelliJ IDEA.
  User: bangae1
  Date: 2016-01-12
  Time: 오후 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/resources/js/jquery-2.2.0.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.validate.js"></script>
    <script type="text/javascript" src="/resources/js/localization/messages_ko.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <style>
        .join-input {
            margin-bottom: 15px;
        }

        .error {
            color:red;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form id="joinForm" action="/user/save" method="post" style="padding: 30px 20% 0px 20%;">
        <h2 class="form-signin-heading">회원가입</h2>
        <label for="email" class="sr-only">이메일</label>
        <input type="text" id="email" name="email" class="form-control join-input" placeholder="이메일" required/>
        <label for="password" class="sr-only">비밀번호</label>
        <input type="password" id="password" name="password" class="form-control join-input" placeholder="비밀번호" required/>
        <label for="rePassword" class="sr-only">비밀번호 확인</label>
        <input type="password" id="rePassword" name="rePassword" class="form-control join-input" placeholder="비밀번호 확인" required/>
        <label for="name" class="sr-only">이름</label>
        <input type="text" id="name" name="name" class="form-control join-input" placeholder="이름" required/>
        <label for="age" class="sr-only">나이</label>
        <input type="text" id="age" name="age" class="form-control join-input" placeholder="나이"/>
        <button class="btn btn-lg btn-success btn-block" id="joinBtn" type="button">가입</button>
        <button class="btn btn-lg btn-danger btn-block" id="cancelBtn" type="button">취소</button>
    </form>
</div>
<script>

    $('#joinBtn').on('click', function() {
        if($('#joinForm').valid()) {
            $('#joinForm').submit();
        }
    })

    $('#cancelBtn').on('click', function() {
        $(location).attr('href', '/');
    })

</script>
</body>
</html>
