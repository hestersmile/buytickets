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
        function getOrderByMovieid(movienum, movietempnum, movieid) {
            $("#body").load("/getOrderInfos/getOrderAllListaByMovieID?movieid=" + movieid + "&pageNum=" + 1 + "&pageSize=" + 7);

//            if (movienum != movietempnum) {
//                $("#body").load("/getOrderInfos/getOrderAllListaByMovieID?movieid=" + movieid + "&pageNum=" + 1 + "&pageSize=" + 7);
//            } else {
//                alert("没有相关订单")
//            }
        }
    </script>
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/slide.js"></script>
</head>

<body id="body">
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
            <li class="list_title">电影信息详情</li>
            <li>电影名称 &nbsp;${moviedetails.movieTitle}</li>
            <li>电影简介 &nbsp;${moviedetails.movieInfo}</li>
            <li>电影总票数 &nbsp;${moviedetails.movieNum}</li>
            <li>电影现有票数 &nbsp;${moviedetails.movieTempNum}</li>
            <li>电影演员表 &nbsp;${moviedetails.movieActor}</li>
            <li>电影上映时间 &nbsp;${moviedetails.movieTime}</li>
            <li><img  width="85%" src="${moviedetails.movieImg}" alt="${moviedetails.movieImgName}"/></li>
            <li class="operation">
                <a href="javascript:void(0);"
                   onclick="getOrderByMovieid(${moviedetails.movieNum },${moviedetails.movieTempNum },${moviedetails.id})">订单信息</a>
            </li>

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
