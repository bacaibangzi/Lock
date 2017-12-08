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
<body oncontextmenu="return false;"  bgcolor="#ffffff">

    <div class="contenbox">
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						<a hideFocus="true" href="javascript:saveRoleMenu()" class="gray_radiu_btn" >
							<em class="gray_l"></em>
							<em class="gray_r"></em> 
							保存用户角色
						</a>
				</div>
			</div>
    		<div style="background:#AAAAAA;height:1px;margin-top:5px;margin-bottom:5px"></div>
    		<div id="bigTreeDiv"  ></div>
    </div>

	<input type="hidden" id="selectedIds" name="selectedIds" />
	<script type="text/javascript" src="<%=basePath %>common/js/ln.cookies.config.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/tree.js"></script>
	<script type="text/javascript" src="<%=basePath %>common/js/tree/js/jquery.contextMenu.js"></script>

    <script language="javascript" type="text/javascript">	
		var orgData = ${nodeList};

		$(document).ready(function(){
				var o = {
					cbiconpath: '<%=path%>/common/js/tree/images/tree/',
					title:'角色信息',	
					showcheckbox : true,
					showcheck : true,
					cascadecheck : true,
					oncheckboxclick : false,
					theme : "bbit-tree-lines",
					isShowBase:false,
					contextMenu:false,
					cookieName:"bigTree",
					onnodeclick:function(org){
					},
					onaftercheckboxclick : function(org){
						changeChecked();
					},
					data: orgData
				}; 
				init(o);
				$("#bigTreeDiv").treeview(o);
				// 默认初始化
				changeChecked();
			//bindTree();
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

		var id = '${vo.id}';
		function saveRoleMenu(){
			if(id==''){
				fh.alert("请先选择用户信息!");
			}

			var selectedIdArray = $("#bigTreeDiv")[0].t.getSelectedIds();

			var selectedIds ="";
			$.each(selectedIdArray,function(i,item){
		        if(item != ''){
		            selectedIds += item;
		        }
		    });

			$.ajax({
				type: "POST", 
				url: "<%=basePath %>userrole/saveUserRole.htm?orgCode=${vo.orgCode}&id=${vo.id}",
				data: "entityIds="+selectedIds,
				beforeSend: function(){
	               //window.parent.showInfo();
	            },
				success: function(msg){
					//fh.alert('赋权成功');
					try{
						fh.success('赋权成功',this,this);
					}catch(e){
						fh.success('赋权成功');
					}
					//alert('赋权成功');
				}
			});
			
			return;
		}

		
	</script>

</body>
</html>


