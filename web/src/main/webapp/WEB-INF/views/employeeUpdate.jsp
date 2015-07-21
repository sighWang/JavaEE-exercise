<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/21/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>修改员工信息</h1>
<form action="/web/employeeUpdate" method="post">
    <input name = "id" hidden="hidden" value="${employee.id}">
    姓名 <input name = "name" value="${employee.name}">
    性别 <input name = "gender" value="${employee.gender}">
    角色 <input name = "role" value="${employee.role}">
    <input type="submit" value="确认修改">
</form>
</body>
</html>
