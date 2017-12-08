<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>common/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/common/js/jquery-1.7.2.min.js"></script> 
    
<!-- datable plugin -->	
<script type="text/javascript" src="<%=path %>/common/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=path %>/common/js/datatable/datatable.lnpagination.js"></script>
<script type="text/javascript" src="<%=path %>/common/js/datatable/jquery.datatable.columresize.js"></script>

<!-- dialog 相关js -->
<script type="text/javascript" src="<%=path %>/common/js/lhgdialog/lhgdialog.min.js"></script>
<script type="text/javascript" src="<%=path %>/common/js/fh.dialog.js"></script>			
<script type="text/javascript" src="<%=path %>/common/js/common.js"></script>

<!-- 操作相关js -->
<script type="text/javascript" src="<%=path %>/common/js/commonoperate.js"></script>
    
    