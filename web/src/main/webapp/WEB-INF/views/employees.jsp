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

<link rel="stylesheet" href="/web/lib/css/bootstrap.min.css"/>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>

    <br>
    <table class="table">
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>职位</th>
            <th>修改</th>
            <th>删除</th>
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

</div>
</body>
</html>
