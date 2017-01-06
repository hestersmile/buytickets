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
        <link rel="stylesheet" href="" />  
    <![endif]-->
</head>

<body>
    <div class="header">
        <h1>电影抢票系统</h1>
        <div>当前用户:${movieuser.musername}</div>
    </div>
    <div class="content">
        <div class="film_show two_content">
            <div class="film_info two_left">
                <p>${moviedetails.movieTitle}</p>
                <p><span>主演：</span>${moviedetails.movieActor}</p>
                <p><span>首映：</span>${moviedetails.movieTime}</p>
                <p><span>总票数：</span>${moviedetails.movieNum}</p>
                <p>
                    <span>电影简介：</span> ${moviedetails.movieInfo}   </p>
            </div>
            <div class="film_pic two_right">
                <img title="${moviedetails.movieImgName}" alt="${moviedetails.movieImgName}" src="${moviedetails.movieImg}">
            </div>
        </div>
    </div>
    <from class="form_buy" id="refresh">
        <div class="film_buy form-inline">
            <label for="btn_buy">现有票数<span>${moviedetails.movieTempNum}</span></label>
            <button type="button" class="btn inline" id="btn_buy" onclick="orderMovieItem()">抢购</button>
        </div>
    </from>
    <div class="footer">
        <p class="film_right">Copyright © 2016 <a href="" class="link0" title="中信银行" rseat="中信银行" target="_blank">中信银行</a> All Rights Reserved</p>
    </div>
    <script src="<%=basePath%>js/jquery-1.11.2.min.js"></script>
    <script src="<%=basePath%>bootstrap3.3.5/js/bootstrap.min.js"></script>
    <script>

        var mydata = {
            "userid":"",
            //获取input中name为username的值
            "movieid":""
        }

        function orderMovieItem() {
            mydata.userid=""+${movieuser.id};
            mydata.movieid=""+${moviedetails.id};
            $.ajax({
                type: "POST",
                url: "/getOrderInfos/orderMovieListByUser",
                contentType: 'application/json',
                data: JSON.stringify(mydata),
                success: function (result) {
                    var message=result.ordermessage;
                    if (result.orderstatus == "success") {
                        alert(message)
                        window.location = ("/getMovieInfos/getUpdateMovieDetailsForUser?movieid="+mydata.movieid+"&userid="+mydata.userid);
                    } else {
                        alert(message)
                    }

                }, error: function () {
                    alert("抢票失败，请稍后重试")
                }
            });
        }
        setInterval(function() {
           var myuserid=""+${movieuser.id};
           var mymovieid=""+${moviedetails.id};
            window.location =("/getMovieInfos/getUpdateMovieDetailsForUser?movieid="+mymovieid+"&userid="+myuserid);}, 3000);
    </script>
</body>

</html>
