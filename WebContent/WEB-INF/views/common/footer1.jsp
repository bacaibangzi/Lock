<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <script type="text/javascript" src="<%=basePath%>common/js/page.js"></script>

    <script type="text/javascript">
        window.onresize=function(){changSize();};
        changSize();
    </script>
	<div id="footer">
            <p>Copyright 2016  智能门锁管理平台 版权所有 All Rights Reserved
               &nbsp&nbsp 公司地址： 智能门锁管理平台
           	   &nbsp&nbsp Built By scpos 苏ICP备xxxxxxxxxx号-1</p>
	</div>
</body>
</html>