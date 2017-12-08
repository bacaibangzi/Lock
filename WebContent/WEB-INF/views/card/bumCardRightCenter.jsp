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
  
		
		
		<div class="box"  id="srccontent1">
			<iframe id="Js_commTree" name="group_tree" width="100%" height="320"
					src="<%=basePath%>bumCard/rightCenterTop.htm?orgCode=${vo.orgCode}&code1=${vo.code1}&orgType=${vo.orgType}" frameborder="0"
					bordercolor="blue" scrolling="auto">
			</iframe>	
		</div>
		<div class="box1"  id="srccontent33">
			<iframe id="srccontent3" name="srccontent3" width="100%" height="320" 
					src="<%=basePath%>bumCard/rightCenterDown.htm?orgCode=${vo.orgCode}" frameborder="0"
					bordercolor="blue" scrolling="auto">
			</iframe>	
		</div>
</body>
</html>

