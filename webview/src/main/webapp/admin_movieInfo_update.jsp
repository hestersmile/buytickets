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
    <title>电影抢票管理系统_电影信息_添加</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/index1.css">
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/slide.js"></script>
    <style>
        .error{
            color:red;
            padding-left: 5px;
        }
    </style>
</head>

<body>
<!-- 页头 -->
<div id="header">
    <h1 id="title">电影抢票管理系统 </h1>
    <ul id="menu">
        <li><a href="/getMovieInfos/getShowingMovie" class="active">电影信息</a></li>
        <li><a href="/getUserInfos/getMovieUserInfos">用户信息</a></li>
        <li><a href="/getOrderInfos/getOrderAllList">订单信息</a></li>
        <li><a href="/">退出登录</a></li>    </ul>
    <p id="slide"></p>
</div>
<!-- 页面主体 -->
<div id="container">
    <div id="list" class="add update center">
        <form action="/getMovieInfos/updateMovieInfos"  method="post" id="movie_update"  enctype="multipart/form-data" >
            <ul class="list_detail center">
                <li class="list_title">电影信息添加</li>
                <li><label>电影名称</label> &nbsp;<input class="form-control" type="hidden" name="id" id="id" value="${moviedetails.id}" ></li>
                <li><label>电影名称</label> &nbsp;<input class="form-control" type="text" name="movieTitle" id="movieTitle" value="${moviedetails.movieTitle}" ></li>
                <li><label>电影简介</label> &nbsp;<textarea class="form-control" name="movieInfo" cols="30" rows="10"id="movieInfo" >${moviedetails.movieInfo}</textarea>
                </li>
                <li><label>电影总票数</label> &nbsp;<input class="form-control" type="text" name="movieNum" id="movieNum"  value="${moviedetails.movieNum}"></li>
                <li><label>电影现有票数</label> &nbsp;<input class="form-control" type="text" name="movieTempNum" id="movieTempNum" value="${moviedetails.movieTempNum}"></li>
                <li><label>电影演员表</label> &nbsp;<input class="form-control" type="text" name="movieActor" id="movieActor" value="${moviedetails.movieActor}"></li>
                <li><label>电影上映时间</label> &nbsp;<input class="form-control" type="date" name="movieTime"id="movieTime"></li>
                <li><label>电影海报</label> &nbsp;<input class="form-control" type="file" name="movieImg"  id="movieImg" /></li>
                <li><label>电影海报名称</label> &nbsp;<input class="form-control" type="text" name="movieImgName" id="movieImgName" value="${moviedetails.movieImgName}"></li>
                <li class="operation">
                    <input type="submit" value="保存">
                    <input type="reset" value="重置">
                    <input type="button" value="取消">
                </li>
            </ul>
        </form>
    </div>
</div>
<!-- 页尾 -->
<div class="footer">
    <p class="film_right">Copyright © 2016 <a href="http://www.citicbank.com/" target="_blank">中信银行</a> All Rights
        Reserved</p>
</div>
<script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>js/jquery.validate.min.js"></script>
<script>
$(function(){
    $.validator.addMethod("checkFileSize",function(value){
        var aa=document.getElementById("movieImg").value.toLowerCase().split('.');//以“.”分隔上传文件字符串
        var result=false;
        if(document.form1.userfile.value=="")
        {
            alert('图片不能为空！');
            result= false;
        }
        else
        {
            if(aa[aa.length-1]=='gif'||aa[aa.length-1]=='jpg'||aa[aa.length-1]=='bmp'
                ||aa[aa.length-1]=='png'||aa[aa.length-1]=='jpeg')//判断图片格式
            {
                var imagSize =  document.getElementById("userfile").files[0].size;
                alert("图片大小："+imagSize+"B")
                if(imagSize<1024*1024*1)
                    alert("图片大小在3M以内，为："+imagSize/(1024*1024)+"M");
                result= true;
            }
            else
            {
                alert('请选择格式为*.jpg、*.gif、*.bmp、*.png、*.jpeg 的图片');//jpg和jpeg格式是一样的只是系统Windows认jpg，Mac OS认jpeg，
//二者区别自行百度
                result= false;
            }
        }
        return result;
    },"图片格式不正确！");
    $("#movie_update").validate({
        rules: {
            movieTitle: "required",
            movieNum:{
                required:true,
                number:true,
            } ,
            movieImg:{
                required:true,
                checkFileSize:true
            },
            movieTempNum:{
                required:true,
                number:true,
            },
            movieActor:{
                required:true,
            },
            movieTime:{
                required:true,
            },
            movieImgName:{
                required:true,
            },
            movieInfo:{
                required:true,
            }
        },
        messages: {
            movieTitle: "请输入电影名称",
            movieNum: "请输入电影票数",
            movieImg:"请上传正确格式(jpg,png)、大小(不超过1M)的电影海报",
            movieTempNum:"请输入现有票数（注：不可以超过总票数）",
            movieActor: "请输入电影演员",
            movieImgName: "请输入海报名称",
            movieTime:"请输入电影上映时间",
            movieInfo:"请输入电影简介"

        },
        submitHandler:function(form){
            alert("submitted");
            form.submit();
        }
    });
})

    function checkFileSize()
    {
        var aa=document.getElementById("movieImg").value.toLowerCase().split('.');//以“.”分隔上传文件字符串
        if(document.form1.userfile.value=="")
        {
            alert('图片不能为空！');
            return false;
        }
        else
        {
            if(aa[aa.length-1]=='gif'||aa[aa.length-1]=='jpg'||aa[aa.length-1]=='bmp'
                ||aa[aa.length-1]=='png'||aa[aa.length-1]=='jpeg')//判断图片格式
            {
                var imagSize =  document.getElementById("userfile").files[0].size;
                alert("图片大小："+imagSize+"B")
                if(imagSize<1024*1024*1)
                    alert("图片大小在3M以内，为："+imagSize/(1024*1024)+"M");
                return true;
            }
            else
            {
                alert('请选择格式为*.jpg、*.gif、*.bmp、*.png、*.jpeg 的图片');//jpg和jpeg格式是一样的只是系统Windows认jpg，Mac OS认jpeg，
//二者区别自行百度
                return false;
            }
        }
    }
</script>

</body>

</html>
