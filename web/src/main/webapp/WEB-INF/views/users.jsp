<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理主页</title>
    <link rel="stylesheet" href="/web/style/navigation.css"/>
</head>
<body>
<%@include file="navigation.jsp"%>
<div class="users">
    <a href="/web/logout">退出登录</a>
    <table>
        <tr>
            <td>姓名</td>
            <td>密码</td>
            <td>对应员工</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.password}"></c:out></td>
                <td><c:out value="${user.employee.name}"></c:out></td>
                <%--<td><a date-id="<c:out value="${user.id}"/>" id="userDelete" href="/web/userUpdate/<c:out value="${user.id}"/>">修改</a></td>--%>
                <td><a data-id="<c:out value="${user.id}"/>" class="userUpdate">修改</a></td>
                <td><a data-id="<c:out value="${user.id}"/>" class="userDelete">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a href="/web/userAdd">添加</a>
</div>
<script src="/web/lib/js/jquery-1.11.1.min.js"></script>
<script src="/web/scripts/users.js"></script>
</body>
</html>
