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
    
    	<button onclick="showOrgTree()">选择部门</button>
    	
    	<div class="sprite_mod">
				<a class="Js_showSearch mod_opts" hidfocus="true" id="searchnav">展开查询条件</a>
			</div>
    
    
    		<!-- 表格列表过滤条件设置 -->
			<div class="filter-mod">
				<ul class="filter-list">
					<li class="filter-item">
						<label class="filter-label">
							姓名
						</label>
						<input type="text" class="filter-text" id="txt1" />
					</li>
					<li class="filter-item">
						<label class="filter-label">
							工号
						</label>
						<input type="text" class="filter-text" id="txt2" />
					</li>
					<!--  
					<li class="filter-item">
						<label class="filter-label">
							卡号
						</label>
						<input type="text" class="filter-text" id="txt3" />
					</li>
					-->
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
						<th>编号</th>
						<th>部门</th>
						<th>工号</th>
						<th>姓名</th>
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
			tableObj.url="<%=basePath%>yonghu/list.htm";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
			    	{"mDataProp":"uiId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"50"},
			    	{"mDataProp":"bm","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
					{"mDataProp":"uiNum","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    	{"mDataProp":"uiName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
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
					fh.alert("请显示用户编号!");
					return;
				}
				window.parent["group_info"].location="<%=basePath %>devUserCard/rightList.htm?orgCode=${orgCode}&code="+id;
			})
			
			reLoad = function(url){ 
				tableObj.url  = url;
				datatable = datatableObj(tableObj);
  			}
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
			var code1 = $.trim(encodeURI(encodeURI(document.getElementById('txt1').value)));
			var code2 = $.trim(encodeURI(encodeURI(document.getElementById('txt2').value)));
			var returnVal = '<%=basePath%>yonghu/list.htm?code1='+code1+'&code2='+code2;
			if(orgCode!='')
			returnVal += '&orgCode=' + orgCode;
			return returnVal;
		}
		/** 删除**/
		function deleteAll()
		{
			var rows=getSeleteObjs(datatable);
			var actionUrl = "<%=basePath%>org/delete.htm?code=${vo.code}&entityIds=";
			batchDelete( {rows:rows,idField:"idStr",actionUrl:actionUrl});
		}
		
		var orgCode = "";
		var orgName = "";
		function showOrgTree()
		{
			var mdDialog = commonOpenDialog("mdDialog",'选择组织',700,450, '<%=basePath%>caipxfmx/orgTree.htm?orgCode=0000');

			/**/
			mdDialog.addBtn("cancel",'取消', mdDialog.cancel);
			mdDialog.addBtn("ok",'确定', function()
			{
				orgCode = $("#orgCode", mdDialog.dgDoc).val();
				orgName = $("#orgName", mdDialog.dgDoc).val();

				//document.getElementById('examineOrgCode').value = orgCode;
				//document.getElementById('examineOrgName').value = orgName;
				
				var returnVal = '<%=basePath%>yonghu/list.htm?orgCode='+orgCode;
				reLoad(returnVal);
				mdDialog.cancel();
			});
		}
	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

