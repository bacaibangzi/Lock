<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
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
							终端名称
						</label>
						<input type="text" class="filter-text" id="name" />
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							终端编号
						</label>
						<input type="text" class="filter-text" id="name1" />
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							控制器名称
						</label>
						<select name="name2"  class="filter-select"  id="name2"  >
							<c:forEach items="${controllerinfoMap}" var="item">
								 <option value="${item.key}">${item.value}</option>
							</c:forEach>
						</select>
					</li>
					
					<li class="filter-item">
						<label class="filter-label">
							备注
						</label>
						<input type="text" class="filter-text" id="name3" />
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
						<th>控制器名称</th>
						<th>终端编号</th>
						<th>终端名称</th>
						<th>终端类型</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
    </div>
        <div class="rightMenu bodyMenu Js_tdMenu">
        </div> 
	</body>
	    <!-- 日期控件 -->
	<script type="text/javascript" src="<%=path%>/common/js/datapicker/WdatePicker.js"></script>
	<script type="text/javascript">
		var datatable ;
		$(document).ready(function(){
			var tableObj={}
			tableObj.url="<%=basePath%>devDoorTeminal/terminalinfoList.htm";
			tableObj.bPanination = false;
			tableObj.aoColumns=[
				{"mDataProp":"","sDefaultContent":"<input type='checkbox' />","bSortable":false,"sWidth":"20px",sClass:"checkbox"},
				{"mDataProp":"controllerName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"terminalId","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"terminalName","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"devModelStr","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"},
				{"mDataProp":"remark","sDefaultContent": "","bSortable":false,"sClass":"text-align-mid","sWidth":"100"}
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
			
			$(":checkbox").live("change",function(obj){
  				var rows=getSeleteObjs(datatable);
  				var selIds = '';
  				for (var i = 0; i < rows.length; i++) {
  					selIds += rows[i]['terminalId'] + ',';
  				}
  				$("#materialStockSelect").val(selIds);
  				//changeNums(tableObj);
  		  	})	
			
			
			$("td").live("click",function(obj){
  				var rows=getSeleteObjs(datatable);
  				var selIds = '';
  				for (var i = 0; i < rows.length; i++) {
  					selIds += rows[i]['terminalId'] + ',';
  				}
  				$("#materialStockSelect").val(selIds);
  				//changeNums(tableObj);
  		  	})	
			
		});

		function highQuery()
		{//alert();
			// 查询条件 区域名称
			var name = $.trim(document.getElementById('name').value);
			var name1 = $.trim(document.getElementById('name1').value);
			var name2 = $.trim(document.getElementById('name2').value);
			var name3 = $.trim(document.getElementById('name3').value);
			
			var returnVal = '<%=basePath%>devDoorTeminal/terminalinfoList.htm?orgCode=${vo.orgCode}';
			if(name!=''){
				returnVal += '&code=' + encodeURI(encodeURI(name));
			}
			if(name1!='')
			{
				returnVal += '&code1=' + encodeURI(encodeURI(name1));
			}
			if(name2!='')
			{
				returnVal += '&code2=' + encodeURI(encodeURI(name2));
			}
			if(name3!='')
			{
				returnVal += '&code3=' + encodeURI(encodeURI(name3));
			}
			return returnVal;
		}
		 
	</script>
		
</html>
<script type="text/javascript">
	document.body.style.backgroundColor="white";
</script>

