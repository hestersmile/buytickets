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
    <title>电影抢票管理系统_用户信息</title>
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

        function getUserdetail(userid) {
            window.location.href = "/getUserInfos/getMovieUserInfoByID?userid="+userid;
        }
        /*
         * 点击删除按钮执行此函数
         * 	函数功能：提交	ajax请求
         */
        function deleteUserid(id) {
            $.ajax({
                url : "/getUserInfos/deleteMovieUserInfos",
                type : "GET",
                data :"id="+ id,
                success : function(stats) {
                    if (stats == "success") {
                        alert("请求成功");
                    }else {
                        alert("请求失败");
                    }
                },
                error : function(stats) {
                    alert("连接出错，请稍后重试");
                }
            });
        }

        /*

         */
        function searchUserlist(pageSize) {
            var str = document.getElementById("info_search").value;
            alert(str);
            if(str==null){
                $("#body").load("/getUserInfos/getMovieUserInfos?pageNum=" + 1 + "&pageSize=" + pageSize);
            }else {
                $("#body").load("/getUserInfos/searchMovieUserInfos?searchStr=" + str);
            }
        }
        function pageSubmit(pageSize) {
            var b = document.getElementById("pagenum").value;
            queryInfo(b, pageSize);
        }
        function queryInfo(pageNum, pageSize) {
            $("#body").load("/getUserInfos/getMovieUserInfos?pageNum=" + pageNum + "&pageSize=" + pageSize);
        }
    </script>
</head>

<body>
<div id="body">
    <!-- 页头 -->
    <div id="header">
        <h1 id="title">电影抢票管理系统 </h1>
        <ul id="menu">
            <li><a href="/getMovieInfos/getShowingMovie" >电影信息</a></li>
            <li><a href="" class="active">用户信息</a></li>
            <li><a href="/getOrderInfos/getOrderAllList">订单信息</a></li>
            <li><a href="/">退出登录</a></li>
        </ul>
    </div>
    <!-- 搜索添加 -->
    <div id="search_add">
        <!-- 搜索表单 -->
        <div id="search_area">
            <form class="condition_search">
                <div class="film_search form-inline">
                    <input type="input" class="form-control" id="info_search" placeholder="请输入用户名">
                    <button type="button" class="btn inline" id="btn_search" onclick="searchUserlist(${pagehelper.pageSize})">搜索</button>
                </div>
            </form>
        </div>
        <div id="search" class="oper">
            <p class="left"></p>
            <a href="javascript:void(0);" >搜索</a>
            <p class="right"></p>
        </div>
       <%-- <!-- 添加按钮 -->
        <div id="add" class="oper">
            <p class="left"></p>
            <a href="<%=basePath%>admin_movieInfo_add.jsp">添加</a>
            <p class="right"></p>
        </div>--%>
    </div>
    <!-- 页面主体 -->
    <div id="container">
        <!-- 列表 -->
        <div id="list" class="center list user_info_list">
            <ul class="list_tag">
                <li>用户id</li>
                <li>用户名称</li>
                <li>用户登陆形式</li>
                <li>用户邮箱</li>
                <li class="operation">操作</li>
            </ul>
            <c:forEach items="${pagehelper.list }" var="item">
                <ul class="list_value" id="movie_info${item.id }">
                    <li>${item.id }</li>
                    <li>${item.musername}</li>
                    <li><c:if test="${item.loginType=='1'}">qq登陆</c:if>
                        <c:if test="${item.loginType=='0'}">管理员登陆</c:if>
                        <c:if test="${item.loginType=='2'}">qq登陆</c:if>
                    ${item.loginType }</li>
                    <li>${item.memail }</li>
                    <li class="operation">
                        <a href="javascript:void(0);" onclick="getUserdetail(${item.id })">查看</a>
                        <a href="javascript:void(0);" onclick="deleteUserid(${item.id })">删除</a>
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
