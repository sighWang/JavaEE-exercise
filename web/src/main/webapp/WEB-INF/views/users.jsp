<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理主页</title>
    <link rel="stylesheet" href="/web/style/navigation.css"/>
    <link rel="stylesheet" href="/web/style/users.css"/>
</head>
<body>
<%@include file="navigation.jsp"%>
<div class="users">
    <a class="normal-button" href="/web/logout">退出登录</a>
    <table class="users-table">
        <tr>
            <th>姓名</th>
            <th>密码</th>
            <th>对应员工</th>
            <th>修改</th>
            <th>删除</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.password}"></c:out></td>
                <td><c:out value="${user.employee.name}"></c:out></td>
                <td><a class="button" date-id="<c:out value="${user.id}"/>" href="/web/userUpdate/<c:out value="${user.id}"/>">修改</a></td>
                <%--<td><a class="button" data-id="<c:out value="${user.id}"/>" class="userUpdate">修改</a></td>--%>
                <td><a class="button userDelete" data-id="<c:out value="${user.id}"/>" >删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a class="normal-button" href="/web/userAdd">添加</a>
</div>
<script src="/web/lib/js/jquery-1.11.1.min.js"></script>
<script src="/web/scripts/users.js"></script>
</body>
</html>
