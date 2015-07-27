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
    <link rel="stylesheet" href="/web/lib/css/bootstrap.min.css"/>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <a href="/web/logout">退出登录</a>
    <h1>修改用户信息</h1>
    <form action="/web/userUpdate" method="post" id = "updateUserForm">
        <input name = "id" hidden="hidden" value="${user.id}">
        姓名 <input name = "name" value="${user.name}">
        对应的员工 <select name="employee">
        <option value="${user.employee.id}">${user.employee.name}</option>
        <c:forEach var="employee" items = "${employees}">
            <option value = "${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
        密码 <input name = "password" value="${user.password}">
        <input type="submit" value="确认修改" class="updateUser">
    </form>

</div>
<script src="/web/lib/js/jquery-1.11.1.min.js"></script>
<script src="/web/scripts/users.js"></script>
</body>
</html>
