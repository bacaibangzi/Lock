<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    
    		
			<table cellpadding="0" cellspacing="0" border="0" id="grid-table" width="100%" class="common_table Js_contextMenuOpt">
				<thead>
					<tr>
						<th>服务编号</th>
						<th>服务名称</th>
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
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>distributor/list.htm?orgCode=${sessionScope.accountInfo.orgCode}";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"riId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"50"},
				{"mDataProp":"riName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
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

			
			datatable.find("td").live("click",function(obj)
			{
				var tdSeq = $(this).parent().find("td").index($(this));
		        var trSeq = $(this).parent().parent().find("tr").index($(this).parent());
		       	//alert("第" + (trSeq) + "行，第" + (tdSeq+1) + "列");
		       	var id =  $(this).parent().children().eq(0).text();
				if(isNaN(id))
				{
					fh.alert("请显示服务编号!");
					return;
				}
				window.parent["group_info"].location="<%=basePath %>distributorMenu/rightTree.htm?orgCode=${orgCode}&id="+id;
			})
		});

		/** 修改方法 **/
		function update()
		{
			var data=$(".Js_tdMenu").data("data");
			var selectId = data.idStr;
			window.location = "<%=basePath%>role/eidt.htm?entityId="+selectId; 
		}
		/** 查看详情 **/
		function detail()
		{
			var data=$(".Js_tdMenu").data("data")
			var selectId = data.idStr;
			// 明细弹出框
			var commonDialog = commonOpenDialog("readDetail",'详细',700,450, '<%=basePath%>role/detail.htm?entityId=' + selectId);
			commonDialog.addBtn("ok",'确定', commonDialog.cancel);
		}
		/** 按条件查询 **/
		function highQuery()
		{
			// 查询条件 区域名称
			var areaName_filter = $.trim(document.getElementById('areaName_filter').value);
			var returnVal = '<%=basePath%>server/list.htm?orgCode=${sessionScope.accountInfo.orgCode}';
			returnVal += '&nameFilter=' + areaName_filter;
			return returnVal;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>org/delete.htm?code=${vo.code}&entityIds=";
			batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
		}
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

