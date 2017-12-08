<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>

<head>
    <link href='<%=basePath %>common/css/mainpage.css' rel="stylesheet" type="text/css">
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

	<div class="areatreetype">
		<div class="bj_tabs_tab">
			<ul>
				<li class="active"><a href="javascript:void(0);">区域结构</a></li>
				<li><a href="javascript:void(0);">门店结构</a></li>
			</ul>
        </div>
		<div class="bj_tabs_content">
			<div class="tabs_content show">
            	<div id="bigTreeDiv"></div>
			</div>
			<div class="tabs_content">
				<div id="mdTreeDiv"></div>
			</div>
		</div> 
	</div>

	
	<script type="text/javascript" src="<%=basePath %>common/js/ln.cookies.config.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/tree.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/jquery.contextMenu.js"></script>

    <script language="javascript" type="text/javascript">	
		var orgData = ${nodeList};
		var mdData = ${mdList};

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
					window.parent["group_info"].location="<%=basePath %>user/center.htm?orgCode="+org.code;
				},
				data: orgData
			}; 
			init(o);
			$("#bigTreeDiv").treeview(o);

			// 
			var m = {
				cbiconpath: '<%=path%>/common/js/tree/images/tree/',
				title:'组织机构信息',	
				showcheckbox : true,
				showcheck : true,
				cascadecheck : true,
				oncheckboxclick : false,
				theme : "bbit-tree-lines",
				isShowBase:false,
				contextMenu:false,
				cookieName:"mdData",
				onnodeclick:function(org){
					window.parent["group_info"].location="<%=basePath %>user/center.htm?orgCode="+org.code;
				},
				data: mdData
			}; 
			init(m);
			$("#mdTreeDiv").treeview(m);
				
		});

        $(".bj_tabs_tab > ul > li").click(function(i) {
	        var i = $(".bj_tabs_tab > ul > li").index($(this));
	        $(".bj_tabs_content > .show").removeClass("show");
	        $(".bj_tabs_content > .tabs_content").eq(i).addClass("show");
	        $(".bj_tabs_tab > ul > li").eq(i).addClass("active").siblings().removeClass("active");
        });
    </script>


</body>
</html>


