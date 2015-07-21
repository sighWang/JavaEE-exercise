<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/21/15
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新员工</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>添加新员工</h1>
<form action="/web/employeeAdd" method="post">
    姓名 <input name = "name">
    性别 <input name = "gender">
    职位 <input name = "role">
    <input type="submit" value="添加">
</form>
</body>
</html>
