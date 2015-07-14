<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/14/15
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<form action="/web/login" method="post">
    姓名 <input name="name" type="text"/> 密码 <input name="password" type="text">
    <input type="submit" value="提交">
</form>
</body>
</html>
