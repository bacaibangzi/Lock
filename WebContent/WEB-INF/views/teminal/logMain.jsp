<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
%>
<html>

<body>
	<input type="hidden" id="entityIds" name="entityIds" />
	<input type="hidden" id="code" value="${code}" />
    <div class="contenbox">
			<br>
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>流水号</th>
						<th>操作者</th>
						<th>操作内容</th>
						<th>操作时间</th>
						<th>IP</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
    
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		var reLoad ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>devLog/list.htm";
			tableObj.bPanination = false;
			tableObj.jbm = 'jbm';
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"sn","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"50"},
				{"mDataProp":"user","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"context","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"date","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"ip","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
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
  				var url ="<%=basePath%>materialUnit/list.htm";
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
  			
		});


		
		function add1()
		{
			var commonDialog = commonOpenDialog("readDetail",'编辑配送规格',700,450, '<%=basePath%>materialUnit/eidt.htm');
			commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
			commonDialog.addBtn("ok",'确定', function()
			{
				var code = $("#code", commonDialog.dgDoc).val();
				var name = $("#name", commonDialog.dgDoc).val();
				if(""==code){
					fh.alert("规格编码不能为空!");
					return false;
				}else if(""==name){
					fh.alert("规格名称不能为空!");
					return false;
				}

				$.ajax({ 
					type: "POST", 
					url: '<%=path %>/materialUnit/save.htm', 
					data: "name=" + name + 
					 	  "&code=" + code+
					 	  "&orgCode=${vo.orgCode}",
					success: function(msg){
						if(msg == "true"){
							fh.alert('<spring:message code="system.oper.success" />', false, function(){
								commonDialog.cancel();
								window.location.reload();
							});
						}else if(msg == "duplicate"){
							fh.alert('规格编号重复！');
						}else{
							fh.alert('<spring:message code="system.oper.failture" />');
						}
					}
				});
			});
			
		}
		
		/** 修改方法 **/
		function update()
		{
			var data=$(".Js_tdMenu").data("data");
			var selectId = data.idStr;
			//window.location = "<%=basePath%>materialUnit/eidt.htm?code=${vo.code}&entityId="+selectId; 
			var commonDialog = commonOpenDialog("readDetail",'编辑配送规格',700,450, '<%=basePath%>materialUnit/eidt.htm?entityId='+selectId);
			commonDialog.addBtn("cancel",'取消', commonDialog.cancel);
			commonDialog.addBtn("ok",'确定', function()
			{
				var code = $("#code", commonDialog.dgDoc).val();
				var name = $("#name", commonDialog.dgDoc).val();
				var sn = $("#sn", commonDialog.dgDoc).val();

				if(""==code){
					fh.alert("规格编码不能为空!");
					return false;
				}else if(""==name){
					fh.alert("规格名称不能为空!");
					return false;
				}
				$.ajax({ 
					type: "POST", 
					url: '<%=path %>/materialUnit/save.htm', 
					data: "code=" + code + 
					 	  "&name=" + name+
					 	  "&sn=" + sn+
					 	  "&orgCode=${vo.orgCode}",
					success: function(msg){
						if(msg == "true"){
							fh.alert('<spring:message code="system.oper.success" />', false, function(){
								commonDialog.cancel();
								window.location.reload();
							});
						}else if(msg == "duplicate"){
							fh.alert('规格编号重复！');
						}else{
							fh.alert('<spring:message code="system.oper.failture" />');
						}
					}
				});
			});
		}
		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>materialUnit/detail.htm?code=${vo.code}&entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var areaName_filter = $.trim(document.getElementById('areaName_filter').value);
			var returnVal = '<%=basePath%>org/list.htm?code=${vo.code}';
			returnVal += '&nameFilter=' + areaName_filter;
			return returnVal;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>materialUnit/delete.htm?code=${vo.code}&entityIds=";
			//batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
			batchDeleteAjax({rows:rows,idField:"idStr",actionUrl:actionUrl}, function(flag){
				if(flag){
					reLoad();
				}else{
					fh.alert("规格已被引用，不能删除！");
				}
			});
		}
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

