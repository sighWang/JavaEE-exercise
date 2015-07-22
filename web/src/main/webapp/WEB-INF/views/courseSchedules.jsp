<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/22/15
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程时间</title>
</head>
<body>
<c:out value="${course.name}"></c:out>课程时间表
<table>
    <tr>
        <td>时间</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <c:forEach var="schedule" items="${schedules}">
        <tr>
            <td><c:out value="${schedule.date}"></c:out></td>
            <td><a href="/web/courseUpdate/<c:out value="${schedule.id}"/>">修改</a></td>
            <td><a href="/web/courseDelete/<c:out value="${schedule.id}"/>">删除</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
