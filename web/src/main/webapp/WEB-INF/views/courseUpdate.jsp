<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/21/15
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改课程信息</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>修改课程信息</h1>
<form action="/web/courseUpdate" method="post">
    <input name = "id" hidden="hidden" value="${course.id}">
    名称 <input name = "name" value="${course.name}">
    描述 <input name = "describes" value="${course.describes}">
    教练
    <select name="employee">
        <option value="${course.employee.id}">${course.employee.name}</option>
        <c:forEach var="employee" items="${employees}">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
