<%--
  Created by IntelliJ IDEA.
  User: xim
  Date: 7/22/15
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>健身房管理系统</title>
    <link rel="stylesheet" href="/web/lib/css/bootstrap.min.css"/>
</head>
<div class="container">
    <body>
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/web">健身房管理系统</a>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li role="presentation"><a href="/web/users">用户管理</a></li>
                    <li role="presentation"><a href="/web/employees">员工管理</a>
                    </li>
                    <li role="presentation"><a href="/web/courses">课程管理</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <h1>欢迎来到健身房管理系统</h1>
        <p>
            健身房是城市里用来健身的场所。一般而言，都有齐全的器械设备，有较全的健身及娱乐项目，有专业的教练进行指导，有良好的健身氛围。
            在健身房不仅能锻炼肌肉，让身材更有形，也能认识很多新朋友。
        </p>
        <p>
            <a class="btn btn-lg btn-primary" href="/web/users" role="button">进入系统</a>
        </p>
    </div>
    </body>
</div>
</html>
