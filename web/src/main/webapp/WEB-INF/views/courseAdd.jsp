<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新课程</title>
    <link rel="stylesheet" href="/web/style/navigation.css"/>
    <link rel="stylesheet" href="/web/style/addCourse.css"/>
</head>
<body>
<%@include file="navigation.jsp"%>
<div class = "add-course">
    <a class="logout-button" href="/web/logout">退出登录</a>
    <h1>添加新课程</h1>
    <form action="/web/courseAdd" method="post" class="add-form">
        名称 <input name = "name" class="add-input">
        描述 <input name = "describes" class="add-input">
        教练 <select name="employee" class="add-input">
        <c:forEach var="employee" items = "${employees}">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
        <input class="add-button" type="submit" value="添加">
    </form>
</div>
</body>
</html>
