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
<h1>添加新用户</h1>
<form action="/web/userAdd" method="post">
    姓名 <input name = "name">
    性别 <input name = "sex">
    邮箱 <input name = "email">
    年龄 <input name = "age">

    <input type="submit" value="添加">
</form>
</body>
</html>
