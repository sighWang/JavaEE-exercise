<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/12/15
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>添加新用户</h1>
<form action="/web/userAdd" method="post">
    姓名 <input name = "name">
    密码 <input type="text" name = "password"/>
    <input type="submit" value="添加">
</form>
</body>
</html>
