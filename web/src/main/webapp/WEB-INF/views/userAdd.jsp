<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/12/15
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户</title>
    <link rel="stylesheet" href="/web/lib/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <a href="/web/logout">退出登录</a>
    <h1>添加新用户</h1>
    <form action="/web/userAdd" method="post" id="addUserForm">
        昵称 <input name = "name">
        对应的员工 <select name="employee">
        <c:forEach var="employee" items = "${employees}">
            <option value = "${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
        密码 <input type="text" name = "password"/>
        <input type="submit" value="添加" class="addUser">
    </form>
</div>

<script src="/web/lib/js/jquery-1.11.1.min.js"></script>
<script src="/web/scripts/users.js"></script>
</body>
</html>