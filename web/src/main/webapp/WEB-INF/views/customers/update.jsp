<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改顾客信息</title>
</head>
<body>
<a href="/web/logout">退出登录</a>
<h1>修改顾客信息</h1>
<form action="/web/customerUpdate" method="post">
    <input name = "id" hidden="hidden" value="${customer.id}">
    <input name = "number" hidden="hidden" value="${customer.number}">
    编号 <c:out value="${customer.number}"></c:out>
    姓名 <input name = "name" value="${customer.name}">
    性别 <input name = "gender" value="${customer.gender}">
    私教
    <select name="employee">
        <option value="${customer.employee.id}">${customer.employee.name}</option>
        <option value="-1">——————无————————</option>
        <c:forEach var="employee" items="${employees}">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
