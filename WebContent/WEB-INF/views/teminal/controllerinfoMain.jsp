<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
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
	<input type="hidden" id="materialStockSelect" value="" />
	<input type="hidden" id="materialStockNums" value="" />
    <div class="contenbox">
    	<div class="grid_summay_opts" id="btns">
			</div>
			<div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav"><spring:message code="system.searchnav" /></a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							控制器名称
						</label>
						<input type="text" class="filter-text" id="areaName_filter" />
					</li>
					<li class="filter-item filter-btns">
						<a hideFocus="true" class="gray_radiu_btn Js_searchTable">
							 <em class="gray_l"></em> 
							 <em class="gray_r"></em> 
							 <spring:message code="system.query" />
						</a>
						<a hideFocus="true" href="javascript:clearForm('filter-mod');" id="add" class="gray_radiu_btn Js_reLoadTable"> 
							<em class="gray_l"></em> 
							<em class="gray_r"></em> 
							<spring:message code="system.clear" />
						 </a>
					</li>
				</ul> 
			</div>
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>控制器编号</th>
						<th>控制器名称</th>
						<th>站点名称</th>
						<th>信道</th>
						<th>控制器IP</th>
						<th>控制器端口</th>
						<th>位置</th>
						<th>是否启用</th>
						<th>备注</th>
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
            </ul>
        </div> 
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>controllerinfo/list.htm?code=${vo.code}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"controllerId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"controllerName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"stationName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"channel","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"ip","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"port","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"position","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"isUseStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"remark","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"applyNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100" ,
					fnRender: function(value,row,index) {
				  	return '<input type="button"  value="测试通讯" onClick="sc()"> <input type="button" onClick="sp()"  value="SP"> <input type="button" onClick="mp()"  value="门锁状态"> <input type="button" onClick="vd()"  value="测试中继">';
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
			 
			
		});
		
		
		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var areaName_filter = $.trim(document.getElementById('areaName_filter').value);
			var returnVal = '<%=basePath%>controllerinfo/list.htm?code=${vo.code}';
			if(areaName_filter!=''){
				returnVal += '&nameFilter=' + encodeURI(encodeURI(areaName_filter));
			}
			return returnVal;
		}
		
		function sc(){
			fh.confirm("确认SC",function(){
				 
			},null,null);
		}
		
		function sp(){
			var spDialog = commonOpenDialog("numDialog",'sp',460,320, '<%=basePath%>controllerinfo/toSp.htm?orgCode=${sessionScope.accountInfo.orgCode}');
			spDialog.addBtn("ok",'确定', function()
			{

				
				
			});	
		}
		
		function mp(){
			var mpDialog = commonOpenDialog("numDialog",'sp',460,320, '<%=basePath%>controllerinfo/toMp.htm?orgCode=${sessionScope.accountInfo.orgCode}');
			mpDialog.addBtn("ok",'确定', function()
			{

				
				
			});
		}
		
		function vd(){
			fh.confirm("确认VD",function(){
				 
			},null,null);

		}

		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>controllerinfo/detail.htm?code=${vo.code}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
	</script>
		
</html>
<script type="text/javascript">
	document.body.style.backgroundColor="white";
</script>

