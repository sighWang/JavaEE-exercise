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
<br>
<table>
    <tr>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>邮箱</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.sex}"></c:out></td>
            <td><c:out value="${user.age}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><a href="/web/userUpdate?userId=<c:out value="${user.id}"/>">修改</a></td>
            <td><a href="/web/userDelete?userId=<c:out value="${user.id}"/>">删除</a></td>
        </tr>
    </c:forEach>

</table>
<a href="/web/userAdd">添加</a>
</body>
</html>
