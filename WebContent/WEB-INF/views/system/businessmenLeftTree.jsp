<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>

<head>
	<link type="text/css" href="<%=basePath %>common/css/all.css" rel="stylesheet" />
	<!-- jquery plugin -->	
	<script type="text/javascript" src="<%=basePath %>common/js/jquery-1.7.2.min.js"></script>
	<!-- dialog 相关js -->
	<script type="text/javascript" src="<%=basePath %>common/js/lhgdialog/lhgdialog.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/fh.dialog.js"></script>			
	<script type="text/javascript" src="<%=basePath %>common/js/common.js"></script>
	<!-- 操作相关js -->
	<script type="text/javascript" src="<%=basePath %>common/js/commonoperate.js"></script>

		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link href="<%=basePath %>common/js/tree/js/tree.css" type="text/css" rel="stylesheet"/>
		<link href="<%=basePath %>common/js/tree/js/jquery.contextMenu.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		body { 
     		overflow-x : hidden; 
		} 
    </style>
</head>
<body oncontextmenu="return false;">
	<div id="bigTreeDiv"></div>
	<script type="text/javascript" src="<%=basePath %>common/js/ln.cookies.config.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/tree.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/jquery.contextMenu.js"></script>
  		<script type="text/javascript">	
  		</script>
    <script language="javascript" type="text/javascript">	
		var orgData = ${nodeList};

		$(document).ready(function(){
				var o = {
					cbiconpath: '<%=path%>/common/js/tree/images/tree/',
					title:'组织机构信息',	
					showcheckbox : true,
					showcheck : true,
					cascadecheck : true,
					oncheckboxclick : false,
					theme : "bbit-tree-lines",
					isShowBase:false,
					contextMenu:false,
					cookieName:"bigTree",
					onnodeclick:function(org){
						window.parent["group_info"].location="<%=basePath %>businessmen/center.htm?orgCode="+org.code+"&orgType="+org.type;
					},
					data: orgData
				}; 
				init(o);
				$("#bigTreeDiv").treeview(o);	//alert($("#bigTreeDiv").treeview(o));
			//bindTree();
			});

    </script>


</body>
</html>


