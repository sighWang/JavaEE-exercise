<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/21/15
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新课程</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>添加新课程</h1>
<form action="/web/courseAdd" method="post">
    名称 <input name = "name">
    描述 <input name = "describes">
    教练 <select name="employee">
    <c:forEach var="employee" items = "${employees}">
        <option value="${employee.id}">${employee.name}</option>
    </c:forEach>
</select>
    <input type="submit" value="添加">
</form>
</body>
</html>
