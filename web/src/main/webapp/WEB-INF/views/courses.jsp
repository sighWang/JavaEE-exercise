<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/21/15
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <td>名称</td>
        <td>教练</td>
        <td>课程描述</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <c:forEach var="course" items="${courses}">
        <tr>
            <td><c:out value="${course.name}"></c:out></td>
            <td><c:out value="${course.employee.name}"></c:out></td>
            <td><c:out value="${course.describes}"></c:out></td>
            <td><a href="/web/courseUpdate/<c:out value="${course.id}"/>">修改</a></td>
            <td><a href="/web/courseDelete/<c:out value="${course.id}"/>">删除</a></td>
        </tr>
    </c:forEach>

</table>
<a href="/web/courseAdd">添加</a>
</body>
</html>
