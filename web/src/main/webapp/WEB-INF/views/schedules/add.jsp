<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加公共课记录</title>
</head>
<body>
<form action="/web/scheduleAdd" method="post">
    名称 <select name = "course">
    <c:forEach var="course" items = "${courses}">
    <option value="${course.id}">${course.name}</option>
    </c:forEach>
    时间 <input type="date" name = "date"/>
</select>
    <input type="submit" value="添加">
</form>
</body>
</html>
