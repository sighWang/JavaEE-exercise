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
    <title>课程列表</title>
    <link rel="stylesheet" href="/web/style/navigation.css"/>
</head>
<body>
<div class="navigation">
    <ul>
        <li><a href="/web">健身房管理系统</a></li>
        <li><a href="/web/users">用户管理</a></li>
        <li><a href="/web/employees">员工管理</a></li>
        <li><a href="/web/courses">课程管理</a></li>
    </ul>
</div>
<div>
    <a href="/web/logout">退出登录</a>
    <table>
        <tr>
            <td>名称</td>
            <td>教练</td>
            <td>课程描述</td>
            <td>查看上课时间</td>
            <td>添加上课时间</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <c:forEach var="course" items="${courses}">
            <tr>
                <td><c:out value="${course.name}"></c:out></td>
                <td><c:out value="${course.employee.name}"></c:out></td>
                <td><c:out value="${course.describes}"></c:out></td>
                <td><a href="/web/courseDates/<c:out value="${course.id}"/>">查看上课时间</a></td>
                <td><a href="/web/dateAdd/<c:out value="${course.id}"/>">添加上课时间</a></td>
                <td><a href="/web/courseUpdate/<c:out value="${course.id}"/>">修改</a></td>
                <td><a href="/web/courseDelete/<c:out value="${course.id}"/>">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a href="/web/courseAdd">添加</a>
</div>

</body>
</html>
