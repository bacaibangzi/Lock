<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
	String path = request.getContextPath();
	String skinPath = path+"/common";
	String webfilesPath = path;
%>
<link type="text/css" href="<%=path %>/common/css/all.css" rel="stylesheet" />

<!-- jquery plugin -->	
<script type="text/javascript" src="<%=path %>/common/js/jquery-1.7.2.min.js"></script> 

<!-- dialog 相关js -->
<script type="text/javascript" src="<%=webfilesPath %>/common/js/lhgdialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="<%=webfilesPath %>/common/js/fh.dialog.js"></script>			
<script type="text/javascript" src="<%=webfilesPath %>/common/js/common.js"></script>

<!-- 操作相关js -->
<script type="text/javascript" src="<%=webfilesPath %>/common/js/commonoperate.js"></script>