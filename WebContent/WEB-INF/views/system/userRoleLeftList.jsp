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
						<th>员工编号</th>
						<th>员工姓名</th>
						<th>手机号码</th>
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
			tableObj.url="<%=basePath%>userrole/list.htm?orgCode=${sessionScope.accountInfo.orgCode}&code=1";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
			    {"mDataProp":"uiId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"uiName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
			    {"mDataProp":"uiMobile","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}			
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
					fh.alert("请显示角色编号!");
					return;
				}
				window.parent["group_info"].location="<%=basePath %>userrole/rightTree.htm?orgCode=${orgCode}&id="+id;
			})
			
			/** 按条件查询 **/
			function highQuery()
			{
				// 查询条件 区域名称
				var areaName_filter = $.trim(document.getElementById('areaName_filter').value);
				var returnVal = '<%=basePath%>userrole/list.htm?orgCode=${sessionScope.accountInfo.orgCode}&code=1';
				if(areaName_filter!=''){
					returnVal += '&nameFilter=' + encodeURI(encodeURI(areaName_filter));
				}
				return returnVal;
			}
		});


	</script>
		
</html>

<script language="javascript" type="text/javascript">
           
</script>

