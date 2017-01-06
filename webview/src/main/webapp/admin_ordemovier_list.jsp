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
    <%--<base href="<%=basePath%>">--%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>电影抢票管理系统_订单信息</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/index1.css">
    <script>
        var type = 3;
    </script>
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/slide.js"></script>
    <script type="text/javascript">
        /*
         * 查看具体某个电影的所有信息
         */

        function getOrderdetail(movieid) {
            window.location.href = "/getOrderInfos/getOneOrderListDetail?movieid="+movieid;
        }
        /*

         */
        function searchMovielist(str,pafe) {
            if(str==null){
                $("#body").load("/getOrderInfos/getOrderAllList?pageNum=" + 1 + "&pageSize=" + 7);
            }else {
                $("#body").load("/getOrderInfos/serachMovieInfos?searchStr=" + str);
            }
        }
        function pageSubmit(pageSize) {
            var b = document.getElementById("pagenum").value;
            queryInfo(b, pageSize);
        }
        function queryInfo(pageNum, pageSize) {
            $("#body").load("/getOrderInfos/getOrderAllListaByMovieID?pageNum=" + pageNum + "&pageSize=" + pageSize);
        }
    </script>
</head>

<body>
<div id="body">
    <!-- 页头 -->
    <div id="header">
        <h1 id="title">电影抢票管理系统 </h1>
        <ul id="menu">
            <li><a href="/getMovieInfos/getShowingMovie" class="active">电影信息</a></li>
            <li><a href="/getUserInfos/getMovieUserInfos">用户信息</a></li>
            <li><a href="">订单信息</a></li>
            <li><a href="/">退出登录</a></li>
        </ul>
        <p id="slide"></p>
    </div>
    <!-- 搜索添加 -->
    <div id="search_add">
        <!-- 搜索表单 -->
        <div id="search_area">
            <form class="condition_search">
                <div class="film_search form-inline">
                    <input type="input" class="form-control" id="info_search" placeholder="请输入用户名称">
                    <button type="button" class="btn inline" id="btn_search" onclick="">搜索</button>
                </div>
            </form>
        </div>
        <div id="search" class="oper">
            <p class="left"></p>
            <a href="javascript:void(0);">搜索</a>
            <p class="right"></p>
        </div>

    </div>
    <!-- 页面主体 -->
    <div id="container">
        <!-- 列表 -->
        <div id="list" class="center list film_info_list">
            <ul class="list_tag">
                <li>订单号</li>
                <li>电影名称</li>
                <li>用户id</li>
                <li>用户昵称</li>
                <li>购买数量</li>
                <li>购买时间</li>
                <li class="operation">操作</li>
            </ul>
            <c:forEach items="${pagehelper.list }" var="item">
                <ul class="list_value" id="movie_info${item.id }">
                    <li>${item.id }</li>
                    <li>${item.movieTitle}</li>
                    <li>${item.userid }</li>
                    <li>${item.musername }</li>
                    <li>${item.ordernum }</li>
                    <li>${item.ordertime }</li>
                    <li class="operation">
                        <a href="javascript:void(0);" onclick="getOrderdetail(${item.id })">查看</a>
                    </li>
                </ul>
            </c:forEach>

        </div>
        <!-- 分页 -->
        <div class="page">
            <a href="javascript:void (0);" onclick="queryInfo(${pagehelper.firstPage},${pagehelper.pageSize})">首页</a>
            <c:if test="${!pagehelper.isFirstPage}">
                <a href="javascript:void (0);"
                   onclick="queryInfo(${pagehelper.prePage}, ${pagehelper.pageSize});">上一页</a>

            </c:if>
            <c:if test="${pagehelper.isFirstPage}">
                <a href="javascript:void (0);"
                   onclick="queryInfo(${pagehelper.firstPage},${pagehelper.pageSize})">上一页</a>

            </c:if>
            <c:if test="${!pagehelper.isLastPage}">
                <a href="javascript:void (0);"
                   onclick="queryInfo(${pagehelper.nextPage}, ${pagehelper.pageSize});">下一页</a>

            </c:if>
            <c:if test="${pagehelper.isLastPage}">
                <a href="javascript:void (0);"
                   onclick="queryInfo(${pagehelper.lastPage}, ${pagehelper.pageSize});">下一页</a>

            </c:if>
            <div class="page_go">
                <input type="text" id="pagenum">
                <a href="javascript:void(0)" id="jump" class="inline"
                   onclick="pageSubmit(${pagehelper.pageSize})">跳转</a >
            </div>
            <label>第${pagehelper.pageNum}页</label>
            <label>共${pagehelper.pages}页</label>
            <label>共${pagehelper.pageSize}条</label>
        </div>

    </div>
    <!-- 页尾 -->
    <div class="footer">
        <p class="film_right">Copyright © 2016 <a href="http://www.citicbank.com/" target="_blank">中信银行</a> All Rights
            Reserved</p>
    </div>
</div>
</body>

</html>
