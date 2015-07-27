<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课表管理</title>
    <link rel="stylesheet" href="/web/lib/css/bootstrap.min.css"/>
</head>
<body>
<%@ include file="../navbar.jsp"%>
<div class="container">
    <a href="/web/logout">退出登录</a>
    <h1>课表管理</h1>
    <form id="scheduleAddForm">
        <h3>添加新课程</h3>
        课程名称<input type="text" name = "courseName"/>
        时间 <input type="date" name = "date"/>
        <input type="submit" value="提交"/>
    </form>
    <form id="scheduleUpdateForm">
        <h3>更新新课程</h3>
        课程名称<input type="text" name = "courseName"/>
        时间 <input type="date" name = "date"/>
        <input type="submit" value="提交"/>
    </form>
    <table class="table">
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
                <td><a data-id="<c:out value="${schedule.id}"/>" class="showUpdatePage">修改</a></td>
                <%--<td><a href="/web/scheduleUpdate/<c:out value="${customer.id}"/>">修改</a></td>--%>

                <%--<td><a href="/web/scheduleDelete/<c:out value="${customer.id}"/>">删除</a></td>--%>
                <td><a data-id="<c:out value="${schedule.id}"/>" class="scheduleDelete">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a href="/web/scheduleAdd">添加</a>
</div>
<script src="/web/lib/js/jquery-1.11.1.min.js"></script>
<script src="/web/scripts/schedules.js"></script>
</body>
</html>
