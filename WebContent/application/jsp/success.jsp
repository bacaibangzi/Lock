<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/includejs.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>test</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="refresh" content="1;url=<s:url action='return' namespace='/' />?menuId=${menuId}" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<style type="text/css">
			ul{
				list-style-type: none;
				margin:0;
				padding:0;
			}
		</style>
		
		<script type="text/javascript">
			function showMsg(){
				var allLi = document.getElementsByTagName("LI");
				var message = "";
				for(var i = 0; i < allLi.length; i++){
					message = message + allLi[i].innerHTML;
				}
				fh.alert(message);
			}
		</script>
		
	</head>

	<body onload="showMsg()">
		<div style="display:none"><s:actionmessage/></div>
	</body>
</html>
