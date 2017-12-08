<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style type="text/css">
   		body{margin:0px;padding:0px}
		.welcome{width:100%;height:100%;background:url(<%=path %>/common/images/error/error_bg.jpg) no-repeat center center;position: relative;}
		.error_position{width:489px;height:214px;background: url(<%=path %>/common/images/error/2.png) no-repeat;position: relative;top:50%;margin-top:-107px;left:50%;margin-left:-244px}
		.error_info{position:absolute;top:65px;left:20px;width:295px;height: 138px;color:#687B89}
		.error_detail{display:block;height:54px;line-height: 54px;position:relative;}
		.error_detail a{text-decoration: none}
		.error_detail .error_code{color:#AEBEC9;font:20px;font-weight:bold;position:absolute;left:20px;}
		.error_detail .error_back{color:#AEBEC9;font:20px;font-weight:bold;position:absolute;right:20px;}
	</style>

  </head>
  
  <body>
    <div class="welcome">
    	<div class="error_position">
    		<div class="error_detail">
    			 <a href="#" class="error_code">404错误</a>
    			 <a href="#" class="error_back"></a>
    		</div>
    		<div class="error_info">
    			对不起，您当前访问的页面不存在！
    	    <div>
    	</div>
    </div>
  </body>
</html>
