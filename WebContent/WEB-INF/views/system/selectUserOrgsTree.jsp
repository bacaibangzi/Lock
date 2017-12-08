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
</head>
<body oncontextmenu="return false;">
	
	<div class="contenbox">
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						<a hideFocus="true" href="javascript:saveUserOrgs()" class="gray_radiu_btn" >
							<em class="gray_l"></em>
							<em class="gray_r"></em> 
							确定
						</a>
						<span style='color: red;'>勾选代表此用户不能使用该门组</span>
				</div>
			</div>
    		<div style="background:#AAAAAA;height:1px;margin-top:5px;margin-bottom:5px"></div>
    		<div id="bigTreeDiv"  ></div>
    </div>

	<div id="bigTreeDiv"></div>
	<input type="hidden" id="orgCode" name="orgCode" />
	<input type="hidden" id="orgName" name="orgName" />
	<input type="hidden" id="selectedIds" name="selectedIds" />
	<script type="text/javascript" src="<%=basePath %>common/js/ln.cookies.config.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/tree.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/jquery.contextMenu.js"></script>
    <script language="javascript" type="text/javascript">
    	document.body.style.backgroundColor="white";
		var orgData = ${nodeList};
		$(document).ready(function(){
				var o = {
					cbiconpath: '<%=path%>/common/js/tree/images/tree/',
					title:'组织机构信息',	
					showcheckbox : true,
					showcheck : true,
					cascadecheck : true,
					onaftercheckboxclick : function(org){
						changeChecked();
					},
					theme : "bbit-tree-lines",
					isShowBase:false,
					contextMenu:false,
					cookieName:"bigTree",
					onnodeclick:function(org){
						window.parent["group_info"].location="<%=basePath %>org/center.htm?code="+org.code+"&orgType="+org.type;
					},
					data: orgData
				}; 
				init(o);
				$("#bigTreeDiv").treeview(o);	//alert($("#bigTreeDiv").treeview(o));

				//bindTree();

				// 默认初始化
				changeChecked();
				
			});
		
    </script>
    
    <script type="text/javascript">

    	function changeChecked(){
    		var selectedIdArray = $("#bigTreeDiv")[0].t.getSelectedIds();
			var selectedIds ="";
			$.each(selectedIdArray,function(i,item){
		        if(item != ''){
		            selectedIds += item;
		        }
		    });
		    //alert(selectedIds);
		    $("#selectedIds").val(selectedIds);
    	}

		function saveUserOrgs(){
	
			var selectedIdArray = $("#bigTreeDiv")[0].t.getSelectedIds();
	
			var selectedIds ="";
			$.each(selectedIdArray,function(i,item){
		        if(item != ''){
		            selectedIds += item;
		        }
		    });

	
			$.ajax({
				type: "POST", 
				url: "<%=basePath %>userOrgs/saveUserOrgs.htm?orgCode=${vo.orgCode}&userId=${vo.userId}",
				data: "entityIds="+selectedIds,
				beforeSend: function(){
	               //window.parent.showInfo();
	            },
				success: function(msg){
					fh.alert('保存成功',this,this);
				}
			});
			
		}


    	
    </script>
    
</body>
</html>


