<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	
	<link href="<%=basePath%>common/css/frame.css" type="text/css" rel="stylesheet" />
	
</head>
<body class="fixed-box">
  
  		<div id="Js_asideMod" class="fixed-side1">
			<iframe id="Js_commTree" name="group_tree" width="100%"
				src="<%=basePath%>distributorMenu/leftList.htm?orgCode=${sessionScope.accountInfo.orgCode}" frameborder="0"
				bordercolor="blue" scrolling="auto">
			</iframe>
		</div>
		<!-- main box -->
		<div id="Js_mainMod" class="fixed-main1">
			<iframe name="group_info" width="100%" id="group_info"
				src="<%=basePath%>distributorMenu/rightTree.htm?orgCode=${sessionScope.accountInfo.orgCode}" frameborder="0"
				bordercolor="blue" scrolling="auto">
			</iframe>
		</div>
		<!--split bar-->
		<div id="Js_spitBarMod" class="Js_closeBar fixed-bar1"></div>
    	<script type="text/javascript" src="<%=basePath %>common/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>common/js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>common/js/winSysResize.js"></script>
</body>
</html>

