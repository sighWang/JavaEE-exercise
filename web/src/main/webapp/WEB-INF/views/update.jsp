<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/12/15
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>修改用户信息</h1>
    <form action="/web/userUpdate" method="post">
        <input name = "id" hidden="hidden" value="${user.id}">
        姓名 <input name = "name" value="${user.name}">
        性别 <input name = "sex" value="${user.sex}">
        邮箱 <input name = "email" value="${user.email}">
        年龄 <input name = "age" value="${user.age}">
        密码 <input name = "password" value="${user.password}">
        <input type="submit" value="确认修改">
    </form>
</body>
</html>
