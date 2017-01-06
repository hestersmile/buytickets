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
    <title>电影抢票_登录</title>
    <!-- <link rel="stylesheet" href="css/reset.css"> -->
    <link rel="stylesheet" href="<%=basePath%>css/reset.css">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/json2.js"></script>
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if lt IE 8]>
    <link rel="stylesheet" href=""/>
    <![endif]-->

</head>

<body id="mybody" class="center-outter center-outter-full">
<div class="film_login center-inner">
    <h1><img src="img/logo3.jpg" height="60" width="60" alt=""> 电影抢票系统</h1>
    <div class="area_login">
        <ul class="user_type">
            <li class="active">普通用户</li>
            <li>管理员</li>
        </ul>
        <form action="" class="form_login">
            <div class="login_type">
                <div class="form-group form-inline">
                    <label for="user_name">用户名</label>
                    <input type="input" class="form-control" id="user_name" placeholder="请输入用户名">
                </div>
                <div class="form-group form-inline">
                    <label for="user_psw">密码</label>
                    <input type="password" class="form-control" id="user_psw" placeholder="请输入密码">
                </div>
                <button type="button" class="btn" id="btn_login" onclick="userLogin()">登录</button>
                <div class="user_reg"  ><a href="userInfo_register"> 用户注册</a></div>
                <ul class="login_third">
                    <li><img src="img/qq.png"> QQ登录</li>
                    <li><img src="img/weixin.png" alt=""> 微信登录</li>
                    <li><img src="img/weibo.png" alt=""> 微博登录</li>
                </ul>
            </div>
            <div class="login_type">
                <div class="form-group form-inline">
                    <label for="user_name">用户名</label>
                    <input type="input" class="form-control" id="user_name1" name="user_name1" placeholder="请输入用户名">
                </div>
                <div class="form-group form-inline">
                    <label for="user_psw">密码</label>
                    <input type="password" class="form-control" name="user_psw1" id="user_psw1" placeholder="请输入密码">
                </div>
                <button type="button" class="btn" id="btn_login" onclick="adminLogin()">登录</button>
            </div>
        </form>
    </div>
</div>
<script src="js/jquery-1.11.2.min.js"></script>
<script src="bootstrap3.3.5/js/bootstrap.min.js"></script>
<script>
    $(function () {
        var tab_nav = $(".user_type li");
        var tab_content = $(".form_login .login_type");
        tab_nav.click(function () {
            var $this = $(this);
            var index = $this.index();
            $this.addClass("active").siblings().removeClass("active");
            tab_content.eq(index).show().siblings().hide();
        });
    });
</script>
</body>
<script>
    var data = {
        "musername":"",
        //获取input中name为username的值
        "muserpassword":""
    }

    function adminLogin() {
        data.musername=document.getElementById("user_name1").value;
        data.muserpassword=document.getElementById("user_psw1").value;
        $.ajax({
            type: "POST",
            url: "/getUserInfos/loginAdminMovieUser",
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                if (result.status == "success") {
                    alert("登陆成功，正在跳转")
                    window.location = ("/getMovieInfos/getShowingMovie");
                } else {
                    alert("登陆失败，请重新输入用户名密码")
                }

            }, error: function () {
                alert("登陆失败，请稍后重试")
            }
        });
    }
    function userLogin() {
        data.musername=document.getElementById("user_name").value;
        data.muserpassword=document.getElementById("user_psw").value;
        $.ajax({
            type: "POST",
            url: "/getUserInfos/loginMovieUserForNormal",
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                if (result.status == "success") {
                    alert("登陆成功，正在跳转")

                    window.location = ("/getMovieInfos/getShowingMovieListForUser?userid="+result.movieid);
                } else {
                    alert("登陆失败，请重新输入用户名密码")
                }

            }, error: function () {
                alert("登陆失败，请稍后重试")
            }
        });
    }
</script>
</html>
