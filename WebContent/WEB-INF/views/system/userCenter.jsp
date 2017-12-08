<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/include/includejs.jsp" />
<%
	//新增按钮
	String addMenu = "7802783440559203414";
	//修改
	String updateMenu = "7291201182524030468";
	//删除
	String delMenu = "6610433833513736115";
	//查看
	
%>
<html>

<body>
	<input type="hidden" id="entityIds" name="entityIds" />
	<input type="hidden" id="code" value="${code}" />
    <div class="contenbox">
    	<div class="grid_summay_opts" id="btns">
				<div class="left_opts">
						<a hideFocus="true" href="javascript:add1('<%=basePath%>user/eidt.htm?orgCode=${vo.orgCode}')" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							新增
						</a>
						
						<a hideFocus="true" href="javascript:sh();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							启用
						</a>
						
						<!--  
						<a hideFocus="true" href="javascript:qxSh();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							取消审核
						</a>
						-->
						
						<a hideFocus="true" href="javascript:ty();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							禁用
						</a>
				</div>
				<div class="right_opts">
					<sec:authorize ifAnyGranted="<%=delMenu %>">
						<a hideFocus="true" href="javascript:deleteAll();" class="gray_radiu_btn" >
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							删除
						</a>
					</sec:authorize>
				</div>
			</div>
			<div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav">展开查询条件</a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							用户名称
						</label>
						<input type="text" class="filter-text" id="areaName_filter" value="${vo.nameFilter}"/>
					</li>
					<li  class="filter-item">
						<label class="filter-label">
							状态
						</label>
						<select name="sh_filter"  class="filter-select"  id="sh_filter"  >
							<c:forEach items="${shMap}" var="item">
								 <option value="${item.key}">${item.value}</option>
							</c:forEach>
						</select>
					</li>
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							 查询
						</a>
						<a hideFocus="true" href="javascript:clearForm('filter-mod');" id="add" class="gray_radiu_btn Js_reLoadTable"> 
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							清除
						 </a>
					</li>
				</ul> 
			</div>
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>编号</th>
						<th>登录名称</th>
						<th>用户名称</th>
						<!--  <th>所属权组</th>-->
						<th>性别</th>
						<th>手机号码</th>
						<th>邮箱</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
        <div class="rightMenu bodyMenu Js_tdMenu">
            <!--存储当前点击行的数据-->
            <input type="hidden" class="Js_curIndex" value="" />
            <ul>
                <li><a hideFocus="true" href="javascript:detail()">查看</a></li>
                <li><a hideFocus="true" href="javascript:update()">修改</a></li>
                <li><a hideFocus="true" href="javascript:disRole()">分配权限</a></li>
               <li><a hideFocus="true" href="javascript:disOrg()">限制门组权限</a></li>
            </ul>
        </div> 
	</body>
	<!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		var reLoad ;
		$(document).ready(function(){
			var tableObj={}
			//tableObj.url="<%=basePath%>user/list.htm?orgCode=${vo.orgCode}";
			tableObj.url = highQuery();
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"uiId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiLoginName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			//	{"mDataProp":"uiNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiSexStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiMobile","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiEmail","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiShStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"uiId1","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"300" ,
					fnRender: function(value,row,index) {
				  	return "<input type='button' onClick='qiy(\""+row+"\")'  value='启用'> <input type='button'  value='禁用' onClick='jiny(\""+row+"\")'>  <input type='button' onClick='xiug(\""+row+"\")'  value='修改'>  <input type='button' onClick='shanc(\""+row+"\")'  value='删除'> ";
				}}
			];
			//添加额外的参数
			tableObj.fnServerParams= function ( aoData ) 
			{
    			aoData.push( { "name": "default_param", "value": "desc"} );
  			}
  			
  			datatable=datatableObj(tableObj);
  			//serach
  			$(".Js_searchTable").live("click",function()
  		  	{
				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
			})

			reLoad = function(){
  				var url = highQuery();
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
		});

		/** 修改方法 **/
		function update()
		{
			var data=$(".Js_tdMenu").data("data");
			var selectId = data.idStr;
			window.location = "<%=basePath%>user/eidt.htm?orgCode=${vo.orgCode}&entityId="+selectId; 
		}
		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>user/detail.htm?orgCode=${vo.orgCode}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var areaName_filter = $.trim(document.getElementById('areaName_filter').value);
			var sh_filter = $.trim(document.getElementById('sh_filter').value);
			var returnVal = '<%=basePath%>user/list.htm?orgCode=${vo.orgCode}&code=1';
			if(areaName_filter!=''){
				returnVal += '&nameFilter=' + encodeURI(encodeURI(areaName_filter));
			}
			if(sh_filter!='-1')
			{
				returnVal += '&shFilter=' + encodeURI(encodeURI(sh_filter));
			}
			return returnVal;
		}
		function loadQuery()
		{
			
		}
		function add1(url){
			/*
			alert("${vo.orgCode}");
			if("${vo.orgCode}"==""){
				fh.alert("请选择部门");
				return;
			}*/
			location = url;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>user/delete.htm?orgCode=${vo.orgCode}&entityIds=";
			//batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
			batchDeleteAjax({rows:rows,idField:"idStr",actionUrl:actionUrl}, function(flag){
				if(flag){
					reLoad();
				}else{
					fh.alert("只能删除未审核用户!");
				}
			});
		}
		/**审核**/
		function sh()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>user/sh.htm?orgCode=${vo.orgCode}&value=1&entityIds=";
			//batchDoIt( {rows:rows,idField:"idStr",actionUrl:actionUrl},"审核");

			batchDoAjax({rows:rows,idField:"idStr",actionUrl:actionUrl}, function(flag){
				if(flag){
					reLoad();
				}
			},"启用");
			
		}
		/**取消审核**/
		function qxSh()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>user/sh.htm?orgCode=${vo.orgCode}&value=0&entityIds=";
			//batchDoIt( {rows:rows,idField:"idStr",actionUrl:actionUrl},"取消审核");
			batchDoAjax({rows:rows,idField:"idStr",actionUrl:actionUrl}, function(flag){
				if(flag){
					reLoad();
				}
			},"取消审核");
		}

		/**停用**/
		function ty()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>user/sh.htm?orgCode=${vo.orgCode}&value=9&entityIds=";
			//batchDoIt( {rows:rows,idField:"idStr",actionUrl:actionUrl},"停用");
			batchDoAjax({rows:rows,idField:"idStr",actionUrl:actionUrl}, function(flag){
				if(flag){
					reLoad();
				}
			},"禁用");
		}

		//<%=basePath %>userrole/rightTree.htm?orgCode=${orgCode}&id="+id;
		function disRole()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'分配权限',700,450, '<%=basePath %>userrole/rightTree.htm?orgCode=${orgCode}&id=' + selectId,null);
			commonDialog.addBtn("cancel",'关闭', commonDialog.cancel);
			commonDialog.addBtn("ok",'保存用户权限', function(){
				var selectedIds = $("#selectedIds", commonDialog.dgDoc).val();
				$.ajax({
					type: "POST", 
					url: "<%=basePath %>userrole/saveUserRole.htm?orgCode=${orgCode}&id="+selectId,
					data: "entityIds="+selectedIds,
					beforeSend: function(){
		               //window.parent.showInfo(); 
		            },
					success: function(msg){
						fh.alert('赋权成功');
						commonDialog.cancel(); 
					}
				});				
			}); 
		}
 
		function disOrg()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			var commonDialog = commonOpenDialog("readDetail",'限制门组权限',700,450, '<%=basePath %>userOrgs/orgTree.htm?orgCode=${sessionScope.accountInfo.orgCode}&userId=' + selectId,null);
			commonDialog.addBtn("cancel",'关闭', commonDialog.cancel);
			commonDialog.addBtn("ok",'确定', function(){
				var selectedIds = $("#selectedIds", commonDialog.dgDoc).val();
				$.ajax({
					type: "POST", 
					url: "<%=basePath %>userOrgs/saveUserOrgs.htm?orgCode=${sessionScope.accountInfo.orgCode}&userId="+selectId,
					data: "entityIds="+selectedIds,
					beforeSend: function(){
		               //window.parent.showInfo(); 
		            },
					success: function(msg){
						fh.alert('保存成功');
						commonDialog.cancel();
					}
				});
				
			}); 
		}
		
		
		function qiy(ids){
			fh.confirm("确认启用吗?",function(){
				$.ajax({
					url:'<%=basePath%>user/sh.htm?orgCode=${vo.orgCode}&value=1',
					type:'post',
					async: false,
					data:'entityIds='+ids,
					success:function(data){

						reLoad();
					}
				});
			},null,null);
			
		}
		
		function jiny(ids){
			fh.confirm("确认禁用吗?",function(){
				$.ajax({
					url:'<%=basePath%>user/sh.htm?orgCode=${vo.orgCode}&value=9',
					type:'post',
					async: false,
					data:'entityIds='+ids,
					success:function(data){

						reLoad();
					}
				});
			},null,null);
		}
		
		function xiug(value){
			var selectId = value;
			window.location = "<%=basePath%>user/eidt.htm?orgCode=${vo.orgCode}&entityId="+selectId; 
		}
		
		function shanc(ids){
			fh.confirm("确认删除吗?",function(){
				$.ajax({
					url:'<%=basePath%>user/delete.htm?orgCode=${vo.orgCode}&value=9',
					type:'post',
					async: false,
					data:'entityIds='+ids,
					success:function(data){

						reLoad();
					}
				});
			},null,null);
		}
	</script>
		 
</html>

<script language="javascript" type="text/javascript">
           
</script>

