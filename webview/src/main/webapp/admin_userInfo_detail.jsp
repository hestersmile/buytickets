<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>电影抢票管理系统_电影信息_详情</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/index1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/list.css">
    <script>
        var type = 3;
    </script>
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/slide.js"></script>
</head>

<body>
<!-- 页头 -->
<div id="header">
    <h1 id="title">电影抢票管理系统 </h1>
    <ul id="menu">
        <li><a href="/getMovieInfos/getShowingMovie" class="active">电影信息</a></li>
        <li><a href="/getUserInfos/getMovieUserInfos">用户信息</a></li>
        <li><a href="/getOrderInfos/getOrderAllList">订单信息</a></li>
        <li><a href="/">退出登录</a></li>
    </ul>
    <p id="slide"></p>
</div>
<!-- 页面主体 -->
<div id="container">
    <div id="list" class="center detail">
        <ul class="list_detail center">
            <li class="list_title">用户信息详情</li>
            <li>用户id&nbsp;${userdetails.id}</li>
            <li>用户名称&nbsp; ${userdetails.musername}</li>
            <li>用户登陆形式&nbsp;
                                <c:if test="${userdetails.loginType=='1'}">qq登陆</c:if>
                                <c:if test="${userdetails.loginType=='0'}">管理员登陆</c:if>
                                <c:if test="${userdetails.loginType=='2'}">qq登陆</c:if></li>
            <li>用户邮箱&nbsp; ${userdetails.memail}</li>
        </ul>
    </div>
</div>
<!-- 页尾 -->
<div class="footer">
    <p class="film_right">Copyright © 2016 <a href="http://www.citicbank.com/" target="_blank">中信银行</a> All Rights
        Reserved</p>
</div>
</body>

</html>
