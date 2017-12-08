<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en"
      class="js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no"/>
    <title>关于</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/theme.css">
    <link rel="stylesheet" href="css/main.min.css"/>
    <link rel="stylesheet" href="css/gainseestyle.css"/>
    <script src="js/main.min.js"></script>
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="js/webplate.min.js"></script>
    <script src="js/script.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/headroom.min.js"></script>
    <script src="js/script.js"></script>
    <script async src="js/analytics.js"></script>
</head>

<body ryt12934="1">
<script>
    $(document).ready(function () {
        $("button").click(function () {
            $(".navbar-inverse").toggleClass("navbar-bg");
        });
        $(".news-item").click(function () {
            window.location = $(this).find("a").attr("href");
            return false;
        });
    });
</script>
<nav class="absolute">
    <div >
        <nav class="navbar navbar-inverse navbar-static-top ">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse collapse daohang">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='index.jsp'>首页</a></li> 
                        <li><a href='about.jsp' ><span>关于</span></a></li>
                        <li><a href='contact.jsp' ><span>联系</span></a></li>
                    </ul>
                </div>
                <div class="navbar-iphone">
                    <span>025</span>-8888888
                </div>
            </div>
        </nav>
    </div></nav>

<header class="stripe full">

    <div class="contain">

        <div class="text-center-tight">
            <div class="inner">

                <h2>About 宜居宝宝</h2>
                <h6>关于宜居宝宝</h6>


            </div>
        </div>

        <a href="javascript:;" class="anchor scroll-down fadeInDown"></a>


    </div>


    <div class="bg-image" style="background-image:url(img/about/1-16030G42304c1.jpg)"></div>

</header>
<div class="stripe">

    <div class="container-fluid anchor-scroll">
        <div class="row featurette" align="center">
            <div class="col-lg-12">


            </div>
        </div>
    </div>

    <div class="lianxi">
        <div class="ableft">宜居宝宝<br>是专业的服务租赁服务商</div>
        <div class="lxright">
            <p>
	<span style="font-size: 24px;">十年行业深耕，让我们成长为<br/>
	一家专业的服务租赁服务商。</span><br/>
                 <br/>
                 <br/>
	<span style="font-size: 24px;">专注品牌整合与体验创新研究，<br/>
	移动互联时代的服务租赁服商。</span><br/>
                 <br/>
                         <br/>
                 </p>

        </div>
        <div style="clear:both"></div>
    </div>

</div>

<div>
    <img src="img/about/about1.jpg" width="100%" height="auto" data-show="on-scroll"/>
    <img src="http://www.gainsee.com/images/about2.jpg" width="100%" height="auto" data-show="on-scroll"/>
</div>
<footer class="footer">

    <div class="nav">
        <ul id="menu">
            <li>品牌垂询电话: 025-8888888</li>
            <li>MAIL: xxxxxxx@xxxx.com  </li>
        </ul>
    </div>
    <div class="info">
        <ul id="social-menu">


            <li ><a href="#"  target="_blank" rel="external">f</a></li>
            <li ><a href="#" target="_blank" rel="external">g</a></li>
            <li ><a href="#" target="_blank" rel="external">h</a></li>
            <li ><a href="#"  rel="external">U</a></li>


        </ul>
        <p class="copyright"><a href="#">Copyright © </a><br />xxxxxxxxx Branding design Co,.Ltd.<br>
            All rights reserved. <br>
             </p>
</footer>
<script src="js/jquery.smoove.js"></script>
<script>$('.moo').smoove({offset: '10%', moveY: '15%'});</script>
</body>
</html>