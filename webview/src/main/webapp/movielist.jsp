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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>电影抢票_电影列表</title>
    <link rel="stylesheet" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if lt IE 8]>
    <script  type="text/javascript">

    </script>
    <link rel="stylesheet"/>

    <![endif]-->
    <style>
        .gray {
            -webkit-filter: grayscale(100%);            /* CSS3 filter方式，webkit内核方式，firefox外的绝大部分的现代浏览器*/
                   -moz-filter: grayscale(100%);            /* 目前没有实现 */
                  -ms-filter: grayscale(100%);
                    -o-filter: grayscale(100%);
                     filter: grayscale(100%);            /* CSS3 filter方式，标准写法*/
                       filter: url(filters.svg#grayscale); /* Firefox 4+ */
                       filter: gray;                       /* IE 6-9 */

        }
        img{
            filter:url('"<%=basePath%>js/gray.svg#grayscale');
        }
    </style>
</head>

<body id="body">
<div class="header">
    <h1>电影抢票系统</h1>
    <div>当前用户:${movieuser.musername}</div>
</div>
<form class="form_search">
    <div class="film_search form-inline">
        <input type="input" class="form-control" id="info_search" placeholder="请输入电影名称">
        <button type="button" class="btn inline" id="btn_search" onclick="searchMovielist()">搜索</button>
    </div>
</form>
<ul class="film_list">
    <c:forEach items="${pagehelper.list }" var="item">

        <li>
            <div class="film_pic">
                <c:if test="${item.movieTempNum<1}">
                <a class="film_link iu"  onclick="alert('很抱歉，已经没有票了')" href="javascript:void (0)" title="${item.movieTitle }" alt="${item.movieImgName}"
                   >
                    <img class="iu gray" title="${item.movieTitle }" alt="${item.movieImgName}"
                         src="${item.movieImg}" id="grayscale">
                </a>
                </c:if>
                <c:if test="${item.movieTempNum>0}">
                    <a class="film_link" onclick="getMoviedetail(${item.id})" href="javascript:void (0)" title="${item.movieTitle }" alt="${item.movieImgName}"
                    >
                        <img title="${item.movieTitle }" alt="${item.movieImgName}"
                             src="${item.movieImg}">
                    </a>
                </c:if>
            </div>
            <div class="film_info">
                <div class="film_title">
                    <a target="_blank" alt="${item.movieImgName}" title="${item.movieTitle }" href=""
                       pos="${item.id}">${item.movieTitle }</a>
                </div>
                <p class="film_detile">现有票量：${item.movieTempNum}</p>
            </div>
        </li>
    </c:forEach>
</ul>
<!-- 分页 -->
<div class="page">
    <a href="javascript:void (0);" onclick="queryInfo(${pagehelper.firstPage},${pagehelper.pageSize})">首页</a>
    <c:if test="${!pagehelper.isFirstPage}">
        <a href="javascript:void (0);"
           onclick="queryInfo1(${pagehelper.prePage}, ${pagehelper.pageSize});">上一页</a>

    </c:if>
    <c:if test="${pagehelper.isFirstPage}">
        <a href="javascript:void (0);"
           onclick="queryInfo1(${pagehelper.firstPage},${pagehelper.pageSize})">上一页</a>

    </c:if>
    <c:if test="${!pagehelper.isLastPage}">
        <a href="javascript:void (0);"
           onclick="queryInfo1(${pagehelper.nextPage}, ${pagehelper.pageSize});">下一页</a>

    </c:if>
    <c:if test="${pagehelper.isLastPage}">
        <a href="javascript:void (0);"
           onclick="queryInfo1(${pagehelper.lastPage}, ${pagehelper.pageSize});">下一页</a>

    </c:if>
    <div class="page_go">
        <input type="text" id="pagenum">
        <a href="javascript:void(0)" id="jump" class="inline"
           onclick="pageSubmit1(${pagehelper.pageSize})">跳转</a>
    </div>
    <label>第${pagehelper.pageNum}页</label>
    <label>共${pagehelper.pages}页</label>
    <label>共${pagehelper.pageSize}条</label>
</div>
<div class="footer">
    <p class="film_right">Copyright © 2016 <a href="http://www.iqiyi.com" class="link0" title="爱奇艺" rseat="爱奇艺"
                                              target="_blank">中信银行</a> All Rights Reserved</p>
</div>
<script src="<%=basePath%>js/jquery-1.11.2.min.js"></script>
<script src="<%=basePath%>bootstrap3.3.5/js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/grayscale.js"></script>
<script>
    function searchMovielist() {
        var str = document.getElementById("info_search").value;
        if (str == null) {
            $("#body").load("/getMovieInfos/getShowingMovieListForUser?pageNum=" + 1 + "&pageSize=" + 7);
        } else {
            $("#body").load("/getMovieInfos/serachMovieInfosForUser?searchStr=" + str+ "&userid=" + ${movieuser.id});
        }
    }
    function pageSubmit1(pageSize) {
        var b = document.getElementById("pagenum").value;
        queryInfo(b, pageSize);
    }
    function queryInfo1(pageNum, pageSize) {
        $("#body").load("/getMovieInfos/getShowingMovieListForUser?pageNum=" + pageNum + "&pageSize=" + pageSize+"&userid=" + ${movieuser.id});
    }
    function getMoviedetail(movieid) {
        window.location.href = "/getMovieInfos/getUpdateMovieDetailsForUser?movieid=" + movieid+ "&userid=" + ${movieuser.id} ;
    }
    $(function(){
        console.log($('img.iu'));
        grayscale($('img.iu'));
    });
</script>
</body>

</html>

