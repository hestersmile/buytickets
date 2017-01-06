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
    <title>电影抢票管理系统_电影信息</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/index1.css">
    <script>
        var type = 3;
    </script>
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/slide.js"></script>

</head>
<body>
<div class="page">
    <a href="javascript:void (0);" onclick="queryInfo(${pagehelper.firstPage},${pagehelper.pageSize})">首页</a>
    <c:if test="${!pagehelper.isFirstPage}">
        <li><a href="javascript:void (0);" onclick="queryInfo(${pagehelper.prePage}, ${pagehelper.pageSize});">上一页</a>
        </li>
    </c:if>
    <c:if test="${pagehelper.isFirstPage}">
        <li><a href="javascript:void (0);" onclick="queryInfo(${pagehelper.firstPage},${pagehelper.pageSize})">上一页</a>
        </li>
    </c:if>
    <c:if test="${!pagehelper.isLastPage}">
        <li><a href="javascript:void (0);" onclick="queryInfo(${pagehelper.nextPage}, ${pagehelper.pageSize});">下一页</a>
        </li>
    </c:if>
    <c:if test="${pagehelper.isLastPage}">
        <li><a href="javascript:void (0);" onclick="queryInfo(${pagehelper.lastPage}, ${pagehelper.pageSize});">下一页</a>
        </li>
    </c:if>
    <div class="page_go">
        <input type="text" id="pagenum">
        <a href="javascript:void(0)" id="jump" class="inline"
           onclick="queryInfo(<%=Integer.parseInt(session.getAttribute("sessionName").toString()) %>, ${pagehelper.pageSize});">>跳转</a>
    </div>
    <label>${pagehelper.pageNum}</label>
    <label>${pagehelper.total}</label>
    <label>${pagehelper.pageSize}</label>
</div>
</body>
</html>