<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课表管理</title>
</head>
<body>
<div>
    <a href="/web/logout">退出登录</a>
    <h1>课程列表</h1>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>私教</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.number}"></c:out></td>
                <td><c:out value="${customer.name}"></c:out></td>
                <td><c:out value="${customer.gender}"></c:out></td>
                <td><c:out value="${customer.employee.name}"></c:out></td>
                <td><a href="/web/customerUpdate/<c:out value="${customer.id}"/>">修改</a></td>
                <td><a href="/web/customerDelete/<c:out value="${customer.id}"/>">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <a href="/web/customerAdd">添加</a>
</div>

</body>
</html>
