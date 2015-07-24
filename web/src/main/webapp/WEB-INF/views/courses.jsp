<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程列表</title>
    <link rel="stylesheet" href="/web/style/courses.css"/>
    <link rel="stylesheet" href="/web/style/navigation.css"/>
</head>
<body>
<div class="navigation">
    <ul>
        <li><a href="/web">健身房管理系统</a></li>
        <li><a href="/web/users">用户管理</a></li>
        <li><a href="/web/employees">员工管理</a></li>
        <li><a href="/web/courses">课程管理</a></li>
        <li><a href="/web/customers">顾客管理</a></li>
        <li><a href="/web/schedules">课表管理</a></li>
    </ul>
</div>
<div id="mainDiv">
    <a class="normal-button" href="/web/logout">退出登录</a>
    <table id="courses">
        <tr>
            <th>名称</th>
            <th>教练</th>
            <th>课程描述</th>
            <th>查看上课时间</th>
            <th>添加上课时间</th>
            <th>修改</th>
            <th>删除</th>
        </tr>

        <c:forEach var="course" items="${courses}">
            <tr>
                <td class="text"><c:out value="${course.name}"></c:out></td>
                <td class="text"><c:out value="${course.employee.name}"></c:out></td>
                <td class="text"><c:out value="${course.describes}"></c:out></td>
                <td class="button-td"><a class="button" href="/web/courseDates/<c:out value="${course.id}"/>">查看上课时间</a></td>
                <td class="button-td"><a class="button" href="/web/dateAdd/<c:out value="${course.id}"/>">添加上课时间</a></td>
                <td class="button-td"><a class="button" href="/web/courseUpdate/<c:out value="${course.id}"/>">修改</a></td>
                <td class="button-td"><a class="button" href="/web/courseDelete/<c:out value="${course.id}"/>">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a class="normal-button" href="/web/courseAdd">添加</a>
</div>

</body>
</html>
