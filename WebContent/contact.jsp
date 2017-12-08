<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" class="js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta name="format-detection" content="telephone=no"/>
    <title>联系</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/theme.css">
    <link rel="stylesheet" href="css/main.min.css" />
    <link rel="stylesheet" href="css/gainseestyle.css" />
    <style>html,body{margin:0;padding:0;}
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}</style>
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="js/webplate.min.js"></script>
    <script src="js/script.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/headroom.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/analytics.js"></script>
</head>

<body ryt12934="1">
<script>
    $(document).ready(function(){
        $("button").click(function(){
            $(".navbar-inverse").toggleClass("navbar-bg");
        });
        $(".news-item").click(function(){
            window.location=$(this).find("a").attr("href");
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

        <div  class="text-center-tight"><div class="inner">
            
                <h2>Contact 宜居宝宝</h2>
                <h6>联系宜居宝宝</h6>
        </div></div>
        <a href="javascript:;" class="anchor scroll-down fadeInDown"></a>
    </div>



    <div class="bg-image" style="background-image:url(img/contact/1-16030G91952427.jpg)"></div>


</header>
<div class="stripe">

    <div class="container-fluid anchor-scroll">
        <div class="row featurette" align="center">
            <div class="col-lg-12">
                <h2>随时随地！想住就住！ </h2>

            </div>
        </div>
    </div>

    <div class="lianxi">
        <div class="lxleft" >宜居宝宝有限公司</div>
        <div  class="lxright" >
            <ul>
                <li ><i class="fa-lg fa">d</i>宜居宝宝</li>
                <li><i class="fa-lg fa">e</i>025-88888888</li>
                <li><i class="fa-lg fa">b</i>xxxxxxx@xxx.com</li>
                <li><i class="fa-lg fa">c</i>www.xxxxxxx.com</li>
            </ul>
        </div>
        <div style="clear:both"></div>
    </div>
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

</body></html>