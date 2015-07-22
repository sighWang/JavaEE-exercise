<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/22/15
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程时间</title>
</head>
<body>
<h1>添加上课时间</h1>
<form action="/web/dateAdd" method="post">
    <input name = "id" hidden="hidden" value="${course.id}">
    名称:<c:out value="${course.name}"></c:out><br>
    教练:<c:out value="${course.employee.name}"></c:out><br>
    描述:<c:out value="${course.describes}"></c:out><br>
    <h3>时间</h3> <input type="date" name = "date"/>
    <input type="submit" value="添加">
</form>
</body>
</html>
