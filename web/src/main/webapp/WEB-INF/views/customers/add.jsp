<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加新顾客</title>
</head>
<body>
<form action="/web/customerAdd" method="post">
    名称 <input name = "name">
    性别 <input name = "gender">
    教练 <select name="employee">
    <option value="-1">暂不指定私教</option>
    <c:forEach var="employee" items = "${employees}">
        <option value="${employee.id}">${employee.name}</option>
    </c:forEach>
</select>
    <input type="submit" value="添加">
</form>
</body>
</html>
