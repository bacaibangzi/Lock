<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
</head>
<script type="text/javascript" src="<%=basePath %>common/js/jqueryByImg.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/ajaxupload.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/chars/jscharts.js?v=3.0"></script>

<html>	
	<!-- 引用资源文件 -->
	<jsp:include page="/source.htm" flush="true" />
	<body >

 	</body>
 	<script type="text/javascript">
 		
 		//浏览器大小变化监控
 		window.onresize = function(){
 			location=location; 
		}
 		
 		//计算浏览器窗口高度和宽度
		var clientWidth = document.body.clientWidth;
		var clientHeight = document.body.clientHeight;
		
		/* var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		if (userAgent.indexOf("Firefox") > -1) {
			var height = (clientHeight-122)/3.5;
		}else{
			var height = (clientHeight-122)/3.5;
		} */
			
		//计算网页宽和电脑屏幕宽比
		var cWidth = window.screen.width;
		var percent = clientWidth/cWidth*100
		if(percent>75){
			percent = 75;
		}
		
 
 	</script>
</html>            
            