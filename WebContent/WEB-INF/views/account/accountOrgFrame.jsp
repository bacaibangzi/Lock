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
  
  		<div id="Js_asideMod" class="fixed-side">
			<iframe id="Js_commTree" name="group_tree" width="100%"
				src="<%=basePath%>accountOrg/leftTree.htm?orgCode=${sessionScope.accountInfo.orgCode}" frameborder="0"
				bordercolor="blue" scrolling="auto">
			</iframe>
		</div>
		<!-- main box -->
		<div id="Js_mainMod" class="fixed-main">
			<iframe name="group_info" width="100%" id="group_info"
				src="<%=basePath%>accountOrg/center.htm?code=${sessionScope.accountInfo.orgCode}" frameborder="0"
				bordercolor="blue" scrolling="auto">
			</iframe>
		</div>
		<!--split bar-->
		<div id="Js_spitBarMod" class="Js_closeBar fixed-bar"></div>
    	<script type="text/javascript" src="<%=basePath %>common/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>common/js/common.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				barControlSplit();

				var resizeH = window.parent.document.body.clientHeight - 150 ;
				$("#Js_spitBarMod").height(resizeH);
				$("#Js_mainMod").height(resizeH);
				$("#Js_mainMod").find("iframe").height(resizeH);
				$("#Js_asideMod").height(resizeH);
				$("#Js_asideMod").find("iframe").height(resizeH);
			})
		</script>
</body>
</html>

