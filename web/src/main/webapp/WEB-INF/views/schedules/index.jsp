<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课表管理</title>
</head>
<body>
<div>
    <a href="/web/logout">退出登录</a>
    <h1>课程列表</h1>
    <table>
        <tr>
            <td>名称</td>
            <td>时间</td>
            <td>上课学生</td>
            <td>私教</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <c:forEach var="schedule" items="${schedules}">
            <tr>
                <td><c:out value="${schedule.course.name}"></c:out></td>
                <td><c:out value="${schedule.date}"></c:out></td>
                <td><c:out value="${schedule.customer.name}"></c:out></td>
                <td><c:out value="${schedule.course.employee.name}"></c:out></td>
                <td><a href="/web/scheduleUpdate/<c:out value="${customer.id}"/>">修改</a></td>
                <td><a href="/web/scheduleDelete/<c:out value="${customer.id}"/>">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a href="/web/scheduleAdd">添加</a>
</div>
</body>
</html>
