<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/21/15
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
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
        <td>性别</td>
        <td>职位</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <c:forEach var="employee" items="${employees}">
        <tr>
            <td><c:out value="${employee.name}"></c:out></td>
            <td><c:out value="${employee.gender}"></c:out></td>
            <td><c:out value="${employee.role}"></c:out></td>
            <td><a href="/web/employeeUpdate/<c:out value="${employee.id}"/>">修改</a></td>
            <td><a href="/web/employeeDelete/<c:out value="${employee.id}"/>">删除</a></td>
        </tr>
    </c:forEach>

</table>
<a href="/web/employeeAdd">添加</a>
</body>
</html>
