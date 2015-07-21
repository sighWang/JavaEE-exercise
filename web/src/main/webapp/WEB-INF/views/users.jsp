<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>
<a href="/web/logout">退出登录</a>

<br>
<table>
    <tr>
        <td>姓名</td>
        <td>密码</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
            <td><a href="/web/userUpdate?userId=<c:out value="${user.id}"/>">修改</a></td>
            <td><a href="/web/userDelete?userId=<c:out value="${user.id}"/>">删除</a></td>
        </tr>
    </c:forEach>

</table>
<a href="/web/userAdd">添加</a>
</body>
</html>
