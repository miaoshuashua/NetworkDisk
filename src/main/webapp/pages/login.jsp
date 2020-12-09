<%--
  Created by IntelliJ IDEA.
  User: 淼刷刷
  Date: 2020/12/1
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<div id="login">
    <h1>Login</h1>
    <form method="post">
        <input type="text" placeholder="用户名" name="username" id="userName">
        <input type="password"  placeholder="密码" name="password" id="password">
        <button class="but" type="button" onclick="checkForm()">登录</button>
    </form>
</div>
</body>
<!--导入js-->
<script src="js/jquery-3.5.1.js"></script>
<script src="js/login.js"></script>
</html>