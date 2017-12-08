<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>common/js/ztree/css/demo.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>common/js/ztree/css/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="<%=basePath%>common/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/ztree/js/jquery.ztree.core-3.3.js"></script>
<%-- <script type="text/javascript" src="<%=basePath %>common/js/ztree/js/jquery.ztree.excheck-3.3.js"></script>
<script type="text/javascript" src="<%=basePath %>common/js/ztree/js/jquery.ztree.exedit-3.3.js"></script> --%>
</head>
<SCRIPT type="text/javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true,
					idKey:"id",
					pIdKey:"pid",
					rootPId:"-1"
				}
			},
			async: {  
	            enable: true,  
	            url:"<%=basePath%>area/treeByCode.htm",
				autoParam : [ "id"],
				dataType : "json",
				type : "post"
			},
			callback : {
				beforeClick : beforeClick
			}
	};

	function beforeClick(treeId, treeNode) {
		if (!treeNode.isParent) {
			alert("请选择父节点");
			return false;
		} else {
			window.parent["group_info"].location="<%=basePath %>area/center.htm?code="+treeNode.id;
			return true;
		}
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting);
		var winH =$("#page",window.parent.parent.document).height()-10; //-10PX是防止高度溢出,只针对本页面
		treeDemo.style.height=winH+'px';
	});

	$(window.parent.parent.parent).resize(function(){
		var winH =$("#page",window.parent.parent.document).height(); 
		var b = window.parent.document; //获取右侧iFrame
		b.body.style.height=winH+'px';
		b.getElementById("Js_asideMod").style.height=winH+'px';
		b.getElementById("Js_commTree").style.height=winH+'px';
		b.getElementById("Js_mainMod").style.height=winH+'px';
		b.getElementById("group_info").style.height=winH+'px';
		b.getElementById("Js_spitBarMod").style.height=winH+'px';
		treeDemo.style.height=winH-10; //-10PX是防止高度溢出,只针对本页面
		//window.location.reload();
	});
</SCRIPT>
<body style="overflow-x: hidden; overflow-h: hidden;">
	<div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</body>
</html>


