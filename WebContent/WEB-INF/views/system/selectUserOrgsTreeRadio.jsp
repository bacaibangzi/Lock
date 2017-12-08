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
							切换部门
						</a>
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
						//changeChecked();
					},
					theme : "bbit-tree-lines",
					isShowBase:false,
					contextMenu:false,
					cookieName:"bigTree",
					onnodeclick:function(org){
						//window.parent["group_info"].location="<%=basePath %>org/center.htm?code="+org.code+"&orgType="+org.type;

					    $("#selectedIds").val(org.code);
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
		    $("#selectedIds").val(selectedIds);
    	}

		function saveUserOrgs(){
			/*
			var selectedIdArray = $("#bigTreeDiv")[0].t.getSelectedIds();
	
			var selectedIds ="";
			$.each(selectedIdArray,function(i,item){
		        if(item != ''){
		            selectedIds += item;
		        }
		    });
			*/
			var value = $("#selectedIds").val();
			if(!value){
				fh.alert('请选择部门',this,this);
				return;
			}

	
			$.ajax({
				type: "POST", 
				url: "<%=basePath %>userOrgs/changeUserOrgs.htm?orgCode="+value,
				data: "entityIds=${vo.userId}",
				beforeSend: function(){
	               //window.parent.showInfo();
	            },
				success: function(msg){
					fh.alert('切换成功',this,this);
				}
			});
			
		}


    	
    </script>
    
</body>
</html>


