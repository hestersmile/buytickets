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
    <link rel="stylesheet" href="<%=basePath%>css/reset1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/index1.css">
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/slide.js"></script>
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
    <link rel="stylesheet" href="<%=basePath%>css/style1.css">
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <!--[if lt IE 8]>
    <style>
        .error{
            color:red;
            padding-left: 5px;
        }
    </style>
    <link rel="stylesheet"/>
    <![endif]-->
</head>

<!-- 页头 -->
<body id="body">
<div class="header">
    <h1>电影抢票系统</h1>
</div>
<!-- 页面主体 -->
<div id="container">
    <div id="list" class="add update center">
        <form action="/getUserInfos/registerMovieUser" method="post" id="movie_update" enctype="multipart/form-data">
            <ul class="list_detail center">
                <li class="list_title">用户信息填写</li>
                <li><label>用户名称</label> &nbsp;<input class="form-control" type="text" name="musername" id="musername">
                </li>
                <li><label>用户邮箱</label> &nbsp;<input class="form-control" type="text" name="memail" id="memail"></li>
                <li><label>用户密码</label> &nbsp;<input class="form-control" type="password" name="muserpassword"
                                                     id="muserpassword"></li>
                <li><label>用户密码核对</label> &nbsp;<input class="form-control" type="password" name="muserpassword1"
                                                       id="muserpassword1"></li>
                <li class="operation">
                    <input type="submit" value="保存">
                    <input type="reset" value="重置">
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
    $(function () {
        $.validator.addMethod("checkEmail",  function isEmail() {
            var email=$('#memail').val();
            if (email.search(/^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/)!= -1){
                redflag=0;
                return true;
            }
            else{
                redflag=1;
                return false;
            }
        }, "邮箱格式错误1");
        $.validator.addMethod("checkMyname", function (value) {
            var name=document.getElementById("musername").value;
            var  result1=false;
            $.ajax({
                type: "POST",
                url: "/getUserInfos/registerMovieUserTestName",
                contentType: "application/json", //必须有
                dataType: "json", //表示返回值类型，不必须
                data: JSON.stringify({ 'musername': name }),
                async: false,
                success: function (result) {
                    if (result.status == "true" ) {
                       result1=true;
                    } else {
                    }

                }, error: function (result) {
                    if (result.status == "true" ) {
                        result1=true;
                    } else {
                    }
                }
            });
            return result1;
        }, "该用户名已注册，请重新申请1");
        $.validator.addMethod("checkMypassword", function (value) {
            var pass = document.getElementById("muserpassword").value;
            var pass1 = document.getElementById("muserpassword1").value;
            var result = false;
            if (pass == pass1) {
                result = true;
            }
            return result;
        }, "两个密码并不一致！！！！");
        $("#movie_update").validate({
            rules: {
                musername: {
                    required: true,
                    checkMyname: true
                },
                memail: {
                    required: true,
                    checkEmail: true
                },
                muserpassword: "required",
                muserpassword1: {
                    required: true,
                    checkMypassword: true
                },

            },
            messages: {
                musername: "用户名被占用，请输入用户名称",
                memail: "邮箱格式错误,请重新输入",
                muserpassword: "请输入密码",
                muserpassword1: "两个密码并不一致，请重新输入"

            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    })


</script>

</body>

</html>
